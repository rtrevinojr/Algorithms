package edge_weight_digraph;

import graph_theory.In;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WeightDigraphMaxSum {
	
	
	public Set <Integer> hashSet;
	
	public int totalSum = 0;
	
	public int maxSum = Integer.MIN_VALUE;
	
	public int [] bigPath;
	
	public int minPathLen = 0;
	
	public WeightDigraphMaxSum (EdgeWeightDigraph G) {
		hashSet = new HashSet <Integer> ();
		bigPath = new int [G.V];
	}
	
	
	public void dfs (EdgeWeightDigraph G, int v) {
		
		System.out.print(v + " ");
		hashSet.add(v);
		for (DirectedEdge i : G.adj[v]) {
			int to = i.to;
			if (!hashSet.contains(to)) {
				dfs (G, to);
			}
		}
	}
	
	public void bfs (EdgeWeightDigraph G, int v) {
		
		Queue <Integer> queue = new LinkedList <>();
		queue.add(v);
		
		while (!queue.isEmpty()) {
			
			int i = queue.remove();
			System.out.print(i + " ");
			for (DirectedEdge edge : G.adj[i]) {
				int to = edge.to;
				if (!hashSet.contains(to))
					queue.add(to);
			}
		}
		
	}
	
	public int totalSum (EdgeWeightDigraph G, int root) {
		
		hashSet.add(root);
		
		for (DirectedEdge edge : G.adj[root]) {
			
			int to = edge.to;
			if (!hashSet.contains(to)) {
				return edge.weight + totalSum (G, to);
			}
		}
		return 0;
	}
	
	public int totalSumOp (EdgeWeightDigraph G, int root) {
		
		totalSumHelper (G, root, 0);
		return this.totalSum;
	}
	
	public void totalSumHelper (EdgeWeightDigraph G, int root, int sum) {
		
		hashSet.add(root);
		
		for (DirectedEdge edge : G.adj[root]) {
			
			if (!hashSet.contains(edge.to)) {
				
				System.out.println(edge.to);
				
				totalSum += edge.weight;
				totalSumHelper (G, edge.to, sum);
			}
		}
		
	}
	
	
	public int maxSum (EdgeWeightDigraph G, int root) {
		
		int [] paths = new int [G.V];
		
		maxSumHelper (G, root, paths, 0, 0);
		
		System.out.println("MAX Sum Path = " + this.bigPath.toString());
		
		return maxSum;
	}
	
	public void maxSumHelper (EdgeWeightDigraph G, int root, int [] path, int pathLen, int sum) {
		
		hashSet.add(root);
		
		
		
		if (G.adj[root].size() == 0) {
			
			if (sum > maxSum) {
				maxSum = sum;
				bigPath = new int [G.V];
//				for (int i = 0; i < pathLen; i++) {
//					bigPath.add(path[i]);
//				}
			}
			else {
				path = new int [G.V];
				pathLen = 0;
				sum = 0;
			}
		}	
		
		for (DirectedEdge edge : G.adj[root]) {
			if (!hashSet.contains(edge.to)) {
				
				path[pathLen] = edge.to;
				pathLen++;
				sum += edge.weight;
				
				maxSumHelper (G, edge.to, path, pathLen, sum);
			}
		}
	}
	
	
	
	
	public void printAllPaths (EdgeWeightDigraph G, int root) {
		
		int [] paths = new int [G.V];
		printAllPathsHelper (G, 0, paths, 0);
	}
	
	public void printAllPathsHelper (EdgeWeightDigraph G, int root, int [] path, int pathLen) {
		
		
		path[pathLen] = root;
		pathLen++;
		
		if (G.adj[root].size() == 0) {	
			printArray(path, pathLen);
		}
		
		for (DirectedEdge edge : G.adj[root]) {

			printAllPathsHelper (G, edge.to, path, pathLen);
		}
		
	}
	
	public int getMaxSumPathOp (EdgeWeightDigraph G, int root) {
		
		DirectedEdge rootEdge = G.adj[root].get(0);
		
		System.out.println("Root edge = " + rootEdge.weight);
		
		int [] paths = new int [G.V];
		
		getMaxSumPathHelperOp (G, rootEdge, paths, 0, Integer.MIN_VALUE);
		return maxSum;
		
	}
	
	public void getMaxSumPathHelperOp (EdgeWeightDigraph G, DirectedEdge rootEdge, int [] path, int pathLen, Integer sum) {
		
		path[pathLen] = rootEdge.from;
		pathLen++;

		
//		if (sum == null) {
//			if (rootEdge.weight < 0) 
//				sum = Integer.MIN_VALUE;
//			else 
//				sum = Integer.MIN_VALUE;
//			
//		}
//		else {
		if (rootEdge.weight < 0) {
			if (rootEdge.weight < sum) {
				path = new int [G.V];
				pathLen = 0;
				path[pathLen] = rootEdge.from;
				pathLen++;
				//sum = Integer.MIN_VALUE;
			}
			else {
				path = new int [G.V];
				pathLen = 0;
				path[pathLen] = rootEdge.from;
				pathLen++;
				path[pathLen] = rootEdge.to;
				pathLen++;
				sum = rootEdge.weight;
			}
		}
		else {
			sum += rootEdge.weight;
		}
		//}
		

		if (sum > maxSum) {
			
			maxSum = sum;
			minPathLen = pathLen;
			bigPath = Arrays.copyOf(path, pathLen);
			System.out.println("Ne max sum = " + maxSum);
			System.out.println("Sum = " + sum);
			printArray(path, pathLen);
		}
		else if (sum == maxSum) {
			if (pathLen < minPathLen) {
				minPathLen = pathLen;
				bigPath = Arrays.copyOf(path, pathLen);
			}
		}
		
		if (G.adj[rootEdge.from].size() == 0) {
			System.out.println("New path sum = " + sum);
			printArray(path, pathLen);
		}
		
		for (DirectedEdge edge : G.adj[rootEdge.to]) {
			//getMaxSumPathHelperOp (G, edge.to, path, pathLen, sum, edge.weight);
			getMaxSumPathHelperOp (G, edge, path, pathLen, sum);
		}
		
	}
	
	/*
	public int getMaxSumPath (EdgeWeightDigraph G, int root) {
		
		getMaxSumPathHelper (G, root, new int [G.V], 0, 0, 0);
		return maxSum;
	}
	
	public void getMaxSumPathHelper (EdgeWeightDigraph G, int root, int [] path, int pathLen, Integer sum, int weight) {
		
		path[pathLen] = root;
		pathLen++;

		if (sum != null) {
		
		if (weight < 0) {
			if (weight < sum) {
				path = new int [G.V];
				pathLen = 0;
				path[pathLen] = root;
				pathLen++;
				sum = 0;
			}
			else {
				int last = path[pathLen - 2];
				path = new int [G.V];
				pathLen = 0;
				path[pathLen] = last;
				pathLen++;
				path[pathLen] = root;
				pathLen++;
				sum = weight;
			}
		}
		else {
			sum += weight;
		}

		if (sum > maxSum) {
			maxSum = sum;
			minPathLen = pathLen;
			bigPath = Arrays.copyOf(path, pathLen);
			System.out.println("New max sum = " + maxSum);
			printArray(path, pathLen);
		}
		else if (sum == maxSum) {
			if (pathLen < minPathLen) {
				minPathLen = pathLen;
				bigPath = Arrays.copyOf(path, pathLen);
			}
		}
		
		}
		
		if (G.adj[root].size() == 0) {
			//System.out.println("New path sum = " + sum);
			//printArray(path, pathLen);
		}
		
		for (DirectedEdge edge : G.adj[root]) {
			
			getMaxSumPathHelper (G, edge.to, path, pathLen, sum, edge.weight);

		}
		
	}
	*/
	
	/* Utility function that prints out an array on a line. */
	public void printArray(int ints[], int len) { 
		for (int i = 0; i < len; i++) { 
			System.out.print(ints[i] + " "); 
		} 
	    System.out.println(""); 
	} 
	
	public static void main (String [] args) {
		
		System.out.println("WeightDigraphMaxSum");
		
		In in = new In("negative_graph.txt");
        EdgeWeightDigraph G = new EdgeWeightDigraph(in);
        
        WeightDigraphMaxSum tree = new WeightDigraphMaxSum (G);
        
        //tree.bfs(G, 0);
        
        //int totalSum = tree.totalSumOp(G, 0);
        //System.out.println("Total sum = " + totalSum);
        
        //int maxSum = tree.maxSum(G, 0);
        
        //System.out.println("Max Sum Path = " + maxSum);
        
        //tree.printAllPaths(G, 0);
		
        int max = tree.getMaxSumPathOp(G, 0);
        
        System.out.println("max = " + max);
        System.out.println();
        
        System.out.println("Result path: ");
        System.out.println("Min path length = " + tree.minPathLen);
        
        tree.printArray(tree.bigPath, tree.minPathLen);
        
        System.out.println();
        
        
	}

}
