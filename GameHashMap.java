

public class GameHashMap<E> {
    // for simplicity size is taken as 2^5
    private static final int SIZE = 32;
    private Object[] table = new Object[SIZE];
    private int size=0;
 
    /**
     */
    class Entry {
        final String key;
        Object value;
        Entry next;
 
        Entry(String k, E v) {
            key = k;
            value = v;
        }

        @SuppressWarnings("unchecked")
        public E getValue() {
        	E e = (E) value;
            return e;
        }
 
        public void setValue(E value) {
            this.value = value;
        }
 
        public String getKey() {
            return key;
        }
    }
 
    /**
     * Returns the entry associated with the specified key in the
     * HashMap.  Returns null if the HashMap contains no mapping
     * for the key.
     */
    @SuppressWarnings("unchecked")
    public E get(String k) {
        int hash = Math.abs(k.hashCode() % SIZE);
        Entry e = (GameHashMap<E>.Entry) table[hash];
 
        // if bucket is found then traverse through the linked list and
        // see if element is present
        while(e != null) {
            if(e.key.equals(k)) {
                return (E) e.value;
            }
            e = e.next;
        }
        return null;
    }
 
    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     */
    @SuppressWarnings("unchecked")
    public void put(String k, E v) {
        int hash = Math.abs(k.hashCode() % SIZE);
        Entry e = (GameHashMap<E>.Entry) table[hash];
        if(e != null) {
            // it means we are trying to insert duplicate
            // key-value pair, hence overwrite the current
            // pair with the old pair
            if(e.key.equals(k)) {
                e.value = v;
            } else {
                // traverse to the end of the list and insert new element 
                // in the same bucket
                while(e.next != null) {
                    e = e.next;
                }
                Entry entryInOldBucket = new Entry(k, v);
                e.next = entryInOldBucket;
               
            }
        } else {
            // new element in the map, hence creating new bucket
            Entry entryInNewBucket = new Entry(k, v);
            table[hash] = entryInNewBucket;
            size++;
        }
    }
    
    public int size(){
    	
    	return size;
    	
    }
  
}