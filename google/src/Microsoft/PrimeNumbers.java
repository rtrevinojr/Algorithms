package Microsoft;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimeNumbers {
	
	
	public static void getFreq (int [] ages) {
	
		for (int i = 0; i < ages.length; ++i) { 
	        ages[(ages[i] - 1) % (ages.length + 1)] += ages.length + 1;
		}
	
		for(int i = 0; i < ages.length; ++i) {
	     
	          System.out.println("Feq of " + i + 1 + " is : " + ages[i] / (ages.length + 1));
		}
		
	}
	
	
	
	public static void countAgeGroupsOp (int [] ages) {
		
		if (ages.length == 0) { return; }
		
		assert ages.length > 0;
		
		int initAge = ages[0];
		int count = 1;
		
		for (int i = 1; i < ages.length; i++) {
			initAge = ages[i - 1];
			if (ages[i] != initAge) {
				System.out.println(initAge + " : " + count);
				count = 1;
			}
			else {
				count++;
			}
			if (i == ages.length - 1) {
				System.out.println(ages[i] + " : " + count);
			}
		}
		
	}
	
	
	
	public static void countAgeGroups (int [] ages) {
		
		Map<Integer, Integer> map = new HashMap <> ();
		
		for (Integer i : ages) {
			
			if (map.containsKey(i)) {
				Integer count = map.get(i) + 1;
				map.put(i, count);
			}
			else {
				map.put(i, 1);
			}
		}
		System.out.println(map.toString());
	}
	
	public static void getPrimeRange (int l, int r) {
		
		int left = l;
		int right = r;
		if (l > r) {
			left = r;
			right = l;
		}
		
		List <Integer> result = new ArrayList <> ();
		
		for (int num = left; num <= right; num++) {
			boolean isPrime = true;
			if (Math.abs(num) <= 2 ) {
				isPrime = false;
			}
			for (int i = 2; i <= Math.abs(num)/2 && isPrime; i++) {	
				if (num % i == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				result.add(num);
			}
		}
		if (result.size() > 0) {
			System.out.println(true);
			System.out.println();
			System.out.println(result.toString());
		}
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("main....");
		
		getPrimeRange(-18, 18);
		
		System.out.println(-3 % 3);
		
		int [] ages  = {8, 8,8,9,9,11,15,16,16,16};
		
		countAgeGroups(ages);
		
		countAgeGroupsOp (ages);
		
		//getFreq(ages);
		
	}

}

