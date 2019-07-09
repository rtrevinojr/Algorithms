package graph_theory;


public class MyGraph {
	
	private Bag<Integer> [] adjList;
	private final int V;
	private int E;
	
	private static boolean [] marked;
	
	private static final String NEWLINE = System.getProperty("line.separator");

	public MyGraph (int V) {
		this.V = V;
		this.E = 0;
		adjList = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adjList[v] = new Bag<Integer> ();
		}
		
		marked = new boolean [V];
	}
	
	public void validateVertex (int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException ("Vertex " + v + " is not between 0 and " + (V - 1));
	}
	
	public void addEdge (int v, int w) {
		validateVertex(v);
		validateVertex(w);
		E++;
		adjList[v].add(w);
		adjList[w].add(v);
	}
	
	public Iterable<Integer> getAdjacentVertices(int v) {
		validateVertex(v);
		return adjList[v];
	}
	
	public int degree(int v) {
		return adjList[v].size();
	}
	
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adjList[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
	
	public static void dfs (MyGraph G, int v) {
		//System.out.println(v);
		
		marked[v] = true;
		
		for (int w: G.getAdjacentVertices(v)) {
			if (!marked[w]) {
				dfs(G, w);
				System.out.println(w);
			}
		}
	}
	
	public static void main (String [] args) {
		System.out.println(" ----- MyGraph.java ----- ");
		
		MyGraph graph = new MyGraph (9);
		graph.addEdge(1, 2);
		graph.addEdge(2, 7);
		graph.addEdge(2, 6);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		//graph.addEdge(5, 8);
		
		System.out.println(graph.toString());
		
		System.out.println ("E = " );
//		for (Integer i: graph.getAdjacentVertices(3)) {
//			System.out.println(i);
//		}
		
		
		dfs(graph, 1);
	}

}