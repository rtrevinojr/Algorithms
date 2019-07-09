package topcoder;

import java.util.HashMap;
import java.util.Map;

public class Permutations {
	
	
	//public HashMap<Character, Integer> map;
	
	
	public Permutations() {
		//map = new HashMap<>();
	}
	
	
	
	public static void perm (String word, String rest) {
		
		if (word == null) {
			System.out.println(rest);
			return;
		}
		
		for (int i = 0; i < word.length(); i++) {
			
			char ch = word.charAt(i);
			
			String upWord = word.substring(0, i) + word.substring(i + 1);
			
			perm(upWord, rest + String.valueOf(ch));
		}
	}
	
	
	public void permX (String word) {
		
		HashMap <Character, Integer> map = initMap(word);
		
		System.out.println("map size = " + map.size());
		
		permXhelp (word, "", word.length(), map);
	}
	
	public HashMap<Character, Integer> initMap (String word) {
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			}
			else {
				map.put(ch, 1);
			}
		}
		
		return map;
	}
	
	public void permXhelp (String word, String rest, int charCount, HashMap<Character, Integer> map) {
		
		if (charCount == 0) {
			//System.out.println("isEmpty");
			System.out.println(rest);
			//return;
		}
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			
			Character ch = entry.getKey();
			Integer count = entry.getValue();
			if (count > 0) {
				map.put(ch, map.get(ch) - 1);
				permXhelp(word, rest + Character.toString(ch), charCount - 1, map);
				map.put(ch, map.get(ch) + 1);
			}
			
		}
	}
	
	public boolean mapIsEmpty(HashMap<Character, Integer> map) {
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 0) return false;
		}
		return true;
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("main...");
		
		
		Permutations p = new Permutations();
		
		p.permX("AABCD");
		
		//String test = "ABC";
		//System.out.println(test.substring(4));
		
		System.out.println("end...");
		
		int x = 355222222;
		boolean test = (x == 355222222);
		
		System.out.println("Integer test = " + test);
		
		
	}

}
