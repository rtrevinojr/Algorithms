package socialnetwork;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;


public class BFSData {

	
	public Queue <PathNode> toVisit = new LinkedList <>();
	public HashMap <Integer, PathNode> visited = new HashMap<> ();
	
	
	public BFSData (Person root) {
		
		PathNode sourcePath = new PathNode (root, null);
		toVisit.add(sourcePath);
		visited.put(root.getId(), sourcePath);
	}
	
	public boolean isFinished () {
		return toVisit.isEmpty();
	}
}
