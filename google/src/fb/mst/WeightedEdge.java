package fb.mst;


public class WeightedEdge implements Comparable <WeightedEdge> {

	private final int u;
	private final int v;
	private final double weight;
	
	
	public WeightedEdge (int u, int v, int weight) {
		if (u < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (v < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
	
	public int either () {
		return this.u;
	}
	
	public int other (int vertex) {
		if (vertex == this.u) 
			return v;
		else if (vertex == this.v)
			return u;
		else 
			throw new IllegalArgumentException ("Illegal Exception");
	}
	
	public int compareTo (WeightedEdge other) {
		
		return Double.compare(this.weight, other.weight);
	}
	
	
	public static void main (String [] args) {
		
		
	}
	
}
