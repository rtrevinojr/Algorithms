package google;

public class OddEvenList {

	
	public static class Node {
		
		int data;
		Node next;
		
		Node (int data) {
			this.data = data;
		}
	}
	
	
	public static Node transfigureList (Node head) {
		
		if (head == null) return null;
		
		Node result = head;
		Node lead = head.next;
		Node trailer = head;
		Node oddHead = head.next;
		
		while (lead != null && trailer != null) {
			
			if (lead.next == null) break;
			
			trailer.next = lead.next;
			trailer = trailer.next;
			lead.next = trailer.next;
			lead = lead.next;
		}
		
		System.out.println("lead = " + lead.data);
		System.out.println("trailer = " + trailer.data);
		
		trailer.next = oddHead;
		
		return result;
		
	}
	
	
	public static void printList (Node head) {
		
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main (String [] args) {
		
		System.out.println("OddEvenList");
		
		Node zero = new Node (0);
		Node one = new Node (1);
		Node two = new Node (2);
		Node three = new Node (3);
		Node four = new Node (4);
		Node five = new Node (5);
		zero.next = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		Node head = zero;
		
		printList (head);
		
		Node result = transfigureList (head);
		
		printList (result);
		
		
	}
}
