package Microsoft;

import java.util.*;

public class Digraph {

	
	public int V;
	public int E;
	
	public HashMap <Integer, LinkedList <Integer>> adjacent;
	
	public HashMap <Integer, Integer> indegree;
	
	
	public Digraph () {
		
		V = 0;
		E = 0;
		adjacent = new HashMap <>();
		indegree = new HashMap <> ();
	}
	
	public void addEdge (int v, int w) {
		
		if (adjacent.containsKey(v)) {
			LinkedList <Integer> adjacentNodes = adjacent.get(v);
			adjacentNodes.add(w);
			adjacent.put(v, adjacentNodes);
			E++;
		}
		else {
			LinkedList <Integer> adjacentNodes = new LinkedList <> ();
			adjacentNodes.add(w);
			adjacent.put(v, adjacentNodes);
			V++;
			E++;
			indegree.put(v, 0);
		}
		
		if (!adjacent.containsKey(w)) {
			adjacent.put(w, new LinkedList <> ());
			V++;
			indegree.put(w, 1);
		}
		else {
			indegree.put(w, indegree.get(w) + 1);
		}
	}
	
	public void bfs (int src) {
		
		Queue <Integer> queue = new LinkedList <> ();
		queue.add(src);
		
		while (!queue.isEmpty()) {
			
			Integer node = queue.remove();
			
		}
		
	}
	
}
