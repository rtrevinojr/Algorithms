package graph_theory;

import java.util.NoSuchElementException;


public class MyDigraph {
	
	private final int V;
	private int E;
	private Bag<Integer> [] adjList;
	private int [] indegree;
	
	private static final String NEWLINE = System.getProperty("line.separator");
	
	public MyDigraph (int V) {
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;
		adjList = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adjList[v] = new Bag<Integer>();
		indegree = new int[V];
	}
	
	/**  
     * Initializes a digraph from the specified input stream.
     * The format is the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     * followed by <em>E</em> pairs of vertices, with each entry separated by whitespace.
     *
     * @param  in the input stream
     * @throws IllegalArgumentException if the endpoints of any edge are not in prescribed range
     * @throws IllegalArgumentException if the number of vertices or edges is negative
     * @throws IllegalArgumentException if the input stream is in the wrong format
     */
    public MyDigraph(In in) {
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Digraph must be nonnegative");
            indegree = new int[V];
            adjList = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adjList[v] = new Bag<Integer>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Digraph must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                addEdge(v, w); 
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Digraph constructor", e);
        }
    }
	
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	
	private void validateVertex (int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}
	
	public void addEdge (int v, int w) {
		validateVertex(v);
		validateVertex(w);
		adjList[v].add(w);
		indegree[w]++;
		E++;
	}
	
	public Iterable <Integer> getAdjacentVertices(int v) {
		validateVertex(v);
		return adjList[v];
	}
	
	public int outdegree (int v) {
		validateVertex(v);
		return adjList[v].size();
	}
	
	public int indegree (int v) {
		validateVertex(v);
		return indegree[v];
	}
	
	/**
     * Returns a string representation of the graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,  
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adjList[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    
    public static void main (String [] args) {
		System.out.println(" ----- MyDigraph.java ----- ");
		
		MyDigraph graph = new MyDigraph (9);
		graph.addEdge(1, 2);
		graph.addEdge(2, 7);
		graph.addEdge(2, 6);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(5, 8);
		
		System.out.println(graph.toString());
		
		System.out.println ("E = " );
		for (Integer i: graph.getAdjacentVertices(3)) {
			System.out.println(i);
		}
		
		
		//dfs(graph, 1);
	}

}
