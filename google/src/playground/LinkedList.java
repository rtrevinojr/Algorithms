package playground;

public class LinkedList {
	
	public static class Node {
		
		int value;
		Node next;
		
		public Node (int val) {
			this.value = val;
		}
	}
	
	public static Node createLinkedList (int [] arr) {
		
		return createLinkedListHelper (arr, 0);
	}
	
	public static Node createLinkedListHelper (int [] arr, int index) {
		
		if (index == arr.length) {
			return null;
		}
		Node node = new Node (arr[index]);
		node.next = createLinkedListHelper (arr, index + 1);
		return node;
	}
	
	public static void printLinkedList (Node head) {
		
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static Node sumLinkedList (Node head1, Node head2) {
		
		return sumLinkedListRec(head1, head2, 0);
	}
	
	public static Node sumLinkedListRec (Node head1, Node head2, int carry) {
		
		int value = carry;
		
		if (head1 == null && head2 == null) {
			if (carry == 0)
				return null;
			else 
				return new Node (1);
		}
		else if (head1 != null && head2 != null) {
			value += head1.value + head2.value;
			head1 = head1.next;
			head2 = head2.next;
		}
		else if (head1 != null) {
			value += head1.value;
			head1 = head1.next;
		
		}
		else if (head2 != null) {
			value += head2.value;
			head2 = head2.next;
		}
		
		//value += carry;
		
		if (value > 9) {
			carry = 1;
		}
		else {
			carry = 0;
		}
		
		Node node = new Node (value % 10);
		node.next = sumLinkedListRec(head1, head2, carry);
		return node;
		
	}
	
	public static void main (String [] args) {
		
		System.out.println("LinkedList.java");
		
		int [] arr = {1, 2, 3, 4, 5};
		
		Node head = createLinkedList (arr);
		
		printLinkedList (head);
		
		
		int [] arr1 = {1, 2, 3, 4};
		int [] arr2 = {9, 1, 1, 9};
		
		Node h1 = createLinkedList (arr1);
		Node h2 = createLinkedList (arr2);
		
		Node result = sumLinkedList (h1, h2);
		
		printLinkedList (result);
		
		
	}
	
	
	
	

}
