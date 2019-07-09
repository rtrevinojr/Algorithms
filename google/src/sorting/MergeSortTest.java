package sorting;

public class MergeSortTest {
	
	
	
	public static void main (String [] args) {
		
		System.out.println("MergeSort Test");
		
		String s = "9";
		
		int integerR = Integer.parseInt(s);
		
		System.out.println("int result = " + integerR / 10);
		
		for (int i = 0; i < s.toCharArray().length; i++) {
			
			System.out.println(s.toCharArray()[i] - '0');
		}
	}

}
