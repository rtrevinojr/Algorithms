
package graph_theory;

/**
 *  The {@code DepthFirstOrder} class represents a data type for 
 *  determining depth-first search ordering of the vertices in a digraph
 *  or edge-weighted digraph, including preorder, postorder, and reverse postorder.
 *  <p>
 *  This implementation uses depth-first search.
 *  The constructor takes time proportional to <em>V</em> + <em>E</em>
 *  (in the worst case),
 *  where <em>V</em> is the number of vertices and <em>E</em> is the number of edges.
 *  Afterwards, the <em>preorder</em>, <em>postorder</em>, and <em>reverse postorder</em>
 *  operation takes take time proportional to <em>V</em>.
 *  <p>
 *  For additional documentation,
 *  see <a href="http://algs4.cs.princeton.edu/42digraph">Section 4.2</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 */

public class DepthFirstOrder {
	
	private boolean marked [];
	private int pre [];
	private int post [];
	private int in [];
	
	private Queue <Integer> preorder;
	private Queue <Integer> postorder;
	private Queue <Integer> inorder;
	
	private int preCounter;
	private int postCounter;
	private int inCounter;
	
	
	public DepthFirstOrder (MyDigraph G) {
		
		marked = new boolean[G.V()];
		pre = new int [G.V()];
		post = new int [G.V()];
		
		preorder = new Queue<>();
		postorder = new Queue<>();
		
		for (int i = 0; i < G.V(); i++) {
			if (!marked[i])
				dfs(G, i);
		}
	}
	
	private void dfs (MyDigraph G, int v) {
		
		marked[v] = true;
		
		pre[v] = preCounter++;
		
		preorder.enqueue(v);
		
		for (int w: G.getAdjacentVertices(v)) {
			
			//inorder.enqueue(w);
			//in[w] = inCounter++;
			
			if (!marked[w])
				dfs(G, w);
		}
		
		postorder.enqueue(v);
		post[v] = postCounter++;
	}
	
	private Iterable <Integer> pre() {
		return preorder;
	}
	
	private Iterable <Integer> post() {
		return postorder;
	}
	
	private int pre(int v) {
		return pre[v];
	}
	private int post(int v) {
		return post[v];
	}
	
	private Iterable <Integer> reversePost () {
		Stack <Integer> result = new Stack<> ();
		for (int w: postorder) 
			result.push(w);
		return result;
	}
	
	
	/**
     * Unit tests the {@code DepthFirstOrder} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        //In in = new In(args[0]);
        MyDigraph G = new MyDigraph(10);
        G.addEdge(5, 3);
        G.addEdge(5, 8);
        G.addEdge(3, 2);
        G.addEdge(3, 4);
        G.addEdge(2, 1);
        
        G.addEdge(8, 6);
        G.addEdge(8, 9);
        G.addEdge(6, 7);
        
        G.addEdge(7, 8);
        
        MyDirectedCycle finder = new MyDirectedCycle(G);
        
        System.out.println("Graph G cycle present = " + finder.findCycle(G));

        DepthFirstOrder dfs = new DepthFirstOrder(G);
        StdOut.println("   v  pre post");
        StdOut.println("--------------");
        for (int v = 0; v < G.V(); v++) {
            StdOut.printf("%4d %4d %4d\n", v, dfs.pre(v), dfs.post(v));
        }

        StdOut.print("Preorder:  ");
        for (int v : dfs.pre()) {
            StdOut.print(v + " ");
        }
        StdOut.println();

        StdOut.print("Postorder: ");
        for (int v : dfs.post()) {
            StdOut.print(v + " ");
        }
        StdOut.println();

        StdOut.print("Reverse postorder: ");
        for (int v : dfs.reversePost()) {
            StdOut.print(v + " ");
        }
        StdOut.println();


    }

}
