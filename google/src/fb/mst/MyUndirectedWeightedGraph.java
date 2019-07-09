package fb.mst;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyUndirectedWeightedGraph {
	
	private final int V;
	private int E;
	
	private Map <Integer, List <WeightedEdge>> adjList;
	
	
	public MyUndirectedWeightedGraph (int v) {
		this.V = v;
		this.E = 0;
		this.adjList = new HashMap <Integer, List <WeightedEdge>> ();
		for (int i = 1; i <= v; i++) {
			adjList.put(i, new LinkedList <WeightedEdge> ());
		}
	}
	
	public Map <Integer, List <WeightedEdge>> getAdjList () {
		return adjList;
	}
	
	public List <WeightedEdge> getAdjEdges (int v) {
		return adjList.get(v);
	}
	
	public int V() {
		return this.V;
	}
	public int E() {
		return this.E;
	}
	
	
	public void addEdge (int u, int v, int w) {
		
		List <WeightedEdge> edges = adjList.get(u);
		edges.add(new WeightedEdge (u, v, w));
		this.adjList.put(u, edges);
	}

}
