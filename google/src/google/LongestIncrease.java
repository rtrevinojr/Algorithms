package google;

import java.util.LinkedList;
import java.util.List;

public class LongestIncrease {
	
	
	public Node root;
	
	public int maxIncrease;
	
	public LongestIncrease (Node root) {
		this.root = root;
		this.maxIncrease = 0;
	}
	
	public void longestIncSeq (Node root) {
		
		longestIncSeqHelper (root, root.value, 1);
	}
	
	public void longestIncSeqHelper (Node root, int prev, int count) {
		
		
		if (root.children.size() == 0) {
			if (root.value - prev == 1) {
				count += 1;
				if (count > maxIncrease) {
					maxIncrease = count;
				}
			}
			return;
		}
		
		for (Node node : root.children) {
			if (node.value - prev == 1) {
				
				//System.out.println("increasing consec");
				
				count += 1;
				if (count > maxIncrease) {
					maxIncrease = count;
				}
				
				//int printCount = count + 1;
				
				//System.out.println("longestIncSeqHelper" + "(" + node.value + ", " + prev + ", " + printCount + ")");
				
				longestIncSeqHelper (node, node.value, count);
			}
			else {
				//count = 1;
				//System.out.println("Prev = " + prev);
				//System.out.println("Current = " + node.value);
				//System.out.println("longestIncSeqHelper" + "(" + node.value + ", " + prev + ", " + 1 + ")");
				longestIncSeqHelper (node, node.value, 1);
			}
			
			//longestIncSeqHelper (node, node.value, count);
				
		}
		
		
	}
	
	public static  int longestIncSeqList (int [] arr) {
		
		
		if (arr.length == 0) return 0;
		if (arr.length == 1) return 1;
		
		int result = 0;
		int count = 1;
		
		
		for (int i = 1; i < arr.length; i++) {
			
			if (arr[i] - arr[i-1] == 1) {
				count++;
				if (count > result) {
					result = count;
				}
			}
			else {
				count = 1;
				
			}
		}
		return result;
	}

	
	public static void printTree (Node root) {
		
		System.out.print(root.value + " - ");
		
		for (Node node : root.children) {
			printTree(node);
		}
	}


	
	public static void main (String [] args) {
		
		System.out.println("LongestIncrease.java");
		
		int [] a = {1, 2, 3, 1, 2, 3, 5, 1, 2, 3, 4, 5, 8};
		
		System.out.println("Longest Inc = " + longestIncSeqList(a));
		
		Node l61 = new Node (16);
		
		Node l51 = new Node (15);
		l51.addChild(l61);
		
		Node l41 = new Node (16);
		Node l42 = new Node (14);
		l42.addChild(l51);
		
		Node l31 = new Node (13);
		l31.addChild(l41);
		l31.addChild(l42);
		
		Node l32 = new Node (15);
		
		Node l22 = new Node (1);
		l22.addChild(l31);
		l22.addChild(l32);
		
		Node l21 = new Node (8);
		
		Node l1 = new Node (11);
		Node r2 = new Node (11);
		l1.addChild(l21);
		l1.addChild(l22);
		
		Node r41 = new Node (14);
		Node r31 = new Node (13);
		Node r21 = new Node (12);
		
		r31.addChild(r41);
		r21.addChild(r31);
		
//		r21.addChild(r31);
//		r21.addChild(r32);
		r2.addChild(r21);
		
		Node root = new Node (10);
		root.addChild(l1);
		root.addChild(r2);
		
		printTree(root);
		System.out.println();
		
		LongestIncrease calcSeq = new LongestIncrease (root);
		
		calcSeq.longestIncSeq(root);
		
		System.out.println("Result = " + calcSeq.maxIncrease);
		
		
	}

}