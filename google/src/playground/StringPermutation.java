package playground;

import java.util.HashMap;

public class StringPermutation {

	
	
	public static void printPermutation (String input) {
		
		stringPermutationHelper (input, "");
	}
	
	/*
	 * String permutation Runtime Complexity O(N^2*N!)
	 */
	public static void stringPermutationHelper (String input, String rest) {
		
		if (input.equals("")) {
			System.out.println(rest); // O(n)
		}	
		for (int i = 0; i < input.length(); i++) {	// O(n)
			char ch = input.charAt(i);
			String nextInput = input.substring(0, i) + input.substring(i + 1, input.length()); // O(n)
			stringPermutationHelper (nextInput, rest + ch); // O(n!)
		}
	}
	
	
	public static void getPermX (String input) {
		
		HashMap <Character, Integer> map = buildFreqMap(input);
		getPermHelperX(map, "");
	}
	
	public static void getPermHelperX (HashMap <Character, Integer> map, String rest) {
		
		if (checkMap(map)) {
			System.out.println(rest);
			return;
		}
		
		for (Character ch : map.keySet()) {
			
			int count = map.get(ch);
			
			if (count > 0) {
			
				map.put(ch, count - 1);
			
				getPermHelperX(map, rest + ch);
			
				map.put(ch, count);
			}
		}
	}
	
	public static boolean checkMap (HashMap <Character, Integer> map) {
		
		int count = 0;
		for (Integer i : map.values()) {
			count += i;
		}
		return count == 0;
	}
	
	public static HashMap <Character, Integer> buildFreqMap (String input) {
		
		HashMap <Character, Integer> result = new HashMap <>();
		
		for (int i = 0; i < input.length(); i++) {
			Character c = input.charAt(i);
			if (result.containsKey(c)) {
				result.put(c, result.get(c) + 1);
			}
			else {
				result.put(c, 1);
			}
		}
		return result;
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("String permutation.java");
		
		//printPermutation("ABC");
		
		getPermX("ABC");
		
	}
}
