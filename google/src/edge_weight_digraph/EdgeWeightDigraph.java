package edge_weight_digraph;

import java.util.LinkedList;

import graph_theory.In;

public class EdgeWeightDigraph {
	
	public int V;
	public int E;
	
	public LinkedList <DirectedEdge> [] adj;
	
	public int maxSum = 0;
	
	
	public EdgeWeightDigraph (int v) {
		this.V = v;
		this.adj = (LinkedList <DirectedEdge>[]) new LinkedList [this.V];
		for (int i = 0; i < this.V; i++) {
			this.adj[i] = new LinkedList <DirectedEdge> ();
		}
	}
	
    /**  
     * Initializes an edge-weighted digraph from the specified input stream.
     * The format is the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     * followed by <em>E</em> pairs of vertices and edge weights,
     * with each entry separated by whitespace.
     *
     * @param  in the input stream
     * @throws IllegalArgumentException if the endpoints of any edge are not in prescribed range
     * @throws IllegalArgumentException if the number of vertices or edges is negative
     */
    public EdgeWeightDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            //validateVertex(v);
            //validateVertex(w);
            int weight = in.readInt();
            addEdge(new DirectedEdge(v, w, weight));
        }
    }

	public void addEdge (int v, int w, int weight) {
		
		DirectedEdge edge = new DirectedEdge (v, w, weight);
		this.adj[v].add(edge);
	}
	
	public void addEdge (DirectedEdge edge) {
		this.adj[edge.from].add(edge);
	}
	
	
	
}
