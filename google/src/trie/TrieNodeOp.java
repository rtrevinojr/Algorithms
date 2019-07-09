package trie;

public class TrieNodeOp {
	
	Character letter;
	
	TrieNodeOp [] children;
	
	boolean valid;
	
	
	public TrieNodeOp () {
		
		letter = null;
		children = new TrieNodeOp [26];
		valid = false;
	}

	public TrieNodeOp (Character ch) {
		letter = ch;
		children = new TrieNodeOp [26];
		valid = false;
	}
	
	public void setValidWord () {
		valid = true;
	}
	
	
}
