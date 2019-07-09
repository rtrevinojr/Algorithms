package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class MyBST {
	
	public BSTNode root;
	
	public int longestIncCount = 0;
	
	public static class BSTNode {
		
		public int value;
		public BSTNode left;
		public BSTNode right;
		
		public BSTNode (int value) {
			this.value = value;
		}
	}
	
	
	
	
	public BSTNode buildMinimalBST (int [] arr) {
		
		return buildMinimalBSTHelper (arr, 0, arr.length - 1);
	}
	
	public BSTNode buildMinimalBSTHelper (int [] arr, int lo, int hi) {
		
		if (lo > hi) 
			return null;
		
		int mid = lo + (hi - lo) / 2;
		
		BSTNode node = new BSTNode (arr[mid]);
		node.left = buildMinimalBSTHelper (arr, lo, mid - 1);
		node.right = buildMinimalBSTHelper (arr, mid + 1, hi);
		return node;
	}
	
	public BSTNode buildBSTRec (int [] arr) {
		
		int lo = 0;
		int hi = arr.length - 1;
		int mid = lo + (hi - lo) / 2;
		root = new BSTNode (arr[mid]);
		buildBSTHelper (root, arr, lo, mid - 1);
		buildBSTHelper (root, arr, mid + 1, hi);
		return root;
	}
	
	public void buildBSTHelper (BSTNode root, int [] arr, int lo, int hi) {
		
		int mid = lo + (hi - lo) / 2;
		
		if (lo > hi) {
			return;
		}
		if (root == null) {
			root = new BSTNode(arr[mid]);
			buildBSTHelper (root, arr, lo, mid - 1);
			buildBSTHelper (root, arr, mid + 1, hi);
		}
//		else if (arr[mid] == root.value) {
//			return mid;
//		}
		else if (root.value < arr[mid]) {
			root.right = new BSTNode (arr[mid]);
			buildBSTHelper (root.right, arr, mid + 1, hi);
			buildBSTHelper (root.right, arr, lo, mid - 1);
		}
		else {
			root.left = new BSTNode (arr[mid]);
			buildBSTHelper (root.left, arr, lo, mid - 1);
			buildBSTHelper (root.left, arr, mid + 1, hi);
		}
	}
	
	
	public void traverseBST () {	
		traverseBSTHelper(this.root);
	}
	
	public void traverseBSTHelper (BSTNode node) {
		
		if (node != null) {
			traverseBSTHelper (node.left);
			System.out.println(node.value);
			traverseBSTHelper (node.right);
		}
	}
	
	public int getMinIt () {
		
		BSTNode node = root;
		if (node == null) {
			return -1;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node.value;
	}
	
	public int getMin () {
		if (root == null) {
			return -1;
		}
		return getMinHelper (root);
	}
	
	public int getMinHelper (BSTNode node) {
		
		if (node.left == null) {
			return node.value;
		}
		return getMinHelper (node.left);
	}
	
	public int getMinHeightBFS () {
		
		int result = 0;
		BSTNode node = root;
		
		Queue <BSTNode> queue = new LinkedList <>();
		queue.add(node);
		
		while (!queue.isEmpty()) {
			
			BSTNode n = queue.remove();
			Queue <BSTNode> nextQueue = new LinkedList <>();
			
			if (n.right != null) {
				nextQueue.add(n.right);
			}
			else {
				return result;
			}
			
			if (n.left != null) {
				nextQueue.add(n.left);
			}
			else {
				return result;
			}
			
			if (queue.isEmpty()) {
				queue = nextQueue;
				result++;
			}
		}
		return result;
	}
	
	
	public int getHeightBFSNullable () {
		
		int result = 0;
		BSTNode node = root;
		
		Queue <BSTNode> queue = new LinkedList <>();
		queue.add(node);
		queue.add(null);
		
		while (!queue.isEmpty()) {
			
			BSTNode n = queue.remove();
			if (n == null) {
				result++;
				queue.add(null);
				if (queue.peek() == null) return result;
				//n = queue.remove();
			}
			
			if (n != null && n.left != null) {
				queue.add(n.left);
			}
			if (n != null && n.right != null) {
				queue.add(n.right);
			}
		}
		
		return result;
		
	}
	
	
	public int getHeightBFS () {
		
		int result = 0;
		
		BSTNode node = root;
		
		Queue <BSTNode> queue = new LinkedList <>();
		queue.add(node);
		
		while (!queue.isEmpty()) {
			
			BSTNode n = queue.remove();
			
			Queue <BSTNode> nextQueue = new LinkedList <>();
			if (n.left != null)
				nextQueue.add(n.left);
			if (n.right != null)
				nextQueue.add(n.right);
			
			if (queue.isEmpty()) {
				queue = nextQueue;
				result++;
			}
		}
		
		return result;
		
	}
	
	
	public int getMaxHeight () {
		return getMaxHeightHelper (this.root);
	}
	
	public int getMaxHeightHelper (BSTNode node) {
		
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(getMaxHeightHelper(node.left), getMaxHeightHelper(node.right));
	}
	
	public int getMinHeight () {
		return getMinHeightHelper (this.root);
	}
	
	public int getMinHeightHelper (BSTNode node) {
		
		if (node == null) {
			return 0;
		}
		return 1 + Math.min(getMinHeightHelper(node.left), getMinHeightHelper(node.right));
	}
	
	public boolean isBalanced () {
		
		int maxHeight = getMaxHeight();
		int minHeight = getMinHeight();
		if (maxHeight - minHeight > 1) return false;
		return true;
	}
	
	public boolean isBST () {
		
		//return isBSTHelper (root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return isBSTHelperNullable (root, null, null);
	}
	
	public boolean isBSTHelper (BSTNode node, int min, int max) {
		
		if (node == null) {
			return true;
		}
		if (node.value > max) {
			return false;
		}
		if (node.value < min) {
			return false;
		}
		return isBSTHelper (node.left, min, node.value) 
				&& isBSTHelper (node.right, node.value, max);
	}
	
	public boolean isBSTHelperNullable (BSTNode node, Integer min, Integer max) {
		
		if (node == null) {
			return true;
		}
		
		if (max != null && node.value > max) {
			return false;
		}
		if (min != null && node.value < min) {
			return false;
		}
		
		return isBSTHelperNullable (node.left, min, node.value) 
				&& isBSTHelperNullable (node.right, node.value, max);
	}
	
	public void insertNode (int value) {
		
		if (root == null) {
			root = new BSTNode (value);
		}
		
		BSTNode node = root;
		
		while (node != null) {
			
			if (value == node.value) {
				return;
			}
			if (value > node.value) {
				if (node.right == null) {
					node.right = new BSTNode (value);
				}
				else {
					node = node.right;
				}
			}
			if (value < node.value) {
				if (node.left == null) {
					node.left = new BSTNode (value);
				}
				else {
					node = node.left;
				}	
			}
		}
	}
	
	public void insertNodeRec (int value) {	
		insertNodeRecHelper2 (root, value);
	}
	
	public BSTNode insertNodeRecHelper2 (BSTNode node, int value) {
		
		if (node == null) {
			return new BSTNode (value);
		}
//		else if (value == node.value) {
//			return node;
//		}
		if (value < node.value) {
			node.left = insertNodeRecHelper2 (node.left, value);
		}
		if (value > node.value) {
			node.right = insertNodeRecHelper2 (node.right, value);
		}
		return node;
	}
	
	public BSTNode insertNodeRecHelper (BSTNode node, int value) {
		
		if (node == null) {
			return new BSTNode (value);
		}
		
		if (value > node.value) {
			if (node.right == null) {
				node.right = new BSTNode(value);
				return node.right;
			}
			else {
				insertNodeRecHelper (node.right, value);
				return node.right;
			}
		}	
		else if (value < node.value) {
			if (node.left == null) {
				node.left = new BSTNode(value);
				return node.left;
			}
			else {
				insertNodeRecHelper (node.left, value);
				return node.left;
			}
		}
		else {
		
			return node;
		}	
	}
	
	public void printAllPaths () {
		
		List <Integer> paths = new LinkedList <Integer> ();
		
		int [] paths2 = new int [1000];
		
		printAllPathsHelper2 (root, paths2, 0, 0);
		//printAllPathsHelper (root, paths);	
	}
	
	public void printAllPathsHelper2 (BSTNode node, int [] path, int len, int count) {
		
		if (node == null) return;
		
		path[len] = node.value;
		len++;
		
		if (len > 1 && path[len-1] - path[len-2] == 1) {
			count++;
			if (longestIncCount <= count) {
				longestIncCount = count;
			}
		}
		
		if (node.left == null && node.right == null) {
			
			printArray(path, len);
		}
		else {
			printAllPathsHelper2 (node.left, path, len, count);
			printAllPathsHelper2 (node.right, path, len, count);
		}
	}
	
	public void printAllPathsHelper (BSTNode node, List <Integer> path) {
		
		if (node == null) {
			return;
		}
		
		path.add(node.value);
		
		if (node.left == null && node.right == null) {
			//path.add(node.value);
			System.out.println(path.toString());
		}
		else {
			//path.add(node.value);
			printAllPathsHelper (node.left, path);
			printAllPathsHelper (node.right, path);
		}
		/*
		else if (node.left != null && node.right != null) {
			path.add(node.value);
			printAllPathsHelper (node.left, path);
			printAllPathsHelper (node.right, path);
		}
		else if (node.left != null){
			path.add(node.value);
			printAllPathsHelper (node.left, path);
			//printAllPathsHelper (node.right, path);
		}
		else  {
			path.add(node.value);
			printAllPathsHelper (node.right, path);
		}
		*/
	}
	
	/* Given a binary tree, print out all of its root-to-leaf 
    paths, one per line. Uses a recursive helper to do  
    the work.*/
	public void printPaths() { 
		int path[] = new int[1000]; 
		printPathsRecur(root, path, 0); 
	} 
 
	/* Recursive helper function -- given a node, and an array 
     containing the path from the root node up to but not  
     including this node, print out all the root-leaf paths.*/
	public void printPathsRecur(BSTNode node, int path[], int pathLen) { 
      if (node == null) 
          return; 
 
      /* append this node to the path array */
      path[pathLen] = node.value; 
      pathLen++; 
 
      /* it's a leaf, so print the path that led to here  */
      if (node.left == null && node.right == null) 
          printArray(path, pathLen); 
      else 
      { 
          /* otherwise try both subtrees */
          printPathsRecur(node.left, path, pathLen); 
          printPathsRecur(node.right, path, pathLen); 
      } 
  } 
 
  /* Utility function that prints out an array on a line. */
  public void printArray(int ints[], int len) { 
      for (int i = 0; i < len; i++) { 
          System.out.print(ints[i] + " "); 
      } 
      System.out.println(""); 
  } 

	
	public static void main (String [] args) {
		
		System.out.println("MyBST.java");
		
		int [] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		MyBST bst = new MyBST();
		
		//bst.buildBST(arr1);
		
		bst.traverseBST();
		
		System.out.println();
		
		bst.buildBSTRec(arr1);

		bst.traverseBST();
		
		System.out.println("OPTIMAL buildMinimalBST"	);
		
		bst.buildMinimalBST(arr1);
		
		bst.traverseBST();
		
		System.out.println();
		
		//bst.insertNodeRec(10);
		//bst.insertNodeRec(11);
		
		bst.traverseBST();
		
		System.out.println();
		
		System.out.println("BFS MAX Height Nullable = " + bst.getHeightBFSNullable());
		
		System.out.println("BFS MAX Height = " + bst.getHeightBFS());
		System.out.println("BFS MIN Height = " + bst.getMinHeightBFS());
		
		System.out.println("Max height = " + bst.getMaxHeight());
		System.out.println("Min height = " + bst.getMinHeight());
		System.out.println("BST is Balanced = " + bst.isBalanced());
		System.out.println("Tree is BST = " + bst.isBST());
		
		System.out.println();
		System.out.println("MIN = " + bst.getMin());
		System.out.println("MIN iterative = " + bst.getMinIt());
		
		System.out.println("root = " + bst.root.value);
		
		bst.printAllPaths();
		
		System.out.println("-----------------------------------------");
		
		bst.printPaths();
		
		System.out.println();
		
		System.out.println("Longest Increasing Count = " + bst.longestIncCount);
		
		//System.out.println("root.left = " + bst.root.left.value);
		
		
		
	}

}
