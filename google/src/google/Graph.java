package google;

import graph_theory.In;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Graph {

	public int V;
	public int E;
	public LinkedList <Integer> [] adj;
	
	public Graph (int v) {
		this.V = v;
		this.adj = (LinkedList <Integer>[]) new LinkedList [v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList <Integer> ();
		}
	}
	
	public Graph(In in) {
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            adj = (LinkedList<Integer>[]) new LinkedList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new LinkedList<Integer>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                //validateVertex(v);
                //validateVertex(w);
                addEdge(v, w); 
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }
	
	public void addEdge (int v, int w) {
		
		this.adj[v].add(w);
		this.adj[w].add(v);
		this.E++;
	}
	
	
}