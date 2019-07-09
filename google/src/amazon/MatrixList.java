package amazon;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class MatrixList {
	
	
	public static class Node {
		int x;
		int y;
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	int minDist = 10000;
	
	public MatrixList () {
		
	}
	
	public MatrixList (int [][] matrix) {
		
	}
	
	public Integer get (int x, int y, List <List <Integer>> lot) {
		
		return lot.get(y).get(x);
	}
	
	public void setMatrixCoord (int x, int y, List <List <Integer>> lot) {
		
		List <Integer> row = lot.get(y);
		row.set(x, -row.get(x));
		lot.set(y, row);
	}
	
	public List <List <Integer>> initMatrixList (Integer [][] matrix) {
		
		List <List <Integer>> result = new ArrayList <List <Integer>> ();
		for (Integer [] row : matrix) {
			result.add(Arrays.asList(row));
		}
		return result;
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
		// WRITE YOUR CODE HERE
		
		if (lot.get(0).get(0) == 9) return 0;
		
		//removeObstacleHelper (numRows, numColumns, 0, 0, lot, 0);
		
		return removeObstacleOp(numRows, numColumns, lot);

		//return minDist;
	}
	
	int removeObstacleOp (int numRows, int numColumns, List <List <Integer>> lot) {
		
		int result = 1;
		
		int [] xAxis = {1, -1, -1, 1, 1, 0, -1, 0};
		int [] yAxis = {1, -1, 1, -1, 0, 1, 0, -1};
		
		boolean [][] aux = new boolean [numRows][numColumns];
		
		Queue <Node> queue = new LinkedList <> ();
		queue.add(new Node(0, 0));
		aux[0][0] = true;
		
//		Integer value = lot.get(0).get(0);
//		List<Integer> columns = lot.get(0);
//		columns.set(0, value);
//		lot.set(0, columns);
		
		Queue <Node> levelQueue = new LinkedList <> ();
		
		while (!queue.isEmpty()) {
			
			Node node = queue.remove();
			
			for (int i = 0; i < 8; i++) {
				int x = node.x + xAxis[i];
				int y = node.y + yAxis[i];
				if (validCoord (numRows, numColumns, x, y)) {
					//System.out.println("valid coord: x = " + x + ", y = " + y);
					if (lot.get(x).get(y) == 9) {
						return ++result;
					}
					//else if (lot.get(x).get(y) == 1 && !aux[x][y]) {
					else if (lot.get(x).get(y) == 1 ) {
						levelQueue.add(new Node (x, y));
						aux[x][y] = true;
						Integer val = -lot.get(x).get(y);
						List<Integer> cols = lot.get(x);
						cols.set(y, val);
						lot.set(x, cols);
					}
					else {
						aux[x][y] = true;
						//Integer val = lot.get(x).get(y);
						//List<Integer> cols = lot.get(x);
						//columns.set(y, val);
						//lot.set(x, cols);
					}
				}
			}
			if (queue.isEmpty()) {
				queue = levelQueue;
				levelQueue = new LinkedList <> ();
				result++;
			}
		}
		
		return -1;
		
	}
	
	int removeObstacleX (int numRows, int numColumns, List <List <Integer>> lot) {
		
		int result = 1;
		
		int [] xAxis = {1, -1, -1, 1, 1, 0, -1, 0};
		int [] yAxis = {1, -1, 1, -1, 0, 1, 0, -1};
		
		boolean [][] aux = new boolean [numRows][numColumns];
		
		Queue <Node> queue = new LinkedList <> ();
		queue.add(new Node(0, 0));
		aux[0][0] = true;
		
		Integer value = lot.get(0).get(0);
		List<Integer> columns = lot.get(0);
		columns.set(0, value);
		lot.set(0, columns);
		
		Queue <Node> levelQueue = new LinkedList <> ();
		
		while (!queue.isEmpty()) {
			
			Node node = queue.remove();
			
			for (int i = 0; i < 8; i++) {
				int x = node.x + xAxis[i];
				int y = node.y + yAxis[i];
				if (validCoord (numRows, numColumns, x, y)) {
					//System.out.println("valid coord: x = " + x + ", y = " + y);
					if (lot.get(x).get(y) == 9) {
						return ++result;
					}
					//else if (lot.get(x).get(y) == 1 && !aux[x][y]) {
					else if (lot.get(x).get(y) == 1 ) {
						levelQueue.add(new Node (x, y));
						aux[x][y] = true;
						Integer val = -lot.get(x).get(y);
						List<Integer> cols = lot.get(x);
						columns.set(y, val);
						lot.set(x, cols);
					}
					else {
						aux[x][y] = true;
						//Integer val = lot.get(x).get(y);
						//List<Integer> cols = lot.get(x);
						//columns.set(y, val);
						//lot.set(x, cols);
					}
				}
			}
			if (queue.isEmpty()) {
				queue = levelQueue;
				levelQueue = new LinkedList <> ();
				result++;
			}
		}
		
		return -1;
		
	}
	
	
/*	int removeObstacleBFS (int numRows, int numColums, List <List <Integer>> lot) {
		
		int [] xAxis = {1, -1, -1, 1, 1, 0, -1, 0};
		int [] yAxis = {1, -1, 1, -1, 0, 1, 0, -1};
		
		Queue <Integer> queue = new LinkedList <>();
		queue.add(0);
		
		Integer value = -lot.get(0).get(0);
		List <Integer> rowLst = lot.get(0);
		rowLst.set(0, value);
		lot.set(0, rowLst);
		
		while (!queue.isEmpty()) {
			
			Integer node = queue.remove();
			
			
			for (int i = 0; i < 8; i++) {
				if (validCoord(numRows, numColumns, n)) {
					queue.add(i);
				}
			}
		}
		
		
	}*/
	
	
	boolean validCoord (int numRows, int numColumns, int row, int col) {
		if (row < 0 || col < 0) return false;
		if (row > numRows - 1) return false;
		if (col > numColumns - 1) return false;
		return true;
	}
	
	
	void removeObstacleHelperOp (int numRows, int numColumns, int row, int col, List <List <Integer>> lot, int dist) {
		
		int [] xAxis = {1, -1, -1, 1, 1, 0, -1, 0};
		int [] yAxis = {1, -1, 1, -1, 0, 1, 0, -1};
		
		if (lot.get(row).get(col) == 1) {
			
			Integer value = -lot.get(row).get(col);
			
			List <Integer> rowLst = lot.get(row);
			rowLst.set(col, value);
			
			lot.set(row, rowLst);
			
			for (int i = 0; i < 8; i++) {
				if (validCoord (numRows, numColumns, row, col))
					removeObstacleHelperOp(numRows, numColumns, yAxis[row + i], xAxis[col + i], lot, ++dist);
			}
		}
	}
	

	// METHOD SIGNATURE ENDS
	void removeObstacleHelper(int numRows, int numColumns, int row, int col,
			List<List<Integer>> lot, int dist) {

		// System.out.println(lot.get(row).get(col));

		if (lot.get(row).get(col) == 1) {
			Integer value = lot.get(row).get(col);
			//System.out.println(value);

			List<Integer> columns = lot.get(row);
			columns.set(col, value);
			lot.set(row, columns);

			if (row > 0 && col > 0)
				removeObstacleHelper(numRows, numColumns, row - 1, col - 1,
						lot, ++dist);
			if (row < numRows - 1 && col < numColumns - 1)
				removeObstacleHelper(numRows, numColumns, row + 1, col + 1,
						lot, ++dist);
			if (row > 0 && col < numColumns - 1)
				removeObstacleHelper(numRows, numColumns, row - 1, col + 1,
						lot, ++dist);
			if (row < numRows - 1 && col > 0)
				removeObstacleHelper(numRows, numColumns, row + 1, col - 1,
						lot, ++dist);
			if (row > 0)
				removeObstacleHelper(numRows, numColumns, row - 1, col, lot,
						++dist);
			if (row < numRows - 1)
				removeObstacleHelper(numRows, numColumns, row + 1, col, lot,
						++dist);
			if (col > 0)
				removeObstacleHelper(numRows, numColumns, row, col - 1, lot,
						++dist);
			if (col < numColumns - 1)
				removeObstacleHelper(numRows, numColumns, row, col + 1, lot,
						++dist);

		} else if (lot.get(row).get(col) == 9) {
			Integer value = -(lot.get(row).get(col));
			//System.out.println(value);
			if (++dist < minDist)
				minDist = dist;
			return;
		}
		else {
			return;
		}

	}
	
	public static void print2dList (List <List <Integer>> matrixLst) {
		
		for (List <Integer> row : matrixLst) {
			System.out.print("[");
			for (Integer i : row) {
				System.out.print(i + " ");
			}
			System.out.print("]");
			System.out.println();
		}
	}
	
	public static void main (String [] args) {
		System.out.println("main");
		
		MatrixList matrixList = new MatrixList ();
		
//		boolean []boolArr = new boolean [6];
//		for (boolean b : boolArr) System.out.print(b);
		
		
		Integer [][] matrix = {
				{1, 0, 0},
				{1, 1, 1},
				{1, 9, 1}
		};
		
		Integer [][] matrix2 = {
				{1, 1, 1, 0, 0},
				{1, 0, 1, 1, 0},
				{1, 0, 0, 1, 0},
				{1, 0, 0, 1, 0},
				{1, 0, 0, 1, 9},
				{1, 1, 1, 1, 1}
		};
		
		Integer [][] matrix3 = {
				{1, 1, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 0},
				{0, 1, 0, 0, 0, 0},
				{1, 1, 1, 1, 1, 9},
				{0, 1, 0, 0, 0, 1},
				{0, 1, 0, 0, 0, 1},
				{0, 1, 1, 1, 1, 1}
		};
		
		
		List <List <Integer>> matrixLst = matrixList.initMatrixList(matrix2);
		
		print2dList (matrixLst);
		
		int path = matrixList.removeObstacle(6, 5, matrixLst);
		
		System.out.println("Shortest path = " + path);
		
		print2dList (matrixLst);
		
		
	}

}
