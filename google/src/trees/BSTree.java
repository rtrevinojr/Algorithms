package trees;

import java.util.Stack;

public class BSTree {
	
	TreeNode root;

	
	static class TreeNode { 
		String data; 
		TreeNode left, right; 
		TreeNode(String value) { 
			this.data = value; 
			left = right = null; 
			} 
		boolean isLeaf() { 
			return left == null ? right == null : false; 
			} 
		} 
	// root of binary tree TreeNode root;

	
	public static TreeNode buildMinBST (int [] arr) {
		
		return buildMinBSTHelper (arr, 0, arr.length - 1);
	}
	
	public static TreeNode buildMinBSTHelper (int [] arr, int lo, int hi) {
		
		if (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			TreeNode n = new TreeNode (String.valueOf(arr[mid]));
			n.left = buildMinBSTHelper(arr, lo, mid - 1);
			n.right = buildMinBSTHelper(arr, mid + 1, hi);
			return n;
		}
		else return null;
	}
	
	public void preOrderWithoutRecursion() { 
		Stack<TreeNode> nodes = new Stack<>(); 
		nodes.push(root); 
		while (!nodes.isEmpty()) { 
			TreeNode current = nodes.pop(); 
			System.out.printf("%s ", current.data); 
			if (current.right != null) { 
				nodes.push(current.right); 
				} 
			if (current.left != null) { 
				nodes.push(current.left); 
				} 
			} 
		}

	/** * Java method to print all nodes of tree in post-order traversal */
	public void postOrderWithoutRecursion() { 
		Stack<TreeNode> nodes = new Stack<>(); 
		nodes.push(root); 
		while (!nodes.isEmpty()) { 
			TreeNode current = nodes.peek(); 
			if (current.isLeaf()) { 
				TreeNode node = nodes.pop(); 
				System.out.printf("%s ", node.data); 
				} 
			else { 
				if (current.right != null) { 
					nodes.push(current.right); 
					current.right = null; 
					} 
				if (current.left != null) { 
					nodes.push(current.left); 
					current.left = null; 
					} 
				} 
			} 
		}
	
	public void inorder() { 
        if (root == null) 
            return; 
  
        Stack<TreeNode> s = new Stack<>(); 
        TreeNode curr = root; 
        // traverse the tree 
        while (curr != null || s.size() > 0) { 
            /* Reach the left most Node of the 
            curr Node */
            while (curr !=  null) { 
                /* place pointer to a tree node on 
                   the stack before traversing 
                  the node's left subtree */
                s.push(curr); 
                curr = curr.left; 
            } 
            /* Current must be NULL at this point */
            curr = s.pop(); 
  
            System.out.print(curr.data + " "); 
  
            /* we have visited the node and its 
               left subtree.  Now, it's right 
               subtree's turn */
            curr = curr.right; 
        } 
    } 

	
	public static void main (String [] args) {
		
		int [] arr = {1, 2, 3, 4, 5};
		
		BSTree bst = new BSTree();
		
		bst.root = bst.buildMinBST(arr);
		
		bst.inorder();
	}
}
