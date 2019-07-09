package topcoder;

import java.util.ArrayList;
import java.util.List;


public class Solution3 {

	public static int sumRange (int n) {
		int result = 0;
		for (int i = 3; i <= n; i++) {
			
			List <Integer> digits = isolateDigits(i);
			System.out.println("digits = " + digits);
			int sum = findDigitFactSum (digits);
			System.out.println("i = " + i + ". sum = " + sum);

			if (sum == i) {
				result += sum;
			}
		}
		return result;
	}
	
	public static int findDigitFactSum (List <Integer> digits) {
		
		int sum = 0;
		for (Integer i: digits) {
			sum += fact (i);			
		}
		return sum;
	}
	
	public static List <Integer> isolateDigits (int n) {
		
		List <Integer> result = new ArrayList <> ();
		do {
			Integer temp = n % 10;
			result.add(temp);
			n = n / 10;
			if (n < 10)
				result.add(n % 10);
		} while (n / 10 != 0);
		return result;
	}
	
	public static int fact (int n) {
		if (n == 0)
			return 1;
		else if (n == 1)
			return 1;
		else 
			return n * fact (n - 1);
	}
	
	public static void main (String [] args) {
		
		System.out.println("Solution 3");
		
		//int result = fact (4);
		//System.out.println("Result = " + result);
				
		//List <Integer> isoDigitList = isolateDigits (145);		
		System.out.println("Result = " + sumRange(10000000));
		
		
		
		System.out.println("done." );

	}
}
