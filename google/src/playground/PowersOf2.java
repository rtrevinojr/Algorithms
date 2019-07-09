package playground;

public class PowersOf2 {

	
	
	public static int powersOf2 (int n) {
		
		if (n < 1) {
			return 0;
		}
		else if (n == 1) {
			System.out.print(n + " ");
			return 1;
		}
		else {
			int prev = powersOf2 (n / 2);
			int curr = prev * 2;
			System.out.print(curr + " ");
			return curr;
		}
	}
	
	public static void main (String [] args) {
		
		powersOf2(100);
	}
	
}
