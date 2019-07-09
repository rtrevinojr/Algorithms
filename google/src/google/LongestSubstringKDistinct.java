package google;

import java.util.HashMap;

public class LongestSubstringKDistinct {
	
	
	public static int longestConSubsequence (int [] arr) {
		
		int result = 0;
		
		HashMap <Integer, Integer> map = new HashMap <>();
		
		for (int i : arr) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			}
			else {
				map.put(i, 1);
			}
		}
		
		int count = 1;
		
		for (int i = 0; i < arr.length; i++) {
			
			int loVals = arr[i];
			int hiVals = arr[i];
			while (map.containsKey(--loVals)) {
				count++;
			}
			while (map.containsKey(++hiVals)) {
				count++;
			}
			if (count > result) {
				result = count;
			}
			count = 1;
		}
		
		return result;
		
	}
	
	
	public static int lengthOfLongestSubstringKDistinct (String s, int k) {
		
		
		int max = 0;
		int start = 0;
		HashMap <Character, Integer> map = new HashMap <>();
		
		for (int i = 0; i < s.length(); i++) {
			
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			}
			else {
				map.put(ch, 1);
			}
			
			if (map.size() > k) {
				while (map.size() > k) {
					//max = Math.max(max, i - start);
					char last = s.charAt(start);
					if (map.get(last) > 1) {
						map.put(last, map.get(last) - 1);
					}
					else {
						map.remove(last);
					}
					start++;
				}
			}
			else {
				max = Math.max(max, i - start + 1);
			}
			
		}
		
		return Math.max(max, s.length() - start);
		
	}
	
	
	public static int lengthOfLongestSubstringTwoDistinct (String s) {
		
		
		int max = 0;
		int start = 0;
		
		HashMap <Character, Integer> map = new HashMap <>();
		
		for (int i = 0; i < s.length(); i++) {
			
			char ch = s.charAt(i);
			
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			}
			else {
				map.put(ch, 1);
			}
			
			if (map.size() > 2) {
				
				max = Math.max(max, i - start);
				
				while (map.size() > 2) {
				
					char first = s.charAt(start);
					if (map.get(first) > 1) {
						map.put(first, map.get(first) - 1);
					}
					else {
						map.remove(first);
					}
					start++;
				}
			}
			
		}
		
		return Math.max(max, s.length() - start);
		
	}
	
	
	
	public static void main (String [] args) {
		
		System.out.println("LongestSubstringKDistinct.java");
		
		String str = "abcddeeeef";
		
		//int result = lengthOfLongestSubstringTwoDistinct(str);
		
		int result = lengthOfLongestSubstringKDistinct (str, 3);
		
		System.out.println("Result = " + result);
		System.out.println();
		
		int [] arr = {5, 7, 2, 3, 3, 6, 8, 9, 11, 13, 14, 16, 17, 18, 19, 20, 21, 22, 23};
		
		int result2 = longestConSubsequence(arr);
		
		System.out.println("Longest Consec Subsequence = " + result2);
		
		
	}
	
}
