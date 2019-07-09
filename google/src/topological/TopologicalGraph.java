package topological;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopologicalGraph {
	
	
	public Map <Integer, List <Integer>> adjacencyList;
	
	
	public TopologicalGraph () {
		
		adjacencyList = new HashMap <> ();
	}
	 
	public void addEdge (int u, int v) {
		
		if (adjacencyList.containsKey(u)) {
			List <Integer> outgoingNodes = adjacencyList.get(u);
			outgoingNodes.add(v);
			adjacencyList.put(u, outgoingNodes);
		}
		else {
			List <Integer> outgoingNodes = new LinkedList <> ();
			outgoingNodes.add(v);
			adjacencyList.put(u, outgoingNodes);
		}
	}
	
	public boolean removeNode (int u) {
		
		List <Integer> result = adjacencyList.remove(u);
		if (result != null) return true;
		return false;
	}
	
	
	
	
	public static void main (String [] args) {
		
		System.out.println("Topological Graph");
		
	}

}
