package fb;

import java.util.*;

public class MyGraph {

	private int V;
	private int E;
	public Map <Integer, List<Integer>> adjacencyList;
	private boolean marked[];

	public MyGraph(int v) {
		this.V = v;
		adjacencyList = new HashMap<Integer, List<Integer>>();
		marked = new boolean[V + 1];
		for (int node = 1; node <= v; node++) {
			adjacencyList.put(node, new LinkedList<Integer>());
		}
	}

	public void addEdge(int u, int v) throws Exception {
		if (!validVertex(u))
			throw new Exception("Vertex " + u + " is not a valid vertex");
		this.E++;
		List<Integer> result = adjacencyList.get(u);
		result.add(new Integer(v));
		adjacencyList.put(new Integer(u), result);
	}

	public boolean validVertex(int v) {
		if (v > V || v < 1)
			return false;
		return true;
	}

	public List<Integer> getAdjacentNodes(int v) {
		if (validVertex(v))
			return adjacencyList.get(v);
		else
			return null;
	}
	
	public int countChildrenFromNode (int v) {		
		return countChildrenFromNodeHelper (v) + 1;
	}
	
	public int countChildrenFromNodeHelper (int v) {
		
		List <Integer> children = getAdjacentNodes (v);
		int result = 0;
		if (getAdjacentNodes (v) != null) {	
			for (Integer child: getAdjacentNodes (v)) {
				result += 1 + countChildrenFromNodeHelper(child.intValue());
			}
		}
		return result;
	}
	
	public void printChildrenFromNodeHelper(int v, int count) {

		List<Integer> children = getAdjacentNodes(v);
		System.out.print("" + v + " - ");
		if (children != null) {
			
			for (Integer child : children) {
				printChildrenFromNodeHelper(child.intValue(), ++count);
				
			}
		}
		
	}
	
	
	
	
	
	
	
}
