package test;

public class Solution {

	
	public static void main (String [] args) {
		
		boolean result = (100 + 1.0/3) - 100 == 1.0/3;
		
		System.out.println( Integer.class.isInstance(100 + 1.0/3));
		System.out.println( Float.class.isInstance(100 + 1.0/3));
		
		System.out.println( Double.class.isInstance(100 + 1.0/3));
		
		System.out.println( Double.class.isInstance((100 + 1.0/3) - 100));



		
		System.out.println(100 + 1.0/3);
		
		System.out.println((100 + 1.0/3) - 100);
		System.out.println(1.0/3);
		System.out.println(result);
		
	}
	
}
