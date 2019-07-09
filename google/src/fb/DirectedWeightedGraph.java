package fb;

import java.util.*;
import java.util.Map.Entry;

public class DirectedWeightedGraph {
	
	private int V;
	private int E;
	
	public Map <Integer, List<MyDirectedEdge>> adjacencyList;
	
	public boolean marked [];
	
	public DirectedWeightedGraph (int V) {
		this.V = V;
		this.E = 0;
		this.adjacencyList = new HashMap <Integer, List<MyDirectedEdge>> ();
		for (int i = 1; i <= V; i++) {
			this.adjacencyList.put(new Integer(i), new LinkedList <MyDirectedEdge> ());
		}
	}
	
	public boolean hasEdge(int u, int v, int w) {
		
		List <MyDirectedEdge> adjNodes = adjacencyList.get(u);
		for (MyDirectedEdge edge: adjNodes) {
			if (edge.to() == v && edge.from() == u && edge.weight() > w) {
				return true;
			}
		}
		return false;
	}
	
	public void replaceEdge (int u, int v, int w) {
		
		List <MyDirectedEdge> adjNodes = adjacencyList.get(u);
		for (MyDirectedEdge edge: adjNodes) {
			if (edge.to() == v && edge.from() == u && edge.weight() > w) {
				edge.setWeight(w);
			}
		}
	}
	
	
	public void addDirectedEdge (int u, int v, int w) {
		MyDirectedEdge edge = new MyDirectedEdge (u, v, w);
		List <MyDirectedEdge> adjNodes = adjacencyList.get(u);
		if (hasEdge(u, v, w)) {
			replaceEdge(u, v, w);
		}
		else {
			adjNodes.add(edge);
			this.adjacencyList.put(u, adjNodes);
		}
	}
	
	public boolean validVertex(int v) {
		if (v > V || v < 1)
			return false;
		return true;
	}

	public List<MyDirectedEdge> getAdjacentNodes(int v) {
		if (validVertex(v))
			return adjacencyList.get(v);
		else
			return null;
	}
	
	public List<MyDirectedEdge> getAdjacentNodesInSet(int v, List <Integer> set) {
		List <MyDirectedEdge> result = new ArrayList <MyDirectedEdge> ();
		if (validVertex(v)) {
			//result = adjacencyList.get(v);
			for (MyDirectedEdge node: adjacencyList.get(v)) {
				if (set.contains(node.to())) 
					result.add(new MyDirectedEdge(node.from(), node.to(), (int) node.weight()));
			}
			return result;
		}
		else
			return null;
	}

}
