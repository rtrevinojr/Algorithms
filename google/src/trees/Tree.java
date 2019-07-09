package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tree {
	
	
	public TreeNode root;
	
	public int longestConsecInc = 0;
	public int opLongestConsecInc = 0;
	
	public List <int[]> paths;
	
	public Tree (TreeNode root) {
		this.root = root;
		paths = new LinkedList <int []> ();
	}
	
	
	public static class TreeNode {
		
		public int value;
		public TreeNode [] children;
		public int childLen;
		
		public TreeNode (int value) {
			this.value = value;
			this.children = new TreeNode [1];
			this.childLen = 0;
		}
		
		public TreeNode (int value, int childLen) {
			this.value = value;
			this.children = new TreeNode [childLen];
			this.childLen = 0;
		}
		
		public void addChild (int value) {
			children[childLen] = new TreeNode (value);
			childLen++;
		}
		
		public void addChild (TreeNode node) {
			children[childLen] = node;
			childLen++;
		}
	}
	
	public void traverseInOrder () {
		
		traverseInOrderHelper (root);
	}
	
	public void traverseInOrderHelper (TreeNode node) {
		
		if (node == null) {
			return;
		}
		System.out.print(node.value + " - ");
		for (TreeNode n : node.children) {
			traverseInOrderHelper (n);
		}
	}
	
	public List <int[]> getPaths () {
		
		int [] paths = new int [10];
		getPathsHelper (root, paths, 0);
		
		return this.paths;
	}
	
	public void getPathsHelper (TreeNode node, int [] path, int len) {
		
		if (node == null) {
			return;
		}
		
		path[len] = node.value;
		len++;
		
		if (node.childLen == 0) {
			printArray(path, len);
			int [] p = Arrays.copyOf(path, len);
			paths.add(p);
		}
		else {
			
			for (TreeNode n : node.children) {
				getPathsHelper (n, path, len);
			}

		}
		
	}
	
	
	public List <int[]> getLongestIncPath () {
		
		int [] paths = new int [10];
		getLongestIncPathHelper (root, paths, 0, 1);
		
		return this.paths;
	}
	
	public void getLongestIncPathHelper (TreeNode node, int [] path, int len, int count) {
		
		if (node == null) {
			return;
		}
		
		path[len] = node.value;
		len++;
		
		if (len > 1 && path[len-1] - path[len-2] == 1) {
			count++;
			if (count > longestConsecInc) {
				longestConsecInc = count;
			}
		}
		else {
			path = new int [10];
			path[0] = node.value;
			len = 1;
			count = 1;
		}
		
		if (node.childLen == 0) {
			if (count == this.longestConsecInc) {
			printArray(path, len);
			int [] p = Arrays.copyOf(path, len);
			paths.add(p);
			}
		}
		else {
			
			for (TreeNode n : node.children) {
				getLongestIncPathHelper (n, path, len, count);
			}

		}
		
	}
	
	public int getLongestIncPathOp () {
		
		//int [] paths = new int [10];
		int rootVal = root.value;
		getLongestIncPathHelperOp2 (root, rootVal, 1);
		
		return this.opLongestConsecInc;
	}
	
	public void getLongestIncPathHelperOp2 (TreeNode node, int prev, int count) {
		
		if (node == null) return;
		
		if (node.value - prev == 1) {
			count++;
			if (count > opLongestConsecInc) {
				opLongestConsecInc = count;
			}
		}
		else {
			count = 1;
		}
		
		if (node.childLen != 0) {
			prev = node.value;
			for (TreeNode n : node.children) {
				getLongestIncPathHelperOp2 (n, prev, count);
			}
		}
		
	}
	
	public void getLongestIncPathHelperOp (TreeNode node, int prev, int len, int count) {
		
		if (node == null) {
			return;
		}
		
		//prev = node.value;
		//len++;
		
		if (node.value - prev == 1) {
			count++;
			if (count > opLongestConsecInc) {
				opLongestConsecInc = count;
			}
		}
		else {
			//path = new int [10];
			//path[0] = node.value;
			len = 1;
			count = 1;
		}
		
		if (node.childLen == 0) {
			
			if (count == this.opLongestConsecInc) {
				//printArray(path, len);
				//int [] p = Arrays.copyOf(path, len);
				//paths.add(p);
				
			}
		}
		else {
			prev = node.value;
			for (TreeNode n : node.children) {
				getLongestIncPathHelperOp (n, prev, len, count);
			}

		}
		
	}
	
	public static void printArray (int [] arr, int len) {

		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " - "); 
		}
		
		System.out.println();
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("Tree.java");
		
		TreeNode root = new TreeNode (10, 3);
		
		TreeNode l2221 = new TreeNode (13, 1);
		
		TreeNode l221 = new TreeNode (5, 3);
		TreeNode l222 = new TreeNode (13, 3);
		//l222.addChild(l2221);
		TreeNode l223 = new TreeNode (6, 3);
		
		TreeNode l321 = new TreeNode (2, 3);
		TreeNode l322 = new TreeNode (8, 3);
		TreeNode l323 = new TreeNode (1, 3);
		
		TreeNode l11 = new TreeNode (8, 3);
		TreeNode l12 = new TreeNode (7, 3);
		TreeNode l13 = new TreeNode (4, 3);
		
		TreeNode l21 = new TreeNode (7, 3);
		TreeNode l22 = new TreeNode (12, 3);
		TreeNode l23 = new TreeNode (13, 3);
		
		TreeNode l31 = new TreeNode (6, 3);
		TreeNode l32 = new TreeNode (12, 3);
		TreeNode l33 = new TreeNode (13, 3);
		
		TreeNode l1 = new TreeNode (9, 3);
		TreeNode l2 = new TreeNode (11, 3);
		TreeNode l3 = new TreeNode (11, 3);
		
		l1.addChild(l11);
		l1.addChild(l12);
		l1.addChild(l13);
		
		l22.addChild(l221);
		l22.addChild(l222);
		l22.addChild(l223);
		
		l2.addChild(l21);
		l2.addChild(l22);
		l2.addChild(l23);
		
		l32.addChild(l321);
		l32.addChild(l322);
		l32.addChild(l323);
		
		l3.addChild(l31);
		l3.addChild(l32);
		l3.addChild(l33);
		
		root.addChild(l1);
		root.addChild(l2);
		root.addChild(l3);
		
		
		TreeNode n2 = new TreeNode (14, 3);
		
		l222.addChild(n2);
		
		TreeNode n21 = new TreeNode (2, 3);
		TreeNode n22 = new TreeNode (15, 3);
		TreeNode n23 = new TreeNode (10, 3);
		
		TreeNode n211 = new TreeNode (16, 3);
		TreeNode n212 = new TreeNode (5, 3);
		TreeNode n213 = new TreeNode (1, 3);
		
		n22.addChild(n211);
		n22.addChild(n212);
		n22.addChild(n213);
		
		n2.addChild(n21);
		n2.addChild(n22);
		n2.addChild(n23);
		Tree tree = new Tree (root);
		tree.traverseInOrderHelper(root);
		
		System.out.println("\n");
		
		tree.getPaths();
		
		System.out.println("\n");
		
		for (int[] n : tree.paths) {
			printArray(n, n.length);
		}
		
		System.out.println();
		
		tree.getLongestIncPath();
		
		System.out.println("Longest Increasing Consec Seq = " + tree.longestConsecInc);
		
		System.out.println();
		
		tree.getLongestIncPathOp();
		
		System.out.println("Optimized Longest Increasing Consec Seq = " + tree.opLongestConsecInc);
		
		System.out.println();
		
		
	}

}
