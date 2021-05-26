package assignment1;

import java.util.Random;

public class StringHashMethods implements HashMethods
{
    private final long [ ] MULTIPLIERS;
    private final Random r = new Random( );

    public StringHashMethods(int d)
    {
        MULTIPLIERS = new long [ d ];
        generateNewFunctions( );
    }
    public int getNumberOfFunctions( )
    {
        return MULTIPLIERS.length;
    }

    public void generateNewFunctions( )
    {
        for( int i = 0; i < MULTIPLIERS.length; i++ )
            MULTIPLIERS[ i ] = r.nextInt( );
    }

    public long hash( String input, int index )
    {
        final long multiplier = MULTIPLIERS[ index ];
        long hashVal = 0;

        for( int i = 0; i < input.length( ); i++ )
            hashVal = multiplier * hashVal + input.charAt( i );

        return hashVal;
    }
}