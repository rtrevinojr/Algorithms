package google;

import graph_theory.In;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class UndirectedGraph {
	
	public int V;
	public int E;
	public LinkedList <Integer> [] adjacent;
	
	
	public UndirectedGraph (int v) {
		this.V = v;
		this.E = 0;
		adjacent = (LinkedList <Integer>[]) new LinkedList [V];
		for (int i = 0; i < V; i++) {
			adjacent[i] = new LinkedList <Integer> ();
		}
	}

	public void addEdge (int v, int w) {
		this.adjacent[v].add(w);
		this.adjacent[w].add(v);
		this.E++;
	}
	
	public UndirectedGraph(In in) {
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            adjacent = (LinkedList<Integer>[]) new LinkedList[V];
            for (int v = 0; v < V; v++) {
                adjacent[v] = new LinkedList<Integer>();
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
	
	
}
