package graph_theory;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Bag <E> implements Iterable <E> {
	
	private Node <E> first;
	private int size;
	
	
	public Bag () {
		first = null;
		size = 0;
	}
	
	private static class Node <E> {
		public E value;
		public Node<E> next;
		public Node (E val) {
			value = val;
		}
	}
	
	public void add (E item) {
		Node <E> oldFirst = first;
		Node <E> newitem = new Node <E> (item);
		newitem.next = oldFirst;
		first = newitem;
		size++;
	}
	
	public void remove (E item) {
		Node <E> it = first;
		while (it.next != null) {
			if (it.next.value.equals(item)) {
				it.next = it.next.next;
			}
			it = it.next;
		}
	}
	
	public void remove2 (E item) {
		Node <E> it = first;
		while (it.next != null) {
			if (it.value.equals(item)) {
				it.value = it.next.value;
				if (it.next.next != null)
					it.next = it.next.next;
				else 
					it = null;
			}
			if (it.next != null)
				it = it.next;
			else 
				it = null;
		}
	}
	
	public boolean isEmpty () {
		return size == 0;
	}
	
	public int size () {
		return size;
	}
	
	public Iterator <E> iterator () {
		return new ListIterator(first);
	}
	
	public class ListIterator<E> implements Iterator<E> {
		private Node<E> current;
		
		public ListIterator (Node <E> first) {
			current = first;
		}
		
		public boolean hasNext () {
			return current != null;
		}
		
		public void remove () {
			if (!hasNext()) 
				throw new NoSuchElementException();
			else {
				//Node <E> p = current;
				current.value = current.next.value;
				current.next = current.next.next;
			}
			
		}
		
		public E next () {
			if (!hasNext()) 
				throw new NoSuchElementException();
			else {
				E item = current.value;
				current = current.next;
				return item;
			}
		}
	}
	
	public static void main (String [] args) {
		System.out.println("----- Bag.java -----");
//		Bag<Integer> bag = new Bag<Integer>();
//        for (int i = 0; i < 10; i++) {
//            Integer item = new Integer(i);
//            bag.add(item);
//        }
		
		Bag <String> bag = new Bag <String> ();
		bag.add("A");
		bag.add("B");
		bag.add("C");
		bag.add("D");
		bag.add("E");
		
		
		
//		Iterator <String> it = bag.iterator();
//		while (it.hasNext()) {
//			
//			String value = it.next();
//			System.out.println(value);
//			if (value.equals("E"))
//				it.remove();
//		}
		
		
		
        System.out.println("Bag size = " + bag.size());
        
//        for (int i = 0; i < bag.size(); i++) {
//        	System.out.println(bag);
//        }
        bag.remove2("A");
        for (String item: bag) {
        	System.out.println(item);
        }
		
	}
	
//	public static void printBag (Bag<Integer> bag) {
//		System.out.println("Printing Bag values...");
//		System.out.println("Bag size = " + bag.size());
//		for (Integer item: bag) {
//			System.out.println(item);
//		}
//	}
	
	
	
}
