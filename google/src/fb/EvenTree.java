package fb;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EvenTree {
	
	public MyGraph graph;
	
	private int evenTreeCount;
	
	public int totalCount;
	
	public EvenTree (MyGraph graph) {
		this.graph = graph;
		this.totalCount = graph.countChildrenFromNode(1);
	}
	
	public int countEvenBreaks (int root) {
		
		int result = 0;    
        LinkedList <Integer> queue = new LinkedList <> (); 
        queue.add(new Integer(root));
        
        while (!queue.isEmpty()) {
        	
        	Integer next = queue.remove(); 	
        	int countFromNode = graph.countChildrenFromNode(next);
        	if (countFromNode % 2 == 0 
        			&& countFromNode != 0
        			&& ((graph.countChildrenFromNode(1) - countFromNode) % 2 == 0)
        			&& countFromNode != totalCount) {
            	result++;
        	}
        	
        	List <Integer> adjNodes = graph.getAdjacentNodes(next);
        	if (adjNodes != null)
        		queue.addAll(adjNodes);
        }
        return result;
    }
	
	public static void printGraph(Map<Integer, List<Integer>> adjList) {

		for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
			Integer node = entry.getKey();
			List<Integer> edges = entry.getValue();
			System.out.print("(" + node.toString() + "): ");
			for (Integer edge : edges) {
				System.out.print(edge.toString() + " - ");
			}
			System.out.println();
		}
		System.out.println();
	}
    
    

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	System.out.println("HackerRank BRS " + "\n" + "EvenTree.java"); 		 
    	System.out.println(System.getProperty("user.dir"  + "\n"));
    	
    	try {    		
	        Scanner scan = new Scanner(new File("hackerGraph.txt"));
	        int q = scan.nextInt();
	        System.out.println("q = " + q + "\n");
	        //EvenTree evenTree = new EvenTree ();
	        for (int i = 0; i < q; i++) {
	            int n = scan.nextInt();
	            int m = scan.nextInt();
	            System.out.print("n = " + n + "  ");
	            System.out.println("m = " + m);
	            MyGraph graph = new MyGraph(n);
	            for (int e = 0; e < m; e++) {
	                int u = scan.nextInt();
	                int v = scan.nextInt();
	                System.out.print("u = " + u + "  ");
	                System.out.println("v = " + v);
	                try {
	                    graph.addEdge(v, u);
	                }
	                catch(Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	            int s = scan.nextInt();
	            
	            
	            EvenTree evenTree = new EvenTree(graph);
	            int totalCount = evenTree.evenTreeCount;
	            
	            System.out.println("Total Node count = " + totalCount);
	            
	            System.out.println("s = " + s);
	            System.out.println();
	            
	            printGraph(graph.adjacencyList);
	            
	            System.out.println();
	            graph.printChildrenFromNodeHelper(1, 0);
	            
	            int n1 = 1;
	            int cnt = graph.countChildrenFromNode(n1);
	            System.out.println("\n" + "node count = " + cnt);
	            //printGraph(graph.adjacencyList);
	            
	            System.out.println();
	            //evenTree.countEvenBreaks(graph, 1);
	            System.out.println("master count = " + evenTree.countEvenBreaks(1));
	            
	            System.out.println();
	        }
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
    }
    
}
