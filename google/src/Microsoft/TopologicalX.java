package Microsoft;

import java.util.*;


public class TopologicalX {

	
	public HashSet <Integer> marked;
	public List <Integer> order;
	public boolean hasCycle;
	
	public Queue <Integer> queue;
	
	
	public TopologicalX (Digraph G) {
		
		marked = new HashSet <>();
		order = new LinkedList <>();
		hasCycle = false;
		queue = new LinkedList<>();
		
		for (Integer n : G.adjacent.keySet()) {
			if (G.indegree.get(n) == 0) {
				queue.add(n);
			}
		}
		
		System.out.println("queue size = " + queue.toString());
		
		
		for (Integer n : G.adjacent.keySet()) {
			if (!marked.contains(n))
			bfs(G, n);
		}
	}
	
	
	public void bfs (Digraph G, int v) {
		
		
		while (!queue.isEmpty()) {
			
			Integer n = queue.remove();
			marked.add(n);
			order.add(n);

			for (Integer w : G.adjacent.get(n)) {
				
				if (!marked.contains(w)) {
					G.indegree.put(w, G.indegree.get(w) - 1);
					if (G.indegree.get(w) == 0) {
						queue.add(w);
					}
				}
			}			
			
		}
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("TopologicalX.java");
		
		Digraph graph = new Digraph();
		graph.addEdge(5, 3);
		graph.addEdge(3, 1);
		graph.addEdge(3, 4);
		graph.addEdge(5, 8);
		graph.addEdge(8, 7);
		graph.addEdge(7, 6);
		graph.addEdge (8, 9);
		
		//graph.addEdge(8, 5);
		graph.addEdge (10, 5);
		
		graph.addEdge (20, 15);
		graph.addEdge (20, 25);
		graph.addEdge (25, 26);
		
		TopologicalX topo = new TopologicalX(graph);
		
		System.out.println("Topological Sort = " );
		
		System.out.println(topo.order.toString());
		
		
		
		
	}
	
}





