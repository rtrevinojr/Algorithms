package dynamic_programming;

import java.util.LinkedList;
import java.util.List;

public class SubsetSum {
	
	
	public List <int[]> allSubsetPaths = new LinkedList <>();
	
	
	public static boolean subsetSum (int [] arr, int target) {
		
		return subsetSumHelper (arr, target, 0);
		
	}
	
	public static boolean subsetSumHelper (int [] arr, int target, int length) {
		
		if (length >= arr.length) {
			return false;
		}
		else if (target == 0) {
			return true;
		}
		else {
			return subsetSumHelper (arr, target - arr[length], length + 1) 
					|| subsetSumHelper (arr, target, length + 1);
		}
	}
	
	public void subsetSum2 (int [] arr, int target) {
		
		subsetSumHelper2 (arr, target, 0, new int [arr.length], 0);
		//return this.allSubsetPaths.get(0);
	}
	
	public void subsetSumHelper2 (int [] arr, int target, int len, int [] sack, int sackLen) {
		
		if (len >= arr.length) {
			//return;
			if (target == 0) {
				this.allSubsetPaths.add(createArray(sack, sackLen));
			}
		}
		else if (target == 0) {
			this.allSubsetPaths.add(createArray(sack, sackLen));
		}
		else {
			subsetSumHelper2 (arr, target, len + 1, sack, sackLen);
			sack[sackLen] = arr[len];
			//sackLen++;
			subsetSumHelper2 (arr, target - arr[len], len + 1, sack, sackLen + 1);
			
			//return createArray(sack, sackLen);
		}
	}
	
	public static void printArray(int [] arr, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " " );
		}
		System.out.println();
	}
	
	public static int [] createArray (int [] arr, int len) {
		int [] result = new int [len];
		for (int i = 0; i < len; i++) {
			result[i] = arr[i];
		}
		return result;
	}
	
	
	public static void main(String [] args) {
		
		System.out.println("SubsetSum.java");
		
		int [] test1 = {1, 2, 3, 4, 5, 9, 1};
		
		boolean result1 = subsetSum(test1, 9);
		
		System.out.println("result = " + result1);
		
		SubsetSum subsetSum = new SubsetSum();
		
		subsetSum.subsetSum2 (test1, 9);
		
		System.out.println("knapsack");
		
		System.out.println("knapsack size = " + subsetSum.allSubsetPaths.size());
		
		//printArray(result2, result2.length);
		
		for (int [] i : subsetSum.allSubsetPaths) {
			printArray(i, i.length);
		}
		
	}

}
