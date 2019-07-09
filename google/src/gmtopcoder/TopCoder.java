package gmtopcoder;

public class TopCoder {
	
	
	public static int fib (int n) {
		
		if (n == 0)
			return n;
		else if (n == 1)
			return n;
		else {
			return fib (n - 1) + fib (n - 2);
		}
	}
	
	public static int fib2 (int n) {
		
		int result = 0;

		int ans = 0;

		if (n < 2)
			ans = 1;
		int n_1 = 1;
		int n_2 = 1;
		
		boolean isUnder = true;
		
		for (int i = 2; i <= n; i += 1) {
			System.out.println("Index = " + i);
			System.out.println("n1 = " + n_1);
			System.out.println("n2 = " + n_2);
			int n_new = n_1 + n_2;
			//System.out.println(n_new);
			if (n_new % 2 == 0)
				result += n_new;
			if (result > 4000000)
				break;
			n_1 = n_2;
			n_2 = n_new;
		}
		ans = n_2;
		return result;
	}
	
	
	
	public static void main (String [] args) {
		
		System.out.println("main");
		
		int n = 4000000;
		int result = 0;
		
		/*
		for (int i = 0; i <= n; i++) {
			int value = fib2 (i);
			System.out.println("value = " + value);
			if (value % 2 == 0) 
				result += value;
//			if (result > 4000000)
//				break;
		}
		*/
		
		result = fib2 (n);
		
		System.out.println("result = " + result);
		
	}

}
