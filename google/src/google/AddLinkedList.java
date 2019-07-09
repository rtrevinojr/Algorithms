package google;

public class AddLinkedList {

	public static class Node {
		
		public int value;
		public Node next;
		
		public Node (int value) {
			this.value = value;
		}
	}
	
	public static Node generateLinkedList (int ... digits) {
		
		Node node = new Node (digits[0]);
		Node head = node;
		
		for (int i = 1; i < digits.length; i++) {
			
			node.next = new Node(digits[i]);
			node = node.next;
		}
		return head;
	}
	
	/*
	public static Node generateLinkedListRec (int ... digits) {
		
		for (int i : digits) {
			Node n = new Node (i);
			n.next = generateLinkedListRecHelper (n, i);
		}
	}*/
	
	
	public static Node addList  (Node head1, Node head2) {
		
		Node result = null;
		Node head = result;
		
		int carry = 0;
		
		while (head1 != null || head2 != null) {
			
			int add = 0;
			
			if (head1 != null && head2 != null) {
				add = head1.value + head2.value;
				head1 = head1.next;
				head2 = head2.next;
			}
			else if (head1 != null) {
				add = head1.value;
				head1 = head1.next;
			}
			else {
				add = head2.value;
				head2 = head2.next;
			}
			
			int value = (add + carry) % 10;
			if (add + carry > 9) {
				carry = 1;
			}
			else {
				carry = 0;
			}
			
			Node n = new Node (value);
			if (result == null) {
				result = n;
				head = result;
			}
			else {
				result.next = n;
				result = result.next;
			}
			
		}
		
		if (carry == 1) {
			result.next = new Node (1);
		}
		
		return head;
		
	}
	
	
	public static void printLinkedList (Node node) {
		
		if (node == null) return;
		System.out.print(node.value + " - ");
		printLinkedList (node.next);
	}
	
	
	public static void NodePtrTest () {
		
		Node n1 = generateLinkedList (1, 2, 3, 4);
		
		Node n2 = n1;
		
		n1 = n1.next;
		
		System.out.println("n1 = " + n1.value);
		System.out.println("n2 = " + n2.value);
		
		
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("AddLinkedList.java");
		
		NodePtrTest();
		
		System.out.println("------------------------------");
		
		Node head = generateLinkedList (1, 2, 3, 4);
		Node head2 = generateLinkedList (1, 1, 1, 1);
		
		Node result = addList (head, head2);
		
		printLinkedList (result);
		
		System.out.println();
		
		Node h2 = generateLinkedList (1, 2, 3);
		Node h22 = generateLinkedList (9, 9, 9);
		
		Node result2 = addList (h2, h22);
		
		
		printLinkedList (result2);
		
		System.out.println();
		
		Node h3 = generateLinkedList (9, 9, 9);
		Node h33 = generateLinkedList (9, 9, 9);
		
		Node result3 = addList (h3, h33);
		
		printLinkedList (result3);
		
		System.out.println();
		
		Node h4 = generateLinkedList (0, 9, 9);
		Node h44 = generateLinkedList (0, 9, 9, 9);
		
		Node result4 = addList (h4, h44);
		
		printLinkedList (result4);
		
		System.out.println();
		
		
	}
}
