package google;

import java.util.LinkedList;
import java.util.List;

public class Node {
	
	public Integer value;
	public List <Node> children;
	
	public Node (int val) {
		value = val;
		children = new LinkedList <>();
	}
	
	public void addChild (Node n) {
		children.add(n);
	}
	
	
}
