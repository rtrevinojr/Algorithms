package data_structures;

public class MyHashMap <K, V> {
	
	class Entry<K, V> {
	    final K key;
	    V value;
	    Entry<K, V> next;
	    public Entry(K key, V value, Entry<K, V> next) {
	        this.key = key;
	        this.value = value;
	        this.next = next;
	    }
	    // getters, equals, hashCode and toString
	    
	    public String toString () {
	    	String result = "";
	    	Entry <K, V> entry = this;
	    	while (entry.next != null) {
	    		result += "[" + entry.key.toString() 
	    				+ "(" + entry.key.hashCode() + "): "
	    					+ entry.value.toString() + "], ";
	    		entry = entry.next;
	    	}
	    	result += "[" + entry.key.toString() 
    				+ "(" + entry.key.hashCode() + "): "
    					+ entry.value.toString() + "] ";
	    	return result;
	    }
	}

	
	private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 1 << 4; // 16
    private int size = 0;
    
    public MyHashMap() {
        this(INITIAL_CAPACITY);
    }
    
    public MyHashMap(int capacity) {
        this.buckets = new Entry[capacity];
    }
    
    public int getBucketSize () {
    	return buckets.length;
    }
    
    public int getHash(K key) {
    	return key.hashCode();
    }
    

	public V get(K key) {
	    Entry<K, V> bucket = buckets[getHash(key) % getBucketSize()];
	    while (bucket != null) {
	        if (bucket.key.equals(key)) {
	            return bucket.value;
	        }
	        bucket = bucket.next;
	    }
	    return null;
	}
    
    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value, null);
        int bucket = getHash(key) % getBucketSize();
        bucket = Math.abs(bucket);
        Entry<K, V> existing = buckets[bucket];
        if (existing == null) {
            buckets[bucket] = entry;
            size++;
        } else {
            // compare the keys see if key already exists
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }
            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
                size++;
            }
        }
    }
    
    public void printList (Entry <K, V> entry) {
    	
    	while (entry != null) {
    		System.out.print(entry.toString() + " ");
    		entry = entry.next;
    	}
    	System.out.println();
    }
    
    public void printBuckets () {
    	
    	int index = 0;
    	
    	for (Entry <K, V> entry : this.buckets) {
    		if (entry != null)
    			System.out.println(index + " = " + entry.toString());
    		else 
    			System.out.println(index + " = NULL ");
    		index++;
    	}
    	System.out.println();
    }
    
    
    public static void main (String [] args) {
    	
    	System.out.println("MyHashMap.java");
    	
    	MyHashMap <String, Integer> map = new MyHashMap <> ();
/*    	map.put (1, "one");
    	map.put(1, "one1");
    	map.put(0, "zero");
    	map.put(2, "two");
    	map.put(3, "three");
    	map.put(4, "four");
    	map.put(5, "five");
    	map.put(6, "six");
    	map.put(7, "seven");
    	map.put(8, "eight");
    	map.put(9, "nine");
    	map.put(11, "one one");
    	map.put(10, "one zero");
    	map.put(12, "one two");
    	map.put(13, "one three");
    	map.put(14, "fourteen");
    	map.put(15, "fiveteen");
    	map.put(16, "sixteen");
    	map.put(17, "seventeen");
    	map.put(18, "eightteen");
    	map.put(19, "nineteen");*/
    	
    	
    	map.put ("a", 1);
    	map.put("aa", 11);
    	map.put("b", 2);
    	map.put("c", 3);
    	map.put("d", 4);
    	map.put("e", 5);
    	map.put("f", 6);
    	map.put("g", 7);
    	map.put("h", 9);
    	map.put("i", 10);
    	map.put("j", 11);
    	map.put("k", 12);
    	map.put("l", 13);
    	map.put("m", 14);
    	map.put("n", 15);
    	map.put("o", 16);
    	map.put("p", 17);
    	map.put("q", 18);
    	map.put("w", 19);
    	map.put("x", 20);
    	map.put("y", 21);
    	map.put("z", 22);
    	
    	map.put("aaa", 111);
    	map.put("aaaa", 1111);
    	map.put("aaaaa", 11111);
    	map.put("aaaaaa", 111111);
    	map.put("aaaaaaa", 1111111);
    	map.put("aaaaaaaa", 1111111);
    	
    	map.put("hectorrenetrevinojr", 13);
    	
    	map.printBuckets();
    	
    	Integer result = map.get("aa");
    	
    	System.out.println("Map.get 19 = " + result);
    	
    	
    	
    }
    
    
}

