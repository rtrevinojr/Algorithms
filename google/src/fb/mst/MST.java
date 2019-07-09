package fb.mst;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MST {
	
	
	public MyUndirectedWeightedGraph graph;
	
	
	public MST (MyUndirectedWeightedGraph graph) {
		
		this.graph = graph;
	}
	
	
	
	public int calculateMST () {
		
		MyUndirectedWeightedGraph mst = new MyUndirectedWeightedGraph (graph.V());
		MyUndirectedWeightedGraph mstTest = new MyUndirectedWeightedGraph (graph.V());

		
		List <WeightedEdge> sortedEdges = sortEdges();
		int result = 0;
				
		for (WeightedEdge edge: sortedEdges) {
			//mstTest.addEdge(u, v, w);
		}
	}
	
	public List <WeightedEdge> sortEdges () {
		
		List <WeightedEdge> result = new LinkedList <WeightedEdge> ();
		
		for (List <WeightedEdge> edges: graph.getAdjList().values()) {
			result.addAll(edges);
		}
	
		Collections.sort(result);
		return result;
	}
	
	
	public boolean detectCycle (MyUndirectedWeightedGraph graph, int v) {
		
		boolean [] marked = new boolean [graph.V() + 1];
		marked[v] = true;
		
		List <WeightedEdge> children = graph.getAdjEdges(v);
		for (WeightedEdge edge: children) {
			int from = edge.either();
			int to = edge.other(from);
			if (!marked[to]) {
				marked[to] = true;
				detectCycle(graph, to);
			}
			else
				return true;
		}
		return false;
	}
	
	
	public static void main (String [] args) {
		
		try {
			Scanner scan = new Scanner (new File("mstinput.txt"));
	
			int q = scan.nextInt();
			for (int i = 0; i < q; i++) {
				int n = scan.nextInt();
				int m = scan.nextInt();
				assert 2 <= n && n <= 3000;
				assert 1 <= m && m <= (n * (n - 1)/2);

				MyUndirectedWeightedGraph graph = new MyUndirectedWeightedGraph (n);
				
				for (int e = 0; e < m; e++) {
					int u = scan.nextInt();
					int v = scan.nextInt();	
					int w = scan.nextInt();
					assert 1 <= u && u <= n && 1 <= v && v <= n;
					assert 0 <= w && w <= 100000;
					//MyDirectedEdge edge = new MyDirectedEdge(u, v, w);
					//MyDirectedEdge edgeR = new MyDirectedEdge(v, u, w);
					//graph.addDirectedEdge(u, v, w);
					//graph.addDirectedEdge(v, u, w);
					graph.addEdge(u, v, w);
				}
				int s = scan.nextInt();
				System.out.println("s = " + s);
				
				
				System.out.println();
				//printGraph(graph.adjacencyList);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
