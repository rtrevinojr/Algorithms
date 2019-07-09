package Microsoft;

public class BST {
	
	
	public BSTNode root;
	
	public Integer index = 0;
	
	public static class BSTNode {
		
		public int data;
		public BSTNode left;
		public BSTNode right;
		
		public BSTNode (int data) {
			this.data = data;
		}
	}
	
	
	public BSTNode addNode (int data) {
		
		if (root == null) {
			root = new BSTNode (data);
			return root;
		}
		
		return addNodeHelper (data, root);
	}
	
	public BSTNode addNodeHelper (int data, BSTNode node) {
		
		if (node == null) {
			return new BSTNode (data);
		}
		if (data > node.data) {
			node.right = addNodeHelper (data, node.right);
		}
		if (data < node.data) {
			node.left = addNodeHelper (data, node.left);
		}
//		if (data == node.data) {
//			node.data = data;
//		}
		return node;
	}
	
	public BSTNode deserializeX (String serial) {
		
		String [] nodeValues = serial.split(",");
		int [] index = new int [] {0};
		return deserializeHelper (nodeValues, index);
	}
	
	public BSTNode deserializeHelper (String [] nodeValue, int [] index) {
		
		if (index[0] >= nodeValue.length) return null;
		if (nodeValue[index[0]].equals("null")) return null;
		BSTNode node = new BSTNode (Integer.parseInt(nodeValue[index[0]]));
		++index[0];
		node.left = deserializeHelper (nodeValue, index);
		++index[0];
		node.right = deserializeHelper (nodeValue, index);
		return node;
	}
	
	public BSTNode deserialize (String serial) {
		
		String [] nodesValues = serial.split(",");
		
		printArray(nodesValues);
		
		System.out.println("nodeValues[] size = " + nodesValues.length);
		
		Integer index = 0;
		return deserializeHelper (nodesValues, index);
	}
	
	public BSTNode deserializeHelper (String [] nodeValues, Integer index) {
		
		System.out.println("index = " + index);
		
		if (this.index >= nodeValues.length) {
			return null;
		}
		String nodeVal = nodeValues[index];
		this.index++;
		index++;
		if (nodeVal.equals("null")) {
			return deserializeHelper(nodeValues, index);
			
		}
		else {
			BSTNode n = new BSTNode(Integer.parseInt(nodeVal));
			//index++;
			n.left = deserializeHelper (nodeValues, index);
			//index++;
			n.right = deserializeHelper (nodeValues, index);
			return n;
		}
		
		
	}
	
	public String serialize () {
		
		StringBuilder sb = new StringBuilder ();
		return dfs (root, sb);
	}
	
	public String dfs (BSTNode node, StringBuilder sb) {
		
		if (node == null) {
			sb.append("null,");
		}
		else {
			sb.append(node.data + ",");
			dfs (node.left, sb);
			dfs (node.right, sb);
		}
	
		return sb.toString();
	}
	
	public static BSTNode initBST (int [] arr) {
		
		return initBSTHelper (arr, 0, arr.length - 1);
	}
	
	public static BSTNode initBSTHelper (int [] arr, int lo, int hi) {
		
		if (lo > hi) {
			return null;
		}
		else {
			int mid = lo + (hi - lo) / 2;
			BSTNode node = new BSTNode (arr[mid]);
			node.left = initBSTHelper (arr, lo, mid - 1);
			node.right = initBSTHelper (arr, mid + 1, hi);
			return node;
		}
	}
	
	public void inOrder () {
		inOrder (root);
		System.out.println();
	}
	
	public static void inOrder (BSTNode node) {
		
		if (node != null) {
			inOrder (node.left);
			System.out.print(node.data + " ");
			inOrder (node.right);
		}
		//System.out.println();
	}
	
	public void preOrder () {
		preOrder (root);
		System.out.println();
	}
	
	public void preOrder (BSTNode node) {
		
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder (node.left);
			preOrder (node.right);
		}
		
	}
	
	public Integer ceiling (Integer key) {
		
		if (key == null) return null;
		if (root == null) return null;
		BSTNode node = ceiling (key, root);
		if (node == null) return null;
		else return node.data;
	}
	
	public BSTNode ceiling (Integer key, BSTNode node) {
		
		if (node == null) return null;
		if (key == node.data) return node;
		if (key < node.data) {
			BSTNode t = ceiling (key, node.left);
			if (t != null) return t;
			else return node;
		}
		else {
			return ceiling (key, node.right);
		}
	}
	
	public BSTNode max () {
		return max(root);
	}
	public BSTNode max (BSTNode node) {
		
		if (node.right == null) 
			return node;
		else 
			return max (node.right);
	}
	
	public BSTNode find2ndMax (BSTNode node) {
		
		if (node.right == null && node.left != null) {
			return max(node.left);
		}
		else if (node.right == null && node.left == null) {
			return null;
		}
		else if (node.right.left == null && node.right.right == null) {
			return node;
		}
		else {
			return find2ndMax (node.right);
		}
	}
	
	
	public void printArray (String [] arr) {
		
		for (String i: arr) System.out.print(i + " ");
		System.out.println();
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("BST.java");
		
		BST bst = new BST ();
		bst.addNode(5);
		bst.addNode (1);
		bst.addNode (-2);
		bst.addNode(3);
		bst.addNode(4);
		bst.addNode(8);
		bst.addNode(7);
		bst.addNode(9);
		
		
		String serial = bst.serialize();
		
		System.out.println(serial);
		
		BSTNode result = bst.deserializeX(serial);
		
		System.out.println(result.data);
		
		bst.preOrder(result);
			
		System.out.println();
		
		int [] arr = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		BSTNode root = initBST(arr);
		
		//System.out.println(root.left.data + " : " + root.right.data);
		//System.out.println(root.left.right.data);
		
		BST.inOrder(root);
		
		System.out.println();
		
		BSTNode node2max = bst.find2ndMax(root);
		
		System.out.println("node 2nd max = " + node2max.data);
		System.out.println();
		
		Integer answer = bst.ceiling(-10);
		System.out.println("Ceiling for 7 = " + answer);
		
		
	}
	
	

}
