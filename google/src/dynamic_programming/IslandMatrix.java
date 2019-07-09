package dynamic_programming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IslandMatrix {
	
	public int [][] islandMatrix;
	public boolean [][] aux;
	public int N;
	public int M;
	public int islandCount = 0;
	
	public IslandMatrix (int n, int m) {
		N = n;
		M = m;
		islandMatrix = new int [n][m];
		aux = new boolean [n][m];
		
	}
	
	public void setCoordinate (int x, int y, int value) {
		
		if (y < 0 || y > M - 1) {
			throw new IndexOutOfBoundsException ();
		}
		if (x < 0 || x > N - 1) {
			throw new IndexOutOfBoundsException ();
		}
		islandMatrix[x][y] = value;
	}
	
	public int countIslands() {
		
		for (int r = 0; r < this.islandMatrix.length; r++) {
			for (int c = 0; c < this.islandMatrix[0].length; c++) {
				
				if(islandMatrix[r][c] > 0 && !aux[r][c]) {
					islandCount++;
					countIslandsHelper (r, c);
				}
			}
		}
		return islandCount;
	}
	
	public void countIslandsHelper (int r, int c) {
		
		
		
//		if (islandMatrix[r][c] == 0) {
//			return;
//		}
		if (islandMatrix[r][c] == 1 && !aux[r][c]){
			
			aux[r][c] = true;
			
			if (r > 0 && c > 0) {
				countIslandsHelper (r - 1, c - 1); 
			}
			if (r < N - 1 && c < M - 1) {
				countIslandsHelper (r + 1, c + 1);
			}
			if (r > 0 && c < N - 1) {
				countIslandsHelper (r - 1, c + 1);
			}
			if (r < N - 1 && c > 0) {
				countIslandsHelper (r + 1, c - 1);
			}
			if (r > 0) {
				countIslandsHelper (r - 1, c);
			}
			if (r < N - 1) {
				countIslandsHelper (r + 1, c);
			}
			if (c > 0) {
				countIslandsHelper (r, c - 1);
			}
			if (c < M - 1) {
				countIslandsHelper (r, c + 1);
			}
		}
	}
	
	public static void printMatrix(int [][] matrix) {
	
		for (int r = 0; r < matrix.length; r++) {
			
			for (int c = 0; c < matrix[0].length; c++) {
				
				System.out.print(matrix[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void test () {
		
		int row = 1;
		int col = 1;
		
		int val = -1;
		
		
		
		List <Integer> colList  = new ArrayList <Integer>(10);
		colList.a
		
		//colList.add(col);
		//colList.set(col, val);
		colList.add(col, val);
		
		List <List <Integer>> lot = new LinkedList <> ();
		
		//lot.add(colList);
		lot.set(row, colList);
		
		
		Integer value = -(lot.get(row).get(col));
		
		System.out.println("value = " + value);
		
        List <Integer> columns = lot.get(row);
        columns.set(col, value);
        lot.set(row, columns);
	}
	
	public static void main (String [] args) {
		
		System.out.println("IslandMatrix.java" + "\n");
		
		test();
		
		IslandMatrix islandMatrix = new IslandMatrix (5, 6);
		islandMatrix.setCoordinate(0, 0, 1);
		islandMatrix.setCoordinate(1, 0, 1);
		islandMatrix.setCoordinate(0, 1, 1);
		islandMatrix.setCoordinate(1, 2, 1);
		islandMatrix.setCoordinate(3, 2, 1);
		islandMatrix.setCoordinate(4, 1, 1);
		islandMatrix.setCoordinate(4, 2, 1);
		islandMatrix.setCoordinate(4, 2, 1);
		islandMatrix.setCoordinate(2, 2, 1);
		islandMatrix.setCoordinate(4, 5, 1);
		
		islandMatrix.setCoordinate(4, 1, 1);
		islandMatrix.setCoordinate(0, 5, 1);
		
		islandMatrix.setCoordinate(3, 5, 1);
		
		printMatrix(islandMatrix.islandMatrix);
		
		System.out.println();
		
		System.out.println("Island count = " + islandMatrix.countIslands());
		
	}

}
