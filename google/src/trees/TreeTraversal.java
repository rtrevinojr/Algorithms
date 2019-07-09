package trees;

import java.util.Stack;

import trees.BSTree.TreeNode;

public class TreeTraversal {

	public BSTree bst;
	
	public TreeTraversal (BSTree bst) {
		this.bst = bst;
	}
	
	public TreeTraversal (int [] arr) {
		this.bst = new BSTree();
		this.bst.root = BSTree.buildMinBST(arr);
	}
	
	public void preorder () {
		
		Stack <TreeNode> stack = new Stack<TreeNode>();
		stack.push(bst.root);
		
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			System.out.print(cur.data + " ");
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
		
	}
	
	public void postorder () {
		
		Stack <TreeNode> stack = new Stack <>();
		stack.push(bst.root);
		
		while (!stack.isEmpty()) {
			
			TreeNode node = stack.peek();
			
			if (node.right == null && node.left == null) {
				System.out.print(node.data + " ");
				stack.pop();
			}
			else {
				if (node.right != null) {
					stack.push(node.right);
					node.right = null;
				}
				if (node.left != null) {
					stack.push(node.left);
					node.left = null;
				}
			}
		}
		
	}
	
	public void inorder () {
		
		Stack <TreeNode> stack = new Stack <>();
		stack.push(bst.root);
		
		while (!stack.isEmpty()) {
			
			TreeNode node = stack.peek();
			
			if (node.right == null && node.left == null) {
				System.out.print(node.data + " ");
				stack.pop();
			}
			else if (node.left != null) {
				stack.push(node.left);
				node.left = null;
			}
			else if (node.left == null && node.right != null) {
				System.out.print(node.data + " ");
				stack.pop();
				stack.push(node.right);
				node.right = null;
			}
		}
	}
	
	public void inorderX () {
		
		if (bst.root == null) return;
		
		Stack <TreeNode> stack = new Stack <> ();
		TreeNode node = bst.root;
		
		while (node != null || !stack.isEmpty()) {
			
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			
			TreeNode next = stack.pop();
			
			System.out.print(next.data + " ");
			
			node = next.right;
		}
	}
	
	
	public static void main (String [] args) {
		
		int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		TreeTraversal traversal = new TreeTraversal (arr);
		
		traversal.inorderX();
		
	}
}
