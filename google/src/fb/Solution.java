package fb;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public class Graph {
        
        private int V;
        private int E;
        private Map <Integer, List <Integer>> adjacencyList;
        
        private boolean marked [];
        
        public Graph(int v) {
                this.V = v;
                adjacencyList = new HashMap <Integer, List <Integer>> ();
                marked = new boolean [V+1];
            
                for (int node = 1; node <= v; node++) {
                    adjacencyList.put(node, new LinkedList <Integer> ());
                    
                }
        }
        
        public void addEdge(int u, int v) throws Exception {
            if (!validVertex(u))
                throw new Exception("Vertex " + u + " is not a valid vertex");
            this.E++;
            List <Integer> result = adjacencyList.get(u);
            result.add(new Integer(v));
            adjacencyList.put(new Integer(u), result);
        }
        
        public boolean validVertex (int v) {
            if (v > V || v < 1)
                return false;
            return true;
        }
        
        public List <Integer> getChildren (int v) {
            if (validVertex(v))
                return adjacencyList.get(v);
            else 
                return null;
        }
        
        public int getShortestPath (int u, int v) {
               return 0;
        }
        
        public void resetMarkedNodes () {
        	marked = new boolean[this.V+1];
        }
        
        public int bfs (int u, int v) {
        	   	
			List <Integer> queue = new ArrayList <Integer> ();
        	queue.add(u);
        	//System.out.println("Level 0: init node = " + u);
        	
        	marked[u] = true;
        	
        	int level = 0;
        	
        	int prevQCnt = 0;
        	
        	boolean found = false;
        	List <Integer> nextLevelChildren = new LinkedList<Integer> ();
        	
        	while (!queue.isEmpty()) {
        		
        		Integer node = queue.get(0);
        		int nodeNum = node.intValue();
        		marked[nodeNum] = true;
        		if (node.equals(v))
        			return level;
        		//System.out.println("Node level " + level + ": " + String.valueOf(node));
        		queue.remove(0);
        		
        		List <Integer> children = getChildren(node);
        		
        		
        		for (int w: children) {

        			nextLevelChildren.add(new Integer(w));

        		}
        		
        		if (queue.isEmpty()) {
        			level++;
        			for (Integer n: nextLevelChildren) {
        					
        					queue.add(n);
        			}
        			nextLevelChildren = new LinkedList <Integer> ();
        		}
        		
        	}
        	return 0;
        	
        }
    
        public int dfs (int u, int v, int count) {
            
        	marked[u] = true;
        	for (int w: getChildren(u)) {
        		
        		if (w == v)
        			return count + 1;
        		
        		if (!marked[w])
        			dfs(w, u, count + 1);
        		
        		
        		
        	}
        	
        	return 0;
        
        }
        /*
        public int dfs2 (int u, int v) {
            
            int size = getChildren(u).size();
            if (size == 0)
                return 0;
            else if (u == v)
                return 1;
        }
        */   
        
    }
    
    public static int computeShortestPath (Graph G) {
        return 0;
    }
    
    
    public static void printGraph (Map <Integer, List<Integer>> adjList) {
    	
    	for (Map.Entry<Integer, List<Integer>> entry: adjList.entrySet()) {
    		Integer node = entry.getKey();
    		List <Integer> edges = entry.getValue();
    		System.out.print("(" + node.toString() + "): "); 
    		for (Integer edge: edges) {
    			System.out.print(edge.toString() + " - ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	
		System.out.println("HackerRank BRS " + "\n" + "Solution.java"); 		 

    	System.out.println(System.getProperty("user.dir"  + "\n"));
    	
    	
    	try {    		
	        Scanner scan = new Scanner(new File("hackrankInput2.txt"));
	        int q = scan.nextInt();
	        System.out.println("q = " + q + "\n");
	        Solution sol = new Solution();
	        for (int i = 0; i < q; i++) {
	            int n = scan.nextInt();
	            int m = scan.nextInt();
	            System.out.print("n = " + n + "  ");
	            System.out.println("m = " + m);
	            Graph graph = sol.new Graph(n);
	            for (int e = 0; e < m; e++) {
	                int u = scan.nextInt();
	                int v = scan.nextInt();
	                System.out.print("u = " + u + "  ");
	                System.out.println("v = " + v);
	                try {
	                    graph.addEdge(u, v);
	                }
	                catch(Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	            int s = scan.nextInt();
	            
	            System.out.println("s = " + s);
	            System.out.println();
	            
	            printGraph(graph.adjacencyList);
	            //int result = graph.dfs(s, 3, 0);
	            //int result = graph.bfs(s, 3);
	            for (int j = 1; j <= n ; j++) {
	            	if (j != s) {
	            		graph.resetMarkedNodes();
	            		int cnt = graph.bfs(s, j);
	            		if (cnt == 0) {
	            			System.out.print("-1 ");
	            		}
	            		else 
	            			System.out.print(cnt * 6 + " ");
	            	}
	            }
	            System.out.println();
	        }
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    	}
        
        
      
        
    }
}
    