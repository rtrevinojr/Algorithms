package playground;

import java.util.Iterator;
import java.util.Stack;

import playground.BST.BSTNode;

public class BSTIterator implements Iterator <BSTNode> {

	
	public Stack <BSTNode> stack;
	
	public BSTIterator (BSTNode root) {
		stack = new Stack <>();
		
		while (root.left != null) {
			stack.push(root);
			root = root.left;
		}
	}
	
	public boolean hasNext () {
		return !stack.isEmpty();
	}
	
	public BSTNode next () {
		BSTNode node = stack.pop();
		
		BSTNode right = node.right;
		while (right != null) {
			stack.push(right);
			right = right.left;
		}
		return node;
	}
}
