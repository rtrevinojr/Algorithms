package topcoder;

public class Matrix {

	public int pathCount = 0;
	
	public int allPaths (int [][] matrix) {
		
		return 0;
	}
	
	public int allPathHelper (int [][] matrix, int row, int col) {
		
		if (row == matrix.length && col == matrix[0].length) {
			pathCount++;
		}
		
		return 0;
		
	}
	
	
	public static void test () {
		
		
		String s = "test";
		
		char ch = 0;
		
		int i = 96;
		
		String result = s + (ch + '0');
		
		System.out.println(result);
		
	}
	
	
	public static void main(String [] args) {
		
		System.out.println("main");
		
		test();
	}
}
