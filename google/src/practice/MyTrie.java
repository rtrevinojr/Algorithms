package practice;

public class MyTrie {

	
	public static class Node {
		
		public Character letter;
		public Node [] children;
		public boolean valid;
		
		public Node () {
			letter = null;
			children = new Node [26];
			valid = false;
		}
		
		public Node (Character ch) {
			letter = ch;
			children = new Node [26];
			valid = false;
		}
		public Node (Character ch, boolean valid) {
			this.letter = ch;
			this.children = new Node [26];
			this.valid = true;
		}
		
	}
	
	public Node root;
	
	public MyTrie () {
		root = new Node ();
	}
	
	public void insert (String word) {

		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			int index = letter - 'a';
			if (node.children[index] == null) {
				if (i == word.length() - 1) {
					node.children[index] = new Node(letter, true);
				}
				else {
					node.children[index] = new Node(letter);
				}
			}
			else if (i == word.length() - 1) {
				node.children[index].valid = true;
			}
			node = node.children[index];
		}
	}

	
	public boolean isWord (String word) {
		
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			int index = letter - 'a';
			if (node.children[index] == null) {
				return false;
			}
			else if (i == word.length() - 1 && node.children[index].valid) {
				return true;
			}
			else {
				node = node.children[index];
			}
		}
		return false;
	}
	
	
	
	public void printDict () {
		printDict(root, "");
	}
	
	public void printDict(Node node, String word) {
		

		
		for (int i = 0; i < 26; i++) {
			Node n = node.children[i];
			if (n != null) {
				if (n.valid) {
					System.out.println(word);
					
				}
				printDict(n, word + n.letter);
			}
		}
		
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("MyTrie.java");
		
		MyTrie trie = new MyTrie();
		trie.insert("states");
		trie.insert("state");
		trie.insert("statement");
		
		boolean hasWord = trie.isWord("state");
		
		System.out.println("Has word state = " + hasWord);
		
		trie.printDict();
		
		
	}
}
