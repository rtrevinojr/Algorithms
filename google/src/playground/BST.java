package playground;

import java.util.Iterator;
import java.util.Stack;


//import trees.BST.Node;

public class BST {
	
	public static class BSTNode {
		
		int value;
		BSTNode left;
		BSTNode right;
		
		public BSTNode (int val) {
			this.value = val;
		}
	}
	
	
	public BSTNode root;
	
	
	public BSTIterator  preOrderIterator() {
		return new BSTIterator(root);
	}
	
	public BSTNode addNode (int val) {
		root = addNodeHelper (root, val);
		return root;
	}
	
	public BSTNode addNodeHelper (BSTNode node, int v) {
		
		if (node == null) {
			return new BSTNode (v);
		}
		if (v < node.value) {
			node.left = addNodeHelper (node.left, v);
		}
		else if (v > node.value) {
			node.right = addNodeHelper (node.right, v);
		}
		return node;
		
	}
	
	public BSTNode removeNode (int val) {
		
		root = removeNodeHelper (root, val);
		return root;
	}
	
	public BSTNode removeNodeHelper (BSTNode node, int val) {
		
		if (node == null) {
			return null;
		}
		else if (val < node.value) {
			node.left = removeNodeHelper (node.left, val);
		}
		else if (val > node.value) {
			node.right = removeNodeHelper (node.right, val);
		}
		else {
			if (node.left == null && node.right == null) {
				return null;
			}
			if (node.right == null) {
				return node.left;
			}
			if (node.left == null) {
				return node.right;
			}
			BSTNode tmp = node;
			node = min (tmp.right);
			node.right = removeMin(tmp.right);
			node.left = tmp.left;
			return node;

		}
		return node;
	}
	
/*	private BSTNode delete(BSTNode x, int key) {
        if (x == null) return null;

        //int cmp = key.compareTo(x.key);
        if      (key < x.value) x.left  = delete(x.left,  key);
        else if (key > x.value) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            BSTNode t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        //x.size = size(x.left) + size(x.right) + 1;
        return x;
    } */
	
	public BSTNode min(BSTNode node) {
		if (node.left == null) 
			return node;
		else 
			return min(node.left);
	}
	
/*    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } */
	
	public BSTNode removeMin (BSTNode node) {
		
		if (node.left == null) {
			return node.right;
		}
		node.left = removeMin (node.left);
		return node;
	}
	
/*	private BSTNode deleteMin(BSTNode x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        //x.size = size(x.left) + size(x.right) + 1;
        return x;
    }*/
	
	public int countLeafs() {
		
		return countLeafsHelper (root);
	}
	
	public static int countLeafsHelper (BSTNode node) {
		
		if (node == null) return 0;
		
		if (node.left == null && node.right == null) {
			return 1;
		}
		return countLeafsHelper (node.left) + countLeafsHelper (node.right);
		
	}
	
	public boolean checkBST () {
		return checkBSTHelper (root, null, null);
	}
	
	public boolean checkBSTHelper (BSTNode node, Integer lo, Integer hi) {
		
		if (node == null) return true;
		if (lo != null && lo > node.value) return false;
		if (hi != null && hi < node.value) return false;
		return checkBSTHelper (node.left, lo, node.value) 
				&& checkBSTHelper (node.right, node.value, hi);
	}
	
	public static void traverseInOrderIt (BSTNode node) {
		
		Stack <BSTNode> stack = new Stack<>();
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
		while (!stack.isEmpty()) {
			
			BSTNode current = stack.pop();
			System.out.println(current.value + " ");
			BSTNode next = current.right;
			while (next != null) {
				stack.push(next);
				next = next.left;
			}
		}	
	}
	
	public static void postOrderIterative(BSTNode root) { 
        // Create two stacks 
        Stack <BSTNode> s1 = new Stack<>(); 
        Stack <BSTNode> s2 = new Stack<>(); 
  
        if (root == null) 
            return; 
  
        // push root to first stack 
        s1.push(root); 
  
        // Run while first stack is not empty 
        while (!s1.isEmpty()) { 
            // Pop an item from s1 and push it to s2 
            BSTNode temp = s1.pop(); 
            s2.push(temp); 
  
            // Push left and right children of 
            // removed item to s1 
            if (temp.left != null) 
                s1.push(temp.left); 
            if (temp.right != null) 
                s1.push(temp.right); 
        } 
  
        // Print all elements of second stack 
        while (!s2.isEmpty()) { 
            BSTNode temp = s2.pop(); 
            System.out.print(temp.value + " "); 
        } 
    }
	
	public void morrisInorderTraverse() {
	    BSTNode cur = root;
	    while (cur != null) {
	        if (cur.left == null) {
	            System.out.println(cur.value);  // if there is no left child, visit current node
	            cur = cur.right;  // then we go the right branch
	        } else { 
	            // find the right most leaf of root.left node. 
	            BSTNode pre = cur.left;
	            // when pre.right == null, it means we go to the right most leaf
	            // when pre.right == cur, it means the right most leaf has been visited in the last round
	            while(pre.right != null && pre.right != cur) {
	                pre = pre.right;
	            }
	               // this means the pre.right has been set, it's time to go to current node
	            if (pre.right == cur) {
	                pre.right = null;
	                // means the current node is pointed by left right most child
	                // the left branch has been visited, it's time to print the current node
	                System.out.println("from left right most--" + cur.value);  
	                cur = cur.right;
	            } else {
	               // the fist time to visit the pre node, make its right child point to current node
	                pre.right = cur;
	                System.out.println("----set pre for cur=" + cur.value);
	                cur = cur.left;
	            }
	        }
	    }
	}
	
	public static void traverseBst (BSTNode node) {
		
		if (node == null) {
			return;
		}
		traverseBst(node.left);
		System.out.print(node.value + " ");
		traverseBst(node.right);
	}
	
	public static void main (String [] args) {
		
		System.out.println("BST.java");
		
		BST bst = new BST ();
		
		bst.addNode(5);
		bst.addNode(3);
		bst.addNode(10);
		bst.addNode(0);
		bst.addNode(4);
		bst.addNode(2);
		
		bst.addNode(7);
		bst.addNode(12);
		bst.addNode(6);
		bst.addNode(8);
		bst.addNode(11);
		bst.addNode(15);
		
		//System.out.println("Root = " + bst.root.value);
		
		traverseBst(bst.root);
		System.out.println();
		
		System.out.println("Leafs = " + bst.countLeafs());
		System.out.println();
		
		bst.removeNode(5);
		bst.removeNode(15);
		bst.removeNode (0);
		bst.removeNode(8);
		
		//bst.delete(bst.root, 5);
		
		traverseBst(bst.root);
		System.out.println();
		System.out.println("Leafs = " + bst.countLeafs());
		
		System.out.println();
		BSTIterator it = bst.preOrderIterator();
		while (it.hasNext()) {
			System.out.println(it.next().value);
		}

		System.out.println("Valid BST = " + bst.checkBST());
		
		traverseInOrderIt(bst.root);
		
		System.out.println();
		
		bst.morrisInorderTraverse();
		
		
	}

}
