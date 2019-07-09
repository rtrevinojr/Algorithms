package graph_theory;

public class MyDirectedEdge {
	
	private final int v;
	private final int w;
	private final double weight;
	
	
	public MyDirectedEdge (int v, int w, int weight) {
		if (v < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
		if (w < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
		if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int from() {
		return v;
	}
	
	public int to() {
		return w;
	}
	
	public double weight () {
		return weight;
	}
	
	public String toString() {
        return v + "->" + w + " " + String.format("%5.2f", weight);
    }

}
