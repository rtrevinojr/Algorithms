package google;

import java.util.LinkedList;
import java.util.List;

public class SubsetSum {

	
	public static boolean subsetSum (int [] input, int target) {
		return subsetSum(input, target, 0);
	}
	public static boolean subsetSum(int [] input, int target, int index) {
		
		if (index >= input.length) {
			return false;
		}
		if (target == 0) {
			return true;
		}
		return subsetSum(input, target - input[index], index + 1) 
				|| subsetSum(input, target, index + 1);
	}
	
	public static boolean [][] subsetSumDP (int [] input, int target) {
		

		
		int rows = input.length;
		int cols = target + 1;
		
		boolean [][] mem = new boolean[rows][cols];
		
		for (int r = 0; r < rows; r++) {
			mem[r][0] = true;
		}
		
		for (int c = 1; c < cols; c++) {
			mem[0][c] = (input[0] == c);
		}
		
		for (int r = 1; r < rows; r++) {
			for (int c = 1; c < cols; c++) {
				if (c >= input[r]) {
					boolean value = mem[r-1][c] || mem[r-1][c - input[r]];
					mem[r][c] = value;
				}
				else {
					mem[r][c] = mem[r-1][c];
				}
			}
		}
		
		return mem;
		
	}
	
	public static List <Integer> getSubset (boolean [][] matrix, int [] input) {
		
		int row = matrix.length - 1;
		int col = matrix[0].length - 1;
		
		if (matrix[row][col] == false) {
			return null;
		}
		
		List <Integer> result = new LinkedList <>();
		
		while (row > 0 && col > 0) {
			
			if (matrix[row - 1][col] == false) {
				
				result.add(input[row]);
				col -= input[row];
			}
			else {
				row--;
			}
		}
		
		return result;
	}
	
	public static void printMatrix (boolean [][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				if (matrix[r][c])
					System.out.print("T ");
				else 
					System.out.print("F ");
			}
			System.out.println();
		}
	}
	
	public static void printMatrix(boolean [][] matrix, int [] input) {
		System.out.println("DP Memoization Matrix: ");
		System.out.print("  ");
		for (int c = 0; c < matrix[0].length; c++) {
			System.out.print(c + " ");
		}
		System.out.println();
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length + 1; c++) {
				if (c == 0) 
					System.out.print(input[r] + " ");
				else if (matrix[r][c])
					System.out.print("T ");
				else 
					System.out.print("F ");
			}
			System.out.println();
		}
	}
	
	
	public static void main (String [] args) {
		System.out.println("SubsetSum.java");
		
		int [] input = {2, 3, 7, 8, 10, 1};
		int target = 11;
		boolean result = subsetSum (input, target);
		
		System.out.println("Result = " + result);
		
		boolean [][] dpresult = subsetSumDP(input, target);
		
		System.out.println("DP Result = " );
		printMatrix(dpresult);
		int len = dpresult.length;
		int wid = dpresult[0].length;
		boolean isValid = dpresult[len-1][wid-1];
		
		System.out.print("DP = " + isValid);
		
		System.out.println(getSubset(dpresult, input));
		
	}
}