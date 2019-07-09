package bfs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    public static class Graph {
        
        Map <Integer, List <Integer>> adjMap;
        
        public Graph(int size) {
            
            adjMap = new HashMap <Integer, List <Integer>> ();
            for (int i = 1; i <= size; i++) {
                adjMap.put(i, new LinkedList<Integer>());
            }
            
        }
        
        public  void printGraph () {
            
            for (Map.Entry<Integer, List <Integer>> entry : adjMap.entrySet()) {
                
                System.out.print(entry.getKey() + " - ");
                for (Integer i : entry.getValue()) {
                    System.out.print(i + ", ");
                }
                System.out.println();
            }
        }

        public void addEdge(int first, int second) {
            
            if (adjMap.containsKey(first)) {
                List <Integer> adjNodes = adjMap.get(first);
                adjNodes.add(second);
                adjMap.put(first, adjNodes);
            }
            else {
                //adjMap.put(first, new LinkedList<>().add(second));
            }
            
            if (adjMap.containsKey(second)) {
                List <Integer> adjNodes = adjMap.get(second);
                adjNodes.add(first);
                adjMap.put(second, adjNodes);
            }
            else {
                //adjMap.put(second, new LinkedList<>().add(first));
            }
        }
        
        public void addAllEdges(int [] graphFrom, int [] graphTo) {
            
            for (int i = 0; i < graphFrom.length; i++) {
                
                this.addEdge(graphFrom[i], graphTo[i]);
            }
        }
        
    }
    
    

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
        
        Graph g = new Graph(graphNodes);
        g.addAllEdges(graphFrom, graphTo);
        
        g.printGraph();
        
        int result = 1;
        
        int marked [] = new int [graphNodes];
        
        long color = ids[val-1];
        
        Queue <Integer> queue = new LinkedList <>();
        
        Queue <Integer> nextLevelQ = new LinkedList<>();
        
        queue.add(val);
        
        while (!queue.isEmpty()) {
             
            Integer parent = queue.remove();
            //marked[i] = 1;
            
            for (Integer i : g.adjMap.get(parent)) {
                
                if (marked[i-1] == 0) {
                    nextLevelQ.add(i);
                    
                    if (ids[i-1] == color) {
                        return result;
                    }
                }
            }
            
            if (queue.isEmpty()) {
                result++;
                queue = nextLevelQ;
                nextLevelQ = new LinkedList <>();
            }

            marked[parent-1] = 1;
            
        }
        
        return -1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        
        
        
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);
        
        System.out.println("ANS = " + String.valueOf(ans));

        //bufferedWriter.write(String.valueOf(ans));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
