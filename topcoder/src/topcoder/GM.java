package topcoder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class GM {
	
	
	public static int fact (int num) {
		
		if (num == 1) return 1;
		
		return num * fact (num - 1);
	}
	
	/*
	public static String runLen (String input) {
		
		TreeMap <Character, Integer> map = new TreeMap <> ();
		
		for (int i = 0; i < input.length(); i++) {
			
			Character ch = input.charAt(i);
			
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			}
			else {
				map.put(ch, 1);
			}
		}
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			
			Character ch = entry.getKey();
			//Integer count = entry.getCou
		}
	} */
	
	
	public static int counter () {
		
		int result = 1;
		int inc = 0;
		
		for (int i = 0; i < 62; i++) {
			
			
			result += inc;
			inc += 5;
		}
		
		return result;
	}
	
	
	public static boolean isPal (int num) {
		
		//HashMap <Character, Integer> set = new HashMap <>();
		
		Stack <Character> stack = new Stack<>();
		
		String number = String.valueOf(num);
		
		for (int i = 0; i < number.length(); i++) {
			
			Character ch = number.charAt(i);
			
			if (i <= (number.length() / 2)) {
				stack.push(ch);
			}
			else if (i > number.length() / 2 && stack.peek().equals(ch)) {
				stack.pop();
			}
			
		}
		
		System.out.println(stack.size());
		
		if (stack.isEmpty()) {
			return true;
		}
		else return false;
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("main");
		
		int result = fact(5);
		
		System.out.println(result);
		
		System.out.println("************");
		
		int test = 33;
		
		boolean result2 = isPal(test);
		
		System.out.println(result2);
		
		System.out.println("counter");
		System.out.println(counter());
	}

}
