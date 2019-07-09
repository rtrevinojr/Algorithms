package sorting;

public class MergeSortLL {
	
	
	
	public static class Node {
		
		public int data;
		public Node next;
		
		Node (int data) {
			this.data = data;
		}
	}
	
	public Node sort (Node head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		Node mid = getMidNode (head);
		Node midHead = mid.next;
		mid.next = null;
		
		//printLL(head);
		//printLL (midHead);
		
		Node left = sort (head);
		Node right = sort (midHead);
		
		return merge(left, right);
		
	}
	
	
	public Node mergeRec (Node head1, Node head2) {
		
		if (head1 == null) return head2;
		if (head2 == null) return head1;
		
		Node result = null;
		
		if (head1.data < head2.data) {
			result = head1;
			result.next = mergeRec(head1.next, head2);
		}
		else {
			result = head2;
			result.next = mergeRec(head1, head2.next);
		}
		return result;
	}
	
	
	public Node merge (Node head1, Node head2) {
		
		Node left = head1;
		Node right = head2;
		
		//Node result;
		
		//System.out.println("head1");
		//printLL (head1);
		//System.out.println("head2");
		//printLL (head2);
		
		/*
		if (left == null) {
			result = right;
		}
		else if (right == null) {
			result = left;
		}
		else if (left.data < right.data) {
			result = left;
			left = left.next;
		}
		else {
			result = right;
			right = right.next;
		}
		*/
		
		
		Node retNode = new Node (-1);
		
		Node result = retNode;
		
		while (left != null || right != null) {
			
			if (left != null && right != null) {
				
				if (left.data < right.data) {
					result.next = left;
					left = left.next;
				}
				else {
					result.next = right;
					right = right.next;
					
				}
				result = result.next;
			}
			else if (left == null) {
				result.next = right;
				break;
			}
			else if (right == null) {
				result.next = left;
				break;
			}
			
		}
		return retNode.next;
	}
	
	
	public Node merge2 (Node left, Node right) {
		
		Node result = new Node (0);
		Node h = result;
		
//		Node left = head1;
//		Node right = head2;
		
		while (left != null || right != null) {
			
			if (left != null && right != null) {
				
				if (left.data < right.data) {
					h.next = left;
					left = left.next;
				}
				else {
					h.next = right;
					right = right.next;
				}
				h = h.next;
			}
			else if (left == null) {
				h.next = right;
				break;
			}
			else if (right == null) {
				h.next = left;
				break;
			}
		}
		return result.next;
	}
	
	public Node mergeTwoLists(Node l1, Node l2) {
	    Node head = new Node(0);
	    Node p = head;
	 
	    while (l1 != null || l2 != null) {
	        if (l1 != null && l2 != null) {
	            if(l1.data < l2.data){
	                p.next = l1;
	                l1=l1.next;
	            }else{
	                p.next=l2;
	                l2=l2.next;
	            }
	            p = p.next;
	        }else if (l1 == null){
	            p.next = l2;
	            break;
	        }else if(l2 == null){
	            p.next = l1;
	            break;
	        }
	    }
	 
	    return head.next;
	}
	
	
	public Node getMidNode (Node head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		Node trailer = head;
		Node leader = head.next;
		
		while (leader != null && leader.next != null) {
			
			leader = leader.next.next;
			trailer = trailer.next;
		}
		
		return trailer;
		
	}
	
	
	
	
	
	public static Node initLL (int [] arr) {
		return initLLHelper (arr, 0);
	}
	
	public static Node initLLHelper (int [] arr, int len) {	
		if (len == arr.length) return null;
		Node result = new Node (arr[len]);
		result.next = initLLHelper (arr, ++len);
		return result;
	}
	
	public static void printLL (Node head) {
		
		while (head != null) {
			System.out.print(head.data);
			head = head.next;
		}
		System.out.println();
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("LinkedList MergeSort");
		
		MergeSortLL mergeSort = new MergeSortLL();
		
		int [] arr = {0, 1, 2, 3, 4, 5, 6};
		
		int [] sortArr = {3, 5, 2, 6, 1, 9, 0};
		
		Node list = initLL(sortArr);
		
		printLL(list);
		
		Node result = mergeSort.sort (list);
		
		System.out.println("Sorted List");
		
		
		printLL(result);
		
		System.out.println("***************************");
		
		int [] arr1 = {1, 3, 5, 6};
		
		int [] arr2 = {2, 4, 7};
		
		Node resMerge = mergeSort.mergeTwoLists(initLL(arr1), initLL(arr2));
		
		printLL(resMerge);
		
		/*Node head = initLL(arr);
		printLL(head);
		
		
		Node mid = mergeSort.getMidNode(head);
		
		printLL(mid);*/
		
	}

}
