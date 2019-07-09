package sorting;

import java.util.Random;

public class RandomPartition {

	
	
	public static int [] randomPartition (int [] arr) {
		
		Random rn = new Random();
		int rpivot = rn.nextInt(arr.length);
		
		int first = arr[0];
		arr[0] = arr[rpivot];
		arr[rpivot] = first;
		
		int lo = 1;
		int hi = arr.length - 1;
		
		int pivot = arr[0];
		
		System.out.println("Random pivot = " + pivot);
		
		
		while (lo < hi) {
			
			while (arr[hi] > pivot) {
				if (hi <= lo) break;
				hi--;
			}
			
			while (arr[lo] < pivot) {
				if (lo >= hi) break;
				lo++;
			}
			
			
			
			if (lo < hi) {
				int swap = arr[hi];
				arr[hi] = arr[lo];
				arr[lo] = swap;
			}
			hi--;
		}
		
		if (pivot > arr[lo]) {
			int swap = arr[0];
			arr[0] = arr[lo];
			arr[lo] = swap;
		}
		
		return arr;
		
	}
	
	public static void printArray(int [] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
	
	
	
	
	public static void main (String [] args) {
		
		System.out.println("RandomPartition.java");
		
		//Random rn = new Random();
		//int answer = rn.nextInt(10);
	
		//System.out.println("random int = " + answer);
		
		int [] test1 = {5, 8, 4, 7, 2, 1, 6, 0};
		
		int [] result = randomPartition(test1);
		
		printArray(result);
		
		
	}
}
