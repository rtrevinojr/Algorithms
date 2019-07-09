package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	
	public static String [] Dictionary = {"take", "bath", "and", "come", "bat", "hand", "fan"};
	
	public String [] sentenceResult = new String [100];
	public int sentenceCount = 0;
	
	public ArrayList <String> sentenceResultList = new ArrayList <>();
	
	
	public boolean wordBreak (String input, Set <String> dict) {
		
		String [] sentence = new String [100];
		
		ArrayList <String> sentenceList = new ArrayList <>();
		
		//return wordBreakHelperOp (input, dict, 0, sentence, 0);
		
		//return wordBreakHelper (input, dict, 0);
		
		return wordBreakHelperOp2 (input, dict, 0, sentenceList);
		
	}
	
	public boolean wordBreakHelper (String input, Set <String> dict, int len) {
		
		if (len == input.length()) {
			return true;
		}
		
		for (String word : dict) {
			int wordLen = word.length();
			int end = len + wordLen;
			
			if (end > input.length()) continue;
			
			if (input.substring(len, end).equalsIgnoreCase(word)) {
				if (wordBreakHelper (input, dict, len + wordLen)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean wordBreakHelperOp (String input, Set <String> dict, int len, String [] sentence, int wordCnt) {
		
		if (len == input.length()) {
			sentenceResult = sentence;
			sentenceCount = wordCnt;
			return true;
		}
		
		for (String word : dict) {
			int wordLen = word.length();
			int end = len + wordLen;
			
			if (end > input.length()) continue;
			
			if (input.substring(len, end).equalsIgnoreCase(word)) {
				sentence[wordCnt] = word;
				wordCnt++;
				if (wordBreakHelperOp (input, dict, len + wordLen, sentence, wordCnt)) {
					return true;
				}
			}
		}
		
		return false;
	}
	/**
	 * 
	 * Runtime Complexity - O(n*d) 
	 * where n = no. of words in sentence
	 */
	public boolean wordBreakHelperOp2 (String input, Set <String> dict, int len, ArrayList <String> sentence) {
		
		if (len == input.length()) {
			//sentenceResult = sentence;
			//sentenceCount = wordCnt;
			sentenceResultList = sentence;
			return true;
		}
		
		for (String word : dict) {
			int wordLen = word.length();
			int end = len + wordLen;
			
			if (end > input.length()) continue;
			
			if (input.substring(len, end).equalsIgnoreCase(word)) {
				//sentence[wordCnt] = word;
				//wordCnt++;
				sentence.add(word);
				if (wordBreakHelperOp2 (input, dict, len + wordLen, sentence)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void printArray (String [] array, int count) {
		
		//for (String i : array) System.out.print(i + " ");
		for (int i = 0; i < count; i++) System.out.print(array[i] + " ");
		System.out.println();
	}
	
	public static void main (String [] args) {
		
		System.out.println("WordBreak...");
		
		WordBreak wordBreak = new WordBreak();
		
		Set <String> dictionary = new HashSet <>();
		
		for (String i : Dictionary) {
			dictionary.add(i);
		}
		
		String input = "takebathandcomefan";
		
		boolean result = wordBreak.wordBreak(input, dictionary);
		
		System.out.println("WordBreak = " + result);
		System.out.println("Sentence = ");  
		//printArray(wordBreak.sentenceResult, wordBreak.sentenceCount);
		
		System.out.println(wordBreak.sentenceResultList.toString());
		
	}

}
