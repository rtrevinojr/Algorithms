package google;
import graph_theory.*;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class CC {
	

	public int [] id;
	public int [] size;
	public boolean [] marked;
	public int count;
	
	public CC (Graph G) {
		this.id = new int [G.V];
		this.size = new int [G.V];
		this.marked = new boolean [G.V];
		this.count = 0;
		
		for (int i = 0; i < G.V; i++) {
			if (!marked[i]) {
				dfs (G, i);
				this.count++;
			}
		}
	}
	
	public void dfs (Graph G, int v) {
		
		marked[v] = true;
		id[v] = count;
		size[id[v]]++;
		for (int w: G.adj[v]) {
			if (!marked[w])
				dfs(G, w);
		}
	}

	
	
	
	public static void main (String [] args) {
		
		System.out.println("ConnectedComponents.java");
		
		In in = new In("tinyDG.txt");
        Graph G = new Graph(in);
        CC cc = new CC(G);
        
        System.out.println("Connected Components = " + cc.count);
        
        LinkedList <Integer> connectedLst [] = new LinkedList [cc.count];
        
        for (int i = 0; i < cc.count; i++) {
        	connectedLst [i] = new LinkedList <Integer> ();
        }
        
        for (int i = 0; i < G.V; i++) {
        	
        	int group = cc.id[i];
        	
        	connectedLst[group].add(i);
        	
        }
        
        for (int i = 0; i < cc.count; i++) {
        	
        	System.out.print("Group " + i + ": " );
        	for (int n : connectedLst[i]) {
        		System.out.print(n + " - ");
        	}
        	System.out.println();
        }
        System.out.println();
        
	}
}
