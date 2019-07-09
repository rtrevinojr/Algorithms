package playground;

import java.util.HashMap;

public class LRUCache {
	
	public int maxCacheSize;
	public HashMap <Integer, LinkedListNode> map;
	public LinkedListNode head = null;
	public LinkedListNode tail = null;
	
	
	public LRUCache (int cacheSize) {
		maxCacheSize = cacheSize;
		map = new HashMap <> ();
	}
	
	public String getValue (int key) {
	
		if (map.containsKey(key)) {
			LinkedListNode node = map.get(key);
			if (node != head) {
				removeFromLinkedList(node);
				insertAtFrontOfLinkedList (node);
			}
			return node.value;
		}
		
		return null;
	}
	
	public void setKeyValue (int key, String val) {
		
		if (map.containsKey(key)) {
			LinkedListNode node = map.get(key);
			removeFromLinkedList(node);
			node.value = val;
			insertAtFrontOfLinkedList(node);
			return;
		}
		
		if (map.size() >= maxCacheSize) {
			removeFromLinkedList (tail);
			LinkedListNode node = new LinkedListNode (key, val);
			insertAtFrontOfLinkedList(node);
			map.put(key, node);
		}
		else {
			LinkedListNode node = new LinkedListNode (key, val);
			insertAtFrontOfLinkedList(node);
			map.put(key, node);
		}
		
	}
	
	public boolean removeKey (int key) {
		
		if (map.containsKey(key)) {
			LinkedListNode node = map.get(key);
			removeFromLinkedList (node);
			map.remove(key);
			return true;
		}
		else return false;
	}
	
	public static class LinkedListNode {
		
		public LinkedListNode prev;
		public LinkedListNode next;
		public int key;
		public String value;
		public LinkedListNode (int key, String val) {
			this.key = key;
			this.value = val;
		}
	}
	
	public void insertAtFrontOfLinkedList (LinkedListNode item) {
		
		if (head == null && head == tail) {
			head = item;
			tail = item;
			head.prev = null;
			head.next = null;
		}
		else {
			head.prev = item;
			item.next = head;
			item.prev = null;
			head = item;
		}
	}
	
	public void removeFromLinkedList (LinkedListNode item) {
		
		if (head == tail && head == item) {
			head = null;
			tail = null;
		}
		else if (item == head) {
			LinkedListNode right = head.next;
			right.prev = null;
			head = right;
		}
		else if (item == tail) {
			LinkedListNode left = tail.prev;
			left.next = null;
			tail = left;
		}
		else {
			LinkedListNode right = item.next;
			LinkedListNode left = item.prev;
			right.prev = left;
			left.next = right;
		}
	}
	
	public void printLinkedList () {
		
		LinkedListNode node = head;
		if (node == null) {
			System.out.println("LinkedList is Empty");
		}
		while (node != null) {
			System.out.println("Node. key = " + node.key + " : value = " + node.value);
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main (String [] args) {
		
		System.out.println("LRUCache.java");
		
		LRUCache cache = new LRUCache(5);
		
/*		LinkedListNode one = new LinkedListNode (1, "one");
		LinkedListNode two = new LinkedListNode (2, "two");
		LinkedListNode three = new LinkedListNode (3, "three");
		
		cache.insertAtFrontOfLinkedList(one);
		cache.insertAtFrontOfLinkedList(two);
		cache.insertAtFrontOfLinkedList(three);
		
		cache.printLinkedList();
		
		cache.removeFromLinkedList(three);
		
		cache.printLinkedList();*/
		
		cache.setKeyValue(1, "one");
		cache.setKeyValue(2, "two");
		cache.setKeyValue(3, "three");
		cache.setKeyValue(4, "four");
		cache.setKeyValue(5, "five");
		cache.setKeyValue(6, "six");
		
		cache.printLinkedList ();
		
		cache.setKeyValue(5, "FIVE");
		cache.setKeyValue(2, "TWO");
		
		cache.printLinkedList();
		
	}

}
