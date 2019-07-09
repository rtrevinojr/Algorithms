package Microsoft;

import java.util.*;

public class DetectCycle {

	
	public HashSet <Integer> marked;
	public HashSet <Integer> ancestor;
	
	public HashMap <Integer, Integer> edgeTo;
	
	public LinkedList <Integer> cycle;
	
	public boolean acyclic;
	
	
	public DetectCycle (Digraph graph) {
		
		marked = new HashSet <> ();
		ancestor = new HashSet <>();
		edgeTo = new HashMap <>();
		cycle = null;
		acyclic = false;
		
		
		for (Integer node : graph.adjacent.keySet()) {
			
			if (!marked.contains(node)) {
				dfs (graph, node);
			}
		}
	}
	
	public void dfs (Digraph graph, int src) {
		
		marked.add(src);
		ancestor.add(src);
		
		for (Integer n : graph.adjacent.get(src)) {
			
			if (!marked.contains(n)) {
				edgeTo.put(n, src);
				dfs (graph, n);
			}
			else if (ancestor.contains(n)) {
				this.acyclic = true;
				this.cycle = new LinkedList <>();
				for (int i = src; i != n; i = edgeTo.get(i)) {
					
					cycle.add(i);
				}
				cycle.add(n);
				cycle.add(src);
			}
		}
		
		ancestor.remove(src);
	
	}
	
	
	
	
	
	public static void main (String [] args) {
		
		System.out.println("DetectCycle.java");
		
		Digraph graph = new Digraph();
		graph.addEdge(5, 3);
		graph.addEdge(3, 1);
		graph.addEdge(3, 4);
		graph.addEdge(5, 8);
		graph.addEdge(8, 7);
		graph.addEdge(7, 6);
		graph.addEdge (8, 9);
		graph.addEdge (6, 5);
		
		System.out.println("Graph size = " + graph.V);
		
		DetectCycle detect = new DetectCycle (graph);
		
		System.out.println("Graph is Acyclic: ");
		System.out.println(detect.acyclic);
		System.out.println(detect.cycle.toString());
		
		DepthFirstOrder dforder = new DepthFirstOrder (graph);
		
		System.out.println("Depth First Order " );
		
		System.out.println(dforder.order.toString());
		
	}
}
