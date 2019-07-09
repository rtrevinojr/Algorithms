package trie;

import java.util.Map;

public class Trie {
	
	
	public TrieNode root;
	
	public TrieNodeOp rootOp;
	
	
	public Trie () {
		
		root = new TrieNode ();
		rootOp = new TrieNodeOp ();
	}

	public void insert (String word) {
		
		TrieNode node = root;
		
		for (int i = 0; i < word.length(); i++) {
			
			Character ch = word.charAt(i);	
			if (node.children.containsKey(ch)) {	
				node = node.children.get(ch);
			}
			else {
				node.children.put(ch, new TrieNode(ch));
				node = node.children.get(ch);
			}
		}
		node.setValidWord();
	}
	
	public void insertOp (String word) {
		
		TrieNodeOp node = rootOp;
		
		for (int i = 0; i < word.length(); i++) {
			
			Character ch = word.charAt(i);
			
			int index = ch - 'a';
			
			if (node.children[index] != null) {
				node = node.children[index];
			}
			else {
				node.children[index] = new TrieNodeOp(ch);
				node = node.children[index];
			}
		}
		node.setValidWord();
		
	}
	
	public boolean find (String word) {
		
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			
			if (node.children.containsKey(word.charAt(i))) {
				node = node.children.get(word.charAt(i));
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public boolean findOp (String word) {
		
		TrieNodeOp node = rootOp;
		
		for (int i = 0; i < word.length(); i++) {
			
			int index = word.charAt(i) - 'a';
			
			if (node.children[index] != null) {
				node = node.children[index];
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public void printDictionary () {
		
		printDictionaryHelper (root, "");
	}
	
	public static void printDictionaryHelper (TrieNode node, String word) {
		
		for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
			
			if (entry.getValue().valid) {
				System.out.println(word + entry.getValue().letter);
				printDictionaryHelper (entry.getValue(), word + entry.getValue().letter);
			}
			else {
				printDictionaryHelper (entry.getValue(), word + entry.getValue().letter);
			}
		}
	}
	
	public void printDictionaryOp () {
		
		printDictionaryHelperOp (rootOp, "");
	}
	
	public static void printDictionaryHelperOp (TrieNodeOp node, String word) {
		
		for (TrieNodeOp n : node.children) {
			
			if (n != null) {
			
				if (n.valid) {
					System.out.println(word + n.letter);
					printDictionaryHelperOp(n, word + n.letter);
				}
				else {
					printDictionaryHelperOp(n, word + n.letter);
				}
			
			}
		}
	}
	
	
	public static boolean wordBreak (TrieNodeOp root, String input) {
		
		boolean [] valid = new boolean [input.length() + 1];
		valid[0] = true;
		
		for (int i = 0; i < input.length(); i++) {
			
			if (!valid[i]) continue;
			
			TrieNodeOp node = root;
			
			for (int j = i; j < input.length(); j++) {
				
				if (node == null) break;
				
				node = node.children[input.charAt(j) - 'a'];
				
				if (node != null && node.valid) {
					valid[j + 1] = true;
				}
			}
		}
		return valid[input.length()];
	}
	
	public static void main (String [] args) {
		
		System.out.println("main...");
		System.out.println();
		
		Trie trieOp = new Trie();
		
		trieOp.insertOp("enter");
		trieOp.insertOp("entered");
		trieOp.insertOp("entry");
		
		trieOp.insertOp("bath");
		trieOp.insertOp("bat");
		trieOp.insertOp("and");
		trieOp.insertOp("hand");
		
		trieOp.printDictionaryOp();
		
		System.out.println("********************************************************************");
		
		
		TrieNodeOp node = trieOp.rootOp;
		
		boolean result = wordBreak(node, "bathand");
		
		
		
		System.out.println("Result = " + result	);
		
		System.out.println();
		
		System.out.println("enter is found - " + trieOp.findOp("enter"));
		System.out.println("entered is found - " + trieOp.findOp("entered"));
		System.out.println("entry is found - " + trieOp.findOp("entry"));
		System.out.println("entertainment is found - " + trieOp.findOp("entertainment"));
		System.out.println();
		
		System.out.println();
		
		Trie trie = new Trie();
		
		trie.insert("word");
		trie.insert("i");
		trie.insert("iterator");
		trie.insert("state");
		trie.insert("states");
		trie.insert("stated");
		
		
		System.out.println("word is found - " + trie.find("word"));
		System.out.println("is is found - " + trie.find("is"));
		System.out.println("stated is found - " + trie.find("stated"));
		System.out.println("statement is found - " + trie.find("statement"));
		System.out.println();
		
		
		trie.printDictionary();
		
		
		
	}
	
}
