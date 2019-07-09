package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	
	Character letter;
	
	Map <Character, TrieNode> children;
	
	boolean valid;
	
	public TrieNode () {
		letter = null;
		children = new HashMap <Character, TrieNode> ();
		valid = false;
	}
	
	public TrieNode (Character ch) {
		letter = ch;
		children = new HashMap <Character, TrieNode> ();
		valid = false;
	}
	
	public void setValidWord () {
		valid = true;
	}

}
