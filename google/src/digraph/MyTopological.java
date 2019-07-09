package digraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import graph_theory.In;
import graph_theory.StdOut;

public class MyTopological {
	
	public Digraph G;
	
	public boolean isCycle;
	
	public boolean [] marked;
	public boolean [] onStack;
	
	public List <Integer> post;
	
	public List <Integer> topologicalSort;
	
	public int [] rank;
	public int [] edgeTo;
	
	public List <Integer> cycle;
	
	
	public MyTopological (Digraph g) {
		
		this.G = g;
		this.isCycle = false;
		this.marked = new boolean [G.V()];
		this.onStack = new boolean [G.V()];
		
		this.edgeTo = new int [G.V()];
		this.cycle = new LinkedList <>();
		
		this.post = new ArrayList<>();
		this.topologicalSort = new ArrayList <>();
	}
	
	public MyTopological (In in) {
		
		this.G = new Digraph(in);
		this.marked = new boolean [G.V()];
		this.onStack = new boolean [G.V()];
	}
	
	
	public boolean hasCycle () {
		
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				hasCycleHelper(v);
			}
		}
		//hasCycleHelper (0);
		return this.isCycle;
	}
	
	public void hasCycleHelper (int v) {
		
		marked[v] = true;
		onStack[v] = true;
		
		for (int w: G.adj(v)) {
			
			if (!marked[w]) {
				edgeTo[w] = v;
				hasCycleHelper (w);
			}
			else if (onStack[w]) {
				this.isCycle = true;
				
				for (int i = v; i != w; i = edgeTo[i]) {
					this.cycle.add(i);
				}
				this.cycle.add(w);
				this.cycle.add(v);
			}
		}
		onStack[v] = false;

		
	}
	
	public List <Integer> dfsSortTop () {
		
		if (hasCycle()) {
			return null;
		}
		
		this.marked = new boolean [G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) 
			dfsSortTop(v);
		}
		
		Collections.reverse(this.post);
		return this.post;
	}
	
	public void dfsSortTop (int v) {
		
		for (int w: this.G.adj(v)) {
			if (!marked[w]) {
				marked[w] = true;
				dfsSortTop (w);	
			}
		}
		//if (!marked[v])
			post.add(v);
	}
	
	public void itSortTop () {
		
		Queue <Integer> queue = new LinkedList <> ();
		
		int count = 0;
		
		for (int v = 0; v < this.G.V(); v++) {
			
			if (this.G.indegree[v] == 0) {
				queue.add(v);
			}
		}
		
		while (!queue.isEmpty()) {
			
			Integer i = queue.remove();
			topologicalSort.add(i);
			count++;
			
			for (int v : this.G.adj(i)) { 
				
				this.G.indegree[v]--;
				
				if (this.G.indegree[v] == 0) 
					queue.add(v);
				
			}
			
		}
		
		System.out.println("count = " + count);
		System.out.println(this.topologicalSort.toString());
		
		if (count != this.G.V()) {
			this.topologicalSort = null;
		}
		
		
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("MyTopological.java");
		
		
		In in = new In(args[0]);
        Digraph G = new Digraph(in);
        
        StdOut.println(G);
        
        MyTopological topological = new MyTopological (G);
        
        boolean hasCycle = topological.hasCycle();
        
        StdOut.println(hasCycle);
        if (hasCycle)
        	System.out.println("Cycle = " + topological.cycle.toString());
        else 
        	System.out.println("Cycle does NOT exist ");
        
        List <Integer> topologicalSort = topological.dfsSortTop();
        
        if (topologicalSort != null)
        	System.out.println(topologicalSort.toString());
        else 
        	System.out.println("TopologicalSort is NULL");
        
        System.out.println();
        
        In in2 = new In(args[0]);
        Digraph G2 = new Digraph(in2);
        
        DepthFirstOrder dfOrder = new DepthFirstOrder (G2);
        
        System.out.println("Test...");
        
        List <Integer> result = new ArrayList<Integer>(makeCollection(dfOrder.post()));
        Collections.reverse(result);
        
        System.out.println(result);
        
        System.out.println();
        
        In in3 = new In (args[0]);
        Digraph G3 = new Digraph(in3);
        
        MyTopological topo3 = new MyTopological (G3);
        
        topo3.itSortTop();
        
        System.out.println("Sorting iteratively...");
        
        if (topo3.topologicalSort != null)
        	System.out.println(topo3.topologicalSort.toString());
        else 
        	System.out.println("topological sort is null");
		
	}
	
	public static <E> Collection<E> makeCollection(Iterable<E> iter) {
	    Collection<E> list = new ArrayList<E>();
	    for (E item : iter) {
	        list.add(item);
	    }
	    return list;
	}

}
