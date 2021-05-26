package assignment1;

import java.util.Random;

/**
 * Cuckoo hash table implementation of hash tables.
 *
 */
public class CuckooHashing {
    /**
     * Constructing the hash table.
     */
    public CuckooHashing(HashMethods hf) {
        this(hf, DEFAULT_TABLE_SIZE);
    }

    /**
     * Construct the hash table.
     *
     * @param hf   the hash family
     * @param size the approximate initial size.
     */
    public CuckooHashing(HashMethods hf, int size) {
        allocateArray(nextPrime(size));
        doClear();
        hashFunctions = hf;
        numHashFunctions = hf.getNumberOfFunctions();
    }

    private Random r = new Random();

    private static final double MAX_LOAD = 0.40;
    private static final int ALLOWED_REHASHES = 1;

    private int rehashes = 0;

    private boolean insertHelper1(String x) {
        final int COUNT_LIMIT = 100;

        while (true) {
            int lastPos = -1;
            long pos;

            for (int count = 0; count < COUNT_LIMIT; count++) {
                for (int i = 0; i < numHashFunctions; i++) {
                    pos = myhash(x, i);

                    if (array[(int) pos] == null) {
                        array[(int) pos] = x;
                        currentSize++;
                        return true;
                    }
                }

                // none of the spots are available. Kick out a random one
                int i = 0;
                do {
                    pos = myhash(x, r.nextInt(numHashFunctions));
                } while (pos == lastPos && i++ < 5);

                String tmp = array[lastPos = (int) pos];
                array[(int) pos] = x;
                x = tmp;
            }

            if (++rehashes > ALLOWED_REHASHES) {
                expand();      // Make the table bigger
                rehashes = 0;
            } else
                rehash();
        }
    }

    private boolean insertHelper2(String x) {
        final int COUNT_LIMIT = 100;

        while (true) {
            for (int count = 0; count < COUNT_LIMIT; count++) {
                int pos = (int) myhash(x, count % numHashFunctions);

                String tmp = array[pos];
                array[pos] = x;

                if (tmp == null)
                    return true;
                else
                    x = tmp;
            }

            if (++rehashes > ALLOWED_REHASHES) {
                expand();      // Make the table bigger
                rehashes = 0;
            } else
                rehash();
        }
    }

    /**
     * Insert into the hash table. If the item is
     * already present, return false.
     *
     * @param x the item to insert.
     */
    public boolean insert(String x) {
        if (find(x))
            return false;

        if (currentSize >= array.length * MAX_LOAD)
            expand();

        return insertHelper1(x);
    }

    private long myhash(String x, int which) {
        long hashVal = hashFunctions.hash(x, which);

        hashVal %= array.length;
        if (hashVal < 0)
            hashVal += array.length;

        return hashVal;
    }

    private void expand() {
        rehash((int) (array.length / MAX_LOAD));
    }

    private void rehash() {
        //System.out.println( "NEW HASH FUNCTIONS " + array.length );
        hashFunctions.generateNewFunctions();
        rehash(array.length);
    }

    private void rehash(int newLength) {
        //System.out.println( "REHASH: " + array.length + " " + newLength + " " + currentSize );
        String[] oldArray = array;    // Create a new double-sized, empty table

        allocateArray(nextPrime(newLength));

        currentSize = 0;

        // Copy table over
        for (String str : oldArray)
            if (str != null)
                insert(str);
    }


    /**
     * Gets the size of the table.
     *
     * @return number of items in the hash table.
     */
    public int size() {
        return currentSize;
    }

    /**
     * Gets the length (potential capacity) of the table.
     *
     * @return length of the internal array in the hash table.
     */
    public int capacity() {
        return array.length;
    }

    /**
     * Method that searches all hash function places.
     *
     * @param x the item to search for.
     * @return the position where the search terminates, or -1 if not found.
     */
    private int findPos(String x) {
        for (int i = 0; i < numHashFunctions; i++) {
            int pos = (int) myhash(x, i);
            if (array[pos] != null && array[pos].equals(x))
                return pos;
        }

        return -1;
    }

    /**
     * Remove from the hash table.
     *
     * @param x the item to remove.
     * @return true if item was found and removed
     */
    public boolean remove(String x) {
        int pos = findPos(x);

        if (pos != -1) {
            array[pos] = null;
            currentSize--;
        }

        return pos != -1;
    }

    /**
     * Find an item in the hash table.
     *
     * @param x the item to search for.
     * @return the matching item.
     */
    public boolean find(String x) {
        return findPos(x) != -1;
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty() {
        doClear();
    }

    private void doClear() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++)
            array[i] = null;
    }


    private static final int DEFAULT_TABLE_SIZE = 101;

    private final HashMethods hashFunctions;
    private final int numHashFunctions;
    private String[] array; // The array of elements
    private int currentSize;              // The number of occupied cells

    /**
     * Method to allocate array.
     */
    private void allocateArray(int arraySize) {
        array = new String [arraySize];
    }

    /**
     * Method to find a prime number at least as large as n.
     */
    protected static int nextPrime(int n) {
        if (n % 2 == 0)
            n++;

        while (!isPrime(n)) {
            n += 2;
        }
        return n;
    }

    /**
     * Method to test if a number is prime.
     */
    private static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;

        if (n == 1 || n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;

        return true;
    }
}