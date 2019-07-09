
package trees;

import java.util.*;


public class MyTree <Key extends Comparable<Key>, Value> {
	
	private Node root;	
	
	private class Node {
		private Key key;
		private Value value;
		private Node left;
		private Node right;
		private int size;
		
		public Node (Key key, Value value, int size) {
			this.key = key;
			this.value = value;
			this.size = size;
		}
	}
	
	
	
	
	

}
