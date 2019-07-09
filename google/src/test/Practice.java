package test;

public class Practice {
	
	public static void setInt (int x) {
		
		x = 1;
	}
	
	public static void setBigInt (Integer x) {
		x = 1;
	}
	
	public static void setArray (int [] arr) {
		arr[0] = 1;
	}
	
	
	public static void main (String [] args) {
		
		Integer x = 0;
		int x2 = 0;
		
		setInt(x);
		
		System.out.println(x);
		
		setInt(x2);
		
		System.out.println(x2);
		
		setBigInt (x);
		
		System.out.println(x);
		
		int [] arr = {0};
		
		setArray(arr);
		
		System.out.println(arr[0]);
		
		
	}

}
