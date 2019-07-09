package topcoder;

public class Fib {
	
	
	public static int fib (int n) {
		
		assert n >= 0;
		
		int result = 0;
		int evenRes = 0;
		int first = 1;
		int second = 2;
		
		if (n == 0) return 0;
		if (n == 1) return first;
		if (n == 2) return second;
		
		for (int i = 0; i < n - 2; i++) {
			result = first + second;
			if (result > 4000000) break;
			if (result % 2 == 0) {
				evenRes += result;
				System.out.println("Result = " + result);
			}
			first = second;
			second = result;
		}
		
		return evenRes;
	}
	
	
	
	public static void main (String [] args) {
		
		System.out.println("Fib.java");
		
		int test1 = Fib.fib(10);
		
		
		
		System.out.println("Fib 10 = " + test1);
		
	}

}
