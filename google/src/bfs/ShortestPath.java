package bfs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ShortestPath {

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
        
        int result = 0;
        
        int marked [] = new int [graphNodes];
        
        long color = ids[val-1];
        
        Queue <Integer> queue = new LinkedList <>();
        queue.add(val);
        
        while (!queue.isEmpty()) {
             
            Integer parent = queue.remove();
            //marked[i] = 1;
            
            for (int i = 0; i < graphFrom.length; i++) {
                
                if (graphTo[i] == parent && marked[parent-1] == 0) {
                    Integer to = graphTo[i];
                    if (ids[to] == ids[i]) {
                        return result;
                    }
                }
            }
            
            // for (Integer from : graphFrom) {
            //     if (from == i && marked[from] == 0) {
            //         Integer to = graphTo[from];
            //         //marked[] = 1;
            //         queue.add(to);
            //         if (ids[to] == ids[from]) {
            //             return result;
            //         }
            //     }
            // }
            
            marked[parent-1] = 1;
            //result++;
            
        }
        
        return -1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

