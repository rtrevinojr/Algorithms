
import java.util.*;


public class WordLadder {

	public Integer minHeight = Integer.MAX_VALUE;
	
	public static class WordNode {
		
		public String word;
		public int numSteps;
		
		public WordNode (String word, int numSteps) {
			this.word = word;
			this.numSteps = numSteps;
		}
	}
	
	public int ladderLenBFS (String begin, String end, Set <String> dict) {
		
		dict.add(end);
		
		Queue <WordNode> queue = new LinkedList <> ();
		queue.add(new WordNode (begin, 0));
		
		while (!queue.isEmpty()) {
			
			WordNode node = queue.remove();
			
			if (node.word.equals(end)) {
				return node.numSteps;
			}
			
			for (int i = 0; i < begin.length(); i++) {
				
			
				for (char c = 'a'; c <= 'z'; c++) {
					
					String word = node.word;
					int height = node.numSteps;
					char [] wordArr = word.toCharArray();
					wordArr[i] = c;
					String wordL = String.valueOf(wordArr);
					//if (wordL.equals("hot")) System.out.println("hot");
					//if (dict.contains(wordL)) System.out.println(wordL);
					if (dict.contains(wordL)) {
						queue.add(new WordNode(wordL, ++height));
						System.out.println(wordL + " " + height);
					}
				}
			}
		}
		
		return 0;
	}
	
	
	
	public int ladderLength (String begin, String end, Set <String> dict) {
		
		char [] beginCh = begin.toCharArray();
		
		//dict.add("hit");
		dict.add("hot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("cog");
		
		ladderLengthHelper (beginCh, end, dict, 0);
		
		if (minHeight == Integer.MAX_VALUE) {
			
			System.out.println("max");
			return 0;
		}
		else {
			return minHeight;
		}
	}
	
	public void ladderLengthHelper (char [] begin, String end, Set <String> dict, int height) {
		
		if (begin.toString().equals(end)) {
			if (height < minHeight) 
				minHeight = height;
		}
		else {
			for (int i = 0; i < begin.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					begin[i] = c;
					String beginStr = String.valueOf(begin);
					//System.out.println(beginStr);
					if (beginStr.equals("hot")) {
						System.out.println(beginStr);
					}
					if (dict.contains(beginStr)) {
						System.out.println(begin.toString());
						ladderLengthHelper (begin, end, dict, height);
					}
				}
			}
		}
	}
	
	public static void main (String [] args) {
		
		System.out.println("WordLadder.java");
		
		WordLadder wordLadder = new WordLadder ();
		
		String start = "hit";
		String end = "cog";
		
		Set <String> set = new HashSet <String> ();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		
		//int result = wordLadder.ladderLength(start, end, set);
		
		int result = wordLadder.ladderLenBFS(start, end, set);
		
		System.out.println("Result = " + result);
		
		
	}
}
