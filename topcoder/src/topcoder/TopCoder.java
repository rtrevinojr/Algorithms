package topcoder;

import java.util.HashSet;

public class TopCoder {
	
	
	
	public void allPairSum (int [] arr, int sum) {
		
		HashSet <Integer> set = new HashSet <>();
		for (int i : arr) {
			if (set.contains(sum - i)) {
				System.out.println("(" + (sum - i) + ", " + i + ")");
			}
			set.add(i);
		}
	}
	
	
	public boolean pairSum (int [] arr, int sum) {
		
		HashSet<Integer> set = new HashSet<>();
		for (int i: arr) {
			
			if (set.contains(sum - i)) {
				return true;
			}
			set.add(i);		
		}
		
		return false;
	}
	
	
	public int findEven (int [] arr) {
		
		int result = 0;
		for (int i : arr) {
			result ^= i;
		}
		return result;
	}

	
	public static void main (String [] args) {
		
		System.out.println("Topcoder.java");
		
		int [] test = {1, 8, 9, 12, 4, 5, 6};
		
		TopCoder tc = new TopCoder();
		
		tc.allPairSum(test, 12);
		
		
		//System.out.println("Test result = " + result);
		
		int [] test2 = {3, 3, 5, 8, 9, 12, 9, 5, 12};
		
		int res = tc.findEven(test2);
		
		System.out.println("Non dup = " + res);
		
		
	}
}
