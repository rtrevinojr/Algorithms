package sorting;

import java.util.Arrays;

public class Partition {
	
	
	public static void sort (int [] arr) {
		
		int lo = 0;
		int hi = arr.length - 1;
		
		sortHelper (arr, lo, hi);
	}
	
	public static void sortHelper (int [] arr, int lo, int hi) {
		
		if (lo >= hi) return;
		
		int pivot = partitionHi(arr, lo, hi);
		
		sortHelper (arr, lo, pivot - 1);
		sortHelper (arr, pivot + 1, hi);
	}
	
	
	public static int partitionHi (int [] arr, int lo, int hi) {
		
		int i = lo;
		int j = hi;
		int pivot = arr[hi];
		
		while (true) {
			
			while (arr[i] <= pivot) {
				i++;
				if (i >= hi) break;
			}
			
			while (arr[j] >= pivot) {
				j--;
				if (j < lo) break;
			}
			
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			else {
				break;
			}
		}
		int temp = arr[i];
		arr[i] = arr[hi];
		arr[hi] = temp;
		return i;
	}
	
	public static boolean isSorted (int [] arr) {
		for (int i = 1; i < arr.length; i++) 	
			if (arr[i] > arr[i - 1]) return false;
		return true;
	}
	
	public static void main (String [] args) {
		
		System.out.println("Partition.java");
		
		int [] a = {2, 3, 1, 5, 4 };
		
		int [] b = {6, 3, 8, 2, 7, 4, 1, 5, 9, 10 };
		
		int [] c = Arrays.copyOf(b, 8);
		
		//partitionHi (b, 0, 7);
		
		sort (b);
		
		assert isSorted(b);
		
		//for (int i : b) System.out.print(i);
		for (int x : b) System.out.print(x + " - ");
		System.out.println("\n\n");
		
		
		
		/*
		
		//for (int i : c) System.out.println(i);
		for (int x : c) System.out.print(x + " - ");
		System.out.println("\n");

		
		
		sort (c);
		
		for (int x : c) System.out.print(x + " - ");
		System.out.println("\n");
		
		*/
		
		
	}

}
