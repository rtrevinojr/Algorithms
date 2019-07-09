package Microsoft;

public class DigraphMat {

	public int V;
	public int E;
	public boolean [][] adjacentMatrix;
	
	
	public DigraphMat (int v) {
		V = v;
		E = 0;
		adjacentMatrix = new boolean [V][V];
	}
	
	
	public void addEdge (int v, int w) {
		
		//validateVertex
		
		adjacentMatrix[v][w] = true;
	}
	
}
