package graph_theory;

import java.util.Stack;

public class MyDirectedCycle {

	private boolean[] marked;
	private boolean[] onStack;
	private int[] edgeTo;
	private Stack<Integer> cycle;
	private boolean hasCycle;
	
	public MyDirectedCycle(MyDigraph G) {
		marked = new boolean[G.V()];
		onStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		
	}
	
	public void detectCycle(MyDigraph G, int v) {
		
		marked[v] = true;
		onStack[v] = true;
		
		for (Integer w: G.getAdjacentVertices(v)) {
			if (!marked[w]) {
				detectCycle(G, w);
			}
			else if (onStack[w]) {
				hasCycle = true;
				return;
			}
		}
		
		onStack[v] = false;
	}
	
	public void getDetectedCycle (MyDigraph G, int v) {
		
		marked[v] = true;
		onStack[v] = true;
		
		for (Integer w: G.getAdjacentVertices(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				getDetectedCycle(G, w);
			}
			else if (onStack[w]) {
				hasCycle = true;
				cycle = new Stack<Integer> ();
				for (int i = v; i != w; i = edgeTo[i]) {
					cycle.push(i);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v] = false;
	}
	
	public boolean findCycle (MyDigraph G) {
		
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) 
				getDetectedCycle(G, v);
		}
		
		return hasCycle;
	}
	
    public static void main (String [] args) {
		System.out.println(" ----- MyDirectedCycle.java ----- ");
		
		MyDigraph graph = new MyDigraph (9);
		graph.addEdge(1, 2);
		graph.addEdge(2, 7);
		graph.addEdge(2, 6);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(5, 3);
		graph.addEdge(5, 8);
		
		MyDirectedCycle myCycle = new MyDirectedCycle(graph);
		
		System.out.println("MyDigraph cycle detected = " + myCycle.findCycle(graph));
		
		//myCycle.getDetectedCycle(G, v);
		System.out.println("MyDigraph cycle = " + myCycle.cycle.toString());
		
		System.out.println(graph.toString());
		
    }
	
}
