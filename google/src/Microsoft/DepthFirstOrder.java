package Microsoft;

import java.util.*;


public class DepthFirstOrder {

	
	public LinkedList <Integer> order;
	
	public HashSet <Integer> marked;
	
	
	public DepthFirstOrder (Digraph G) {
		
		order = new LinkedList <>();
		marked = new HashSet<>();
		
		for (Integer node : G.adjacent.keySet()) {
			if (!marked.contains(node)) {
				dfs (G, node);
			}
		}
		
		Collections.reverse(this.order);
	}
	
	public void dfs (Digraph G, int v) {
		
		marked.add(v);
		
		for (Integer w : G.adjacent.get(v)) {
			
			if (!marked.contains(w)) {
				dfs (G, w);
			}
		}
		this.order.add(v);
	}
	
	
}
