package fb;

import java.io.File;
import java.util.*;


public class Dijkstra {
	
	public int [] dist;
	public int [] prev;
	
	public DirectedWeightedGraph graph;
	
	public List <Integer> set;
	
	private static final int MAX_WEIGHT = (int) Math.pow(10, 5);
	
	
	public Dijkstra (DirectedWeightedGraph graph, int size) {
		
		this.graph = graph;
		
		dist = new int [size + 1];
		prev = new int [size + 1];
		
		set = new ArrayList <Integer> ();
		
		for (int i = 1; i <= size; i++) {
			dist[i] = MAX_WEIGHT;
			prev[i] = 0;
			set.add(new Integer(i));
		}
		
		
	}
	
	
	public int getAndRemoveVertexWithMinDist () {
		
		int min = MAX_WEIGHT;
		for (int d: set) {
			if (dist[d] <= min)
				min = d;
		}
		set.remove(new Integer(min));
		return min;
	}
	
	
	public void performDijkstra (DirectedWeightedGraph graph, int source) {
		
		dist[source] = 0;
	
		while (!set.isEmpty()) {
		
			int minNode = getAndRemoveVertexWithMinDist();
			
			List <MyDirectedEdge> children = graph.getAdjacentNodesInSet(minNode, set);
			if (children != null) {
			for (MyDirectedEdge node: children) {
				int alt = dist[minNode] + (int) node.weight();
				if (alt < dist[node.to()]) {
					dist[node.to()] = alt;
					prev[node.to()] = node.to();
				}
			}
			}
		}
		
	}
	
	
	public void printShortestPathArray () {
		
		for (int i = 0; i < dist.length; i++) {
			System.out.println("" + i + " - " + dist[i]);
		}
	}
	
	public void printShortestPathArray2 (int source) {
			
			for (int i = 1; i < dist.length; i++) {
	            if (source != i) {
	                if (dist[i] >= MAX_WEIGHT - 1)
	                    System.out.print("-1 ");
	                else
				         System.out.print(dist[i] + " ");
	            }
			}
	        System.out.println();
		}
	
	public static void printGraph(Map<Integer, List<MyDirectedEdge>> adjList) {

		for (Map.Entry<Integer, List<MyDirectedEdge>> entry : adjList.entrySet()) {
			Integer node = entry.getKey();
			List<MyDirectedEdge> edges = entry.getValue();
			System.out.print("(" + node.toString() + "): ");
			for (MyDirectedEdge edge : edges) {
				System.out.print(edge.toString() + " - ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public static void main (String [] args) {
		System.out.println("HackerRank BRS " + "\n" + "Dijstra.java"); 		 
		System.out.println(System.getProperty("user.dir"  + "\n"));
		
		try {
			Scanner scan = new Scanner (new File("dijkstra3.txt"));
	
			int q = scan.nextInt();
			for (int i = 0; i < q; i++) {
				int n = scan.nextInt();
				int m = scan.nextInt();
				DirectedWeightedGraph graph = new DirectedWeightedGraph (n);
				for (int e = 0; e < m; e++) {
					int u = scan.nextInt();
					int v = scan.nextInt();	
					int w = scan.nextInt();
					MyDirectedEdge edge = new MyDirectedEdge(u, v, w);
					MyDirectedEdge edgeR = new MyDirectedEdge(v, u, w);
					graph.addDirectedEdge(u, v, w);
					graph.addDirectedEdge(v, u, w);
				}
				int s = scan.nextInt();
				//System.out.println("s = " + s);
				
				Dijkstra dijkstra = new Dijkstra(graph, n);
				dijkstra.performDijkstra(graph, s);

				//dijkstra.printShortestPathArray();
				dijkstra.printShortestPathArray2(s);
				System.out.println();
				//printGraph(graph.adjacencyList);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}
