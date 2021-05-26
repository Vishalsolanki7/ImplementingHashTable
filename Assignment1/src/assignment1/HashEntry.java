package assignment1;

    class HashEntry
    {
        Long element;   // the element
        Long value;
        boolean  isActive;  // false is deleted

        public HashEntry( Long e, Long v )
        {
            this( e, v, true );
        }

        public HashEntry( Long e, Long v, boolean i )
        {
        	value	  = v;
            element   = e;
            isActive  = i;
        }
    }