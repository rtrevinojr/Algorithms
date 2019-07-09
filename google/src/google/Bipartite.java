package google;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Bipartite {
	
	
	public boolean isBipartite;
	public boolean [] marked;
	public int [] edgeTo;
	public boolean [] color;
	public Stack <Integer> oddCycle;
	
	
	public Bipartite (UndirectedGraph G) {
		
		isBipartite = true;
		marked = new boolean [G.V];
		edgeTo = new int [G.V];
		color = new boolean [G.V];
		oddCycle = null;
		
		for (int i = 0; i < G.V; i++) {
			if (!marked[i] && isBipartite) {
				color[i] = true;
				bfs(G, i);
			}
		}
	}
	
	public boolean dfs (UndirectedGraph G, int v) {
		
		marked[v] = true;
		
		for (int w : G.adjacent[v]) {
			
			if (oddCycle != null) return false;
			
			if (!marked[w]) {
				edgeTo[w] = v;
				color[w] = !color[v];
				dfs(G, w);
			}
			else {
				if (color[w] == color[v]) {
					this.isBipartite = false;
					
					oddCycle = new Stack<>();
					oddCycle.add(w);
					
					for (int i = v; i != w; i = edgeTo[i]) {
						oddCycle.add(i);
					}
					oddCycle.add(w);
				}
			}
		}
		
		return this.isBipartite;
	}
	
	public boolean bfs (UndirectedGraph G, int s) {
		
		marked[s] = true;
		color[s] = true;
		
		Queue <Integer> queue = new LinkedList <>();
		queue.add(s);
		
		while (!queue.isEmpty()) {
			
			int q = queue.remove();
			
			for (int w : G.adjacent[q]) {
				
				if (!marked[w]) {
					marked[q] = true;
					edgeTo[w] = q;
					color[w] = !color[q];
					queue.add(w);
				}
				else if (color[q] == color[w]) {
					
					this.isBipartite = false;
					Stack <Integer> cycle = new Stack <>();
					cycle.add(w);
					for (int i = q; i != w; i = edgeTo[i]) {
						cycle.add(i);
					}
					cycle.add(w);
					oddCycle = cycle;
				}
			}
		}
		
		return this.isBipartite;
		
	}
	
	public void printBipartiteGroups () {
		
		for (int i = 0; i < color.length; i++) {
			String group = color[i] ? "RED" : "BLUE";
			System.out.println("Node " + i + " - " + group); 
		}
	}
	
	public static void main (String [] args) {
		
		System.out.println("Bipartite.java");
		
		UndirectedGraph graph = new UndirectedGraph (9);
		graph.addEdge(0, 1);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(0, 2);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		
		graph.addEdge(0, 4);
		
		
		Bipartite bipartite = new Bipartite(graph);
		
		System.out.println("Result G is Bipartite = " + bipartite.isBipartite);
		
		bipartite.printBipartiteGroups();
		
		System.out.println(bipartite.oddCycle.toString());
		
		
	}

}
