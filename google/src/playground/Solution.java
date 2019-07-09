package playground;

import java.util.List;

public class Solution {
	
	
	public class InnerClass {
		
		public int x;
		
		public InnerClass (int x) {
			this.x = x;
		}
	}
	
	
	public static void main (String [] args) {
		
		Solution solution = new Solution ();
		
		String s = "x";
	
		
		//InnerClass inner = solution.new InnerClass (1);
		
		InnerClass in = null;
		
		List <Integer> l = null;
		
		if (l != null && l.size() == 0) 
			System.out.println("isValid");
		
//		if (l.size() > 0 && l != null) 
//			System.out.println("isValid 2");
		
		//System.out.println("InnerClass in = " + in.toString());
		
		
		System.out.println("--------------------------------------------------");
		
		System.out.println("2 % 10 = " + 2 % 10);
		System.out.println("0 % 10 = " + 0 % 10);
		System.out.println("1 % 10 = " + 1 % 10);
		
		System.out.println("-2 % 10 = " + -2 % 10);
		System.out.println("-20 % 10 = " + -20 % 10);
		System.out.println("-20 % 15 = " + -20 % 15);
		
	}

}
