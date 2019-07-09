package fb;

import java.io.File;
import java.util.Scanner;

public class MST {
	
	
	public static void main (String [] args) {
		
		try {
			Scanner scan = new Scanner (new File("input.txt"));
	
			int q = scan.nextInt();
			for (int i = 0; i < q; i++) {
				int n = scan.nextInt();
				int m = scan.nextInt();
				assert 2 <= n && n <= 3000;
				assert 1 <= m && m <= (n * (n - 1)/2);
				//DirectedWeightedGraph graph = new DirectedWeightedGraph (n);
				MyGraph graph = new MyGraph (n);
				
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
					graph.addEdge(u, v);
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
