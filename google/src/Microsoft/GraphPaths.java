package Microsoft;

import java.util.*;


public class GraphPaths {

	
	public HashSet <Integer> marked;
	public int pathSize = 0;
	
	
	public GraphPaths (DigraphMat G) {
		
		marked = new HashSet <> ();
		
	}
	
	public void printAllPathsW3 (Digraph G, int v) {
		
		this.clearMarkedNodes();
		int [] paths = new int [G.V];
		
		System.out.println();
		System.out.println("Print All Paths With 3: " );
		
		printAllPathsW3Helper (G, v, paths, 0, false);
	}
	
	public void printAllPathsW3Helper (Digraph G, int v, int [] path, int len, boolean has3) {
		
		marked.add(v);
		path[len++] = v;
		
		if (v == 3) { has3 = true; }
		
		if (G.adjacent.get(v).size() == 0 && has3) {
			printArray(path, len);
		}
		
		for (Integer node : G.adjacent.get(v)) {
			if (!marked.contains(node)) {
				printAllPathsW3Helper (G, node, path, len, has3);
			}
		}
	}
	
	
	public void printAllPaths (Digraph G, int v) {
		
		this.clearMarkedNodes();
		int [] paths = new int [G.V];
		
		System.out.println();
		System.out.println("Print All Paths: " );
		
		printAllPathsHelper (G, v, paths, 0);
	}
	
	public void printAllPathsHelper (Digraph G, int v, int [] path, int len) {
		
		marked.add(v);
		
		path[len++] = v;
		
		if (G.adjacent.get(v).size() == 0) 
			printArray(path, len);
		
		for (Integer node : G.adjacent.get(v)) {
			if (!marked.contains(node)) 
				printAllPathsHelper (G, node, path, len);
			
		}
	
	}
	
	
	public int shortestPath (Digraph G, int v, int w) {
		
//		dfs (G, v, w, 0);
//		return pathSize;
		
		return bfs (G, v, w);
		
	}
	
	public void dfs (Digraph G, int v, int w, int height) {
		
		marked.add(v);
		
		for (Integer node : G.adjacent.get(v)) {
			if (!marked.contains(node)) {
				if (node == w) {
					pathSize = height + 1;
				}
				else {
					dfs (G, node, w, height + 1);
				}
			}
		}
		//return -1;
	}
	
	public int bfs (Digraph G, int v, int w) {
		
		int result = 0;
		
		Queue <Integer> curLevelQ = new LinkedList <> ();
		curLevelQ.add(v);
		
		Queue <Integer> nextLevelQ = new LinkedList <> ();
		
		while (!curLevelQ.isEmpty()) {
			
			Integer curNode = curLevelQ.remove();
			marked.add(curNode);
			
			if (curNode == w) {
				return result;
			}
			
			for (Integer node : G.adjacent.get(curNode)) {
				if (!marked.contains(node)) {
					nextLevelQ.add(node);
				}
			}
			
			if (curLevelQ.isEmpty()) {
				curLevelQ = nextLevelQ;
				result++;
				nextLevelQ = new LinkedList <> ();
			}
		}
		
		return -1;
		
	}
	
	
	public void clearMarkedNodes () {
		marked = new HashSet <> ();
	}
	
	public void dfs (DigraphMat G, int v) {
		
		marked.add(v);
		System.out.print(v + " ");
		
		for (int i = 0; i < G.V; i++) {
			if (G.adjacentMatrix[v][i] && !marked.contains(G.adjacentMatrix[v][i])) {
				dfs (G, i);
			}
		}
		//System.out.println();
	}
	
	public void bfs (DigraphMat G, int v) {
		
		Queue <Integer> queue = new LinkedList <>();
		queue.add(v);
		
		while (!queue.isEmpty()) {
			
			Integer node = queue.remove();
			marked.add(node);
			System.out.print(node + " ");
			
			for (int i = 0; i < G.V; i++) {
				if (!marked.contains(i) && G.adjacentMatrix[node][i]) {
					queue.add(i);
				}
			}
		}
		
		System.out.println();
		
	}
	
	public static void printArray (int [] arr, int len) {
		
		for (int i = 0; i < len; i++) 
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main (String [] args) {
		
		System.out.println("GraphPaths.java");
		
		DigraphMat G = new DigraphMat (10);
		G.addEdge(5, 3);
		G.addEdge (3, 1);
		G.addEdge (3, 4);
		G.addEdge (5, 8);
		G.addEdge (8, 7);
		G.addEdge (7, 6);
		G.addEdge (8, 9);
		
		
		GraphPaths graphPaths = new GraphPaths (G);
		
		graphPaths.bfs(G, 5);
		graphPaths.clearMarkedNodes();
		graphPaths.dfs(G, 5);
		graphPaths.clearMarkedNodes();
		
		Digraph digraph = new Digraph();
		digraph.addEdge(5, 3);
		digraph.addEdge(3, 1);
		digraph.addEdge (3, 4);
		digraph.addEdge (5, 8);
		digraph.addEdge (8, 7);
		digraph.addEdge (7, 6);
		digraph.addEdge (8, 9);
		
		digraph.addEdge (1, 6);
		
		
		graphPaths.printAllPaths(digraph, 5);
		
		int v = 5;
		int w = 9;
		int count = graphPaths.shortestPath(digraph, v, w);
		
		System.out.println();
		System.out.println("Path size = " + count);
		
	}
}
