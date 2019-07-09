package topological;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DetectTopologicalSort {
	
	
	
	
	public static boolean hasTopologicalSortIt (TopologicalGraph graph) {
		
		int count = 0;
		
		int size = graph.adjacencyList.size();
		
		Iterator <Integer> nodeIt = graph.adjacencyList.keySet().iterator();
		
		
		while (nodeIt.hasNext()) {
			
			Integer key = nodeIt.next();
			
			Iterator <Integer> childNodeIt = graph.adjacencyList.keySet().iterator();
			
			while (childNodeIt.hasNext()) {
				
				Integer nestKey = childNodeIt.next();
				
				System.out.println("nested key = " + nestKey);
				
				List <Integer> nestChildNodes = graph.adjacencyList.get(nestKey);
			
				if (!graph.adjacencyList.get(nestKey).contains(key)) {
				
					nestChildNodes.remove(nestKey);
					
					//graph.removeNode(nestKey);
					
					graph.adjacencyList.remove(nestKey);
					
					count++;
				}
			
			}
			
			nodeIt = graph.adjacencyList.keySet().iterator();
		}
		
		if (count == size) { 
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	/*
	public boolean hasTopologicalSort (TopologicalGraph graph) {
		
		int count = 0;
		
		for (Map.Entry<Integer, List <Integer>> entry : graph.adjacencyList.entrySet()) {
			
			Integer key = entry.getKey();
			
			boolean hasNoIncoming = true;
			
			for (Map.Entry<Integer, List <Integer>> node : graph.adjacencyList.entrySet()) {
				
				if (node.getValue().contains(key)) {
					
					hasNoIncoming = false;
				}
			}
			
			if (!hasNoIncoming) {
				
			}
			
		}
		
		return false;
	}
	*/
	
	
	public static void main(String args[]) {
		
		System.out.println("DetectTopologicalSort...");
		
//		TopologicalGraph graph = new TopologicalGraph();
//		graph.addEdge(1, 2);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 4);
//		graph.addEdge(4, 5);
//		
//		boolean result = hasTopologicalSortIt(graph);
//		
//		System.out.println(result);
		
		
        int v, e, count = 1, to, from;
        Scanner sc = new Scanner(System.in);
        GraphLinkedList glist;
        try
        {
            System.out.println("Enter the number of vertices: ");
            v = sc.nextInt();
            System.out.println("Enter the number of edges: ");
            e = sc.nextInt();
            glist = new GraphLinkedList(v);
            System.out.println("Enter the edges in the graph : <from> <to>");
            while (count <= e)
            {
                to = sc.nextInt();
                from = sc.nextInt();
                glist.setEdge(to, from);
                count++;
            }
            glist.printGraph();
            System.out
                    .println("--Processing graph to check whether it is DAG--");
            if (glist.checkDAG())
            {
                System.out
                        .println("Result: \nGiven graph is DAG (Directed Acyclic Graph).");
            }
            else
            {
                System.out
                        .println("Result: \nGiven graph is not DAG (Directed Acyclic Graph).");
            }
        }
        catch (Exception E)
        {
            System.out
                    .println("You are trying to access empty adjacency list of a node.");
        }
        sc.close();
    }
	
	


}
