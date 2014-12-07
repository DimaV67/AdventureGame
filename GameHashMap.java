import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class GameHashMap<E> {
    // for simplicity size is taken as 2^4
    private static final int SIZE = 16;
    private Object[] table = new Object[SIZE];
 
    List <String> ar = new ArrayList <String>();
    int index=0;
    
 
    /**
     * Returns the entry associated with the specified key in the
     * HashMap.  Returns null if the HashMap contains no mapping
     * for the key.
     */
    @SuppressWarnings("unchecked")
    public E get(String k) {
        int hash = Math.abs(k.hashCode() % SIZE);
        Entry<E> e = (Entry<E>) table[hash];
 
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
        Entry<E> e = (Entry<E>) table[hash];
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
                Entry<E> entryInOldBucket = new  Entry<E>(k, v);
                e.next = entryInOldBucket;
                ar.add(k);
               
            }
        } else {
            // new element in the map, hence creating new bucket
            Entry<E> entryInNewBucket = new Entry<E>(k, v);
           // entryInNewBucket.index = size;
            table[hash] = entryInNewBucket;
            ar.add(k); 
        }
    }
    
    public int size(){
    	
    	return ar.size();
    	
    }

   
    public boolean hasNext() {
        return ar.size()>index;
    }
    
    public E next() {
    	E tmp= null;
    	
        if(hasNext()) {
        	tmp=this.get(ar.get(index));
        	index++;
        }
		return tmp;
    }
    
    @SuppressWarnings("unchecked")
    public void Print()
    {
    	Entry<E> e= null;
    	String k=null;
    	for (int i=0;i<SIZE;i++){
    		e = (Entry<E>) table[i];
	    		while(e != null) {
	    			if (k!=e.key){
	    				k=e.key;
	    				System.out.print(e.key+" ");
	    			}
	    			 e = e.next;
	            }
    	}
    }
  
}