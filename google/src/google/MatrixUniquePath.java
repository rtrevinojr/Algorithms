package google;

public class MatrixUniquePath {

	
	public static int countMatrix (int [][] matrix) {
		
		return dfs (matrix, 0, 0);
	}
	
	public static int dfs (int [][] board, int row, int col) {
		
		if (row >= board.length && col >= board[0].length) {
			return 1;
		}
		if (row < board.length && col < board[0].length) {
			return dfs (board, row + 1, col) + dfs (board, row, col + 1);
		}
		if (row < board.length) {
			return dfs (board, row + 1, col);
		}
		if (col < board[0].length) {
			return dfs (board, row, col + 1);
		}
		
		return 1;
	}
	
	
	public static void main (String [] args) {
		
		System.out.println(".java");
		
		int [][] matrix = new int [3][3];
		
		int result = countMatrix(matrix);
		
		System.out.println("Result = " + result);
		
		
		
	}
}
