package topcoder;

public class Sol {
	
	public static void main (String [] args) {
		
		Object o = new Object () {
			
			public String toString () {
				System.out.println("toString");
				return "toString";
			}
		};
		
		System.out.println(o.toString());
		
	}

}
