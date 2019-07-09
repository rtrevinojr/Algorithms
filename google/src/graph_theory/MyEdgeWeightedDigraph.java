package graph_theory;

public class MyEdgeWeightedDigraph {
	
	private final int V;
	private int E;
	private Bag<MyDirectedEdge>[] adjList;
	private int indegree [];
	private int [] outdegree;
	
	
	public MyEdgeWeightedDigraph (int V) {
		this.V = V;
		this.E = 0;
		adjList = (Bag<MyDirectedEdge> []) new Bag[V];
		for (int v = 0; v < V; v++) 
			adjList[v] = new Bag<MyDirectedEdge>();
		indegree = new int[V];
		outdegree = new int[V];
	}
	
	private void validateVertex(int v) {
		if (v < 0 || v >= V) 
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}
	
	public void addEdge (MyDirectedEdge edge) {
		int v = edge.from();
		int w = edge.to();
		validateVertex(v);
		validateVertex(w);
		adjList[v].add(edge);
		indegree[w]++;
		E++;	
	}
	
	public Iterable <MyDirectedEdge> getAdjacentVertices (int v) {
		validateVertex(v);
		return adjList[v];
	}
	
	
	

}
