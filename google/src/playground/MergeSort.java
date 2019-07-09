package playground;

public class MergeSort {
	
	
	
	public static int [] mergeSortX (int [] arr) {
		
		int [] aux = new int [arr.length];
		mergeSortHelperX (arr, aux, 0, arr.length - 1);
		return arr;
	}
	
	public static void mergeSortHelperX (int [] arr, int [] aux, int lo, int hi) {
		
		if (lo < hi) {
			int mid = (lo + hi) / 2;
			mergeSortHelperX (arr, aux, lo, mid);
			mergeSortHelperX (arr, aux, mid + 1, hi);
			mergeX (arr, aux, lo, mid, hi);
		}
	}
	
	public static void mergeX (int [] arr, int [] aux, int lo, int mid, int hi) {
		
		for (int i = lo; i <= hi; i++) {
			aux[i] = arr[i];
		}
		int auxLeft = lo;
		int auxRight = mid + 1;
		int current = lo;
		
		while (auxLeft <= mid && auxRight <= hi) {
			if (aux[auxLeft] <= aux[auxRight]) {
				arr[current] = aux[auxLeft++];
			}
			else {
				arr[current] = aux[auxRight++];
			}
			current++;
		}
		
		int remaining = mid - auxLeft;
		for (int i = 0; i <= remaining; i++) {
			arr[current++] = aux[auxLeft++];
		}
		
	}
	
	
	public static int findKth (int [] a1, int [] a2, int k) {
		
		int index1 = 0;
		int index2 = 0;
		
		int result = 0;
		
		for (int i = 0; i < k; i++) {
			
			if (index1 >= a1.length) {
				result = a2[index2++];
			}
			else if (index2 >= a2.length) {
				result = a1[index1++];
			}
			else if (a1[index1] < a2[index2]) {
				result = a1[index1++];
			}
			else {
				result = a2[index2++];
			}
		}
		return result;
	}
	
	
	
	public static int [] sort (int [] arr) {
		
		if (arr.length == 1) 
			return arr;
		
		int mid = arr.length / 2;
		
		int [] a1 = new int [mid];
		int [] a2 = new int [arr.length - mid];
		
		for (int i = 0; i < arr.length; i++) {
			if (i < mid)
				a1[i] = arr[i];
			else 
				a2[i - mid] = arr[i];
		}
		
		int [] r1 = sort(a1);
		int [] r2 = sort(a2);
		
		return merge (r1, r2);
	}

	
	public static int [] merge (int [] a1, int [] a2) {
		
		int [] result = new int [a1.length + a2.length];
		int index1 = 0;
		int index2 = 0;
		
		for (int i = 0; i < a1.length + a2.length; i++) {
			
			if (index1 > a1.length - 1) {
				result[i] = a2[index2++];
			}
			else if (index2 > a2.length - 1) {
				result[i] = a1[index1++];
			}
			else if (a1[index1] < a2[index2]) {
				result[i] = a1[index1++];
			}
			else {
				result[i] = a2[index2++];
			}
		}
		return result;
	}
	
	public static void printArray(int [] arr) {
		for (int i : arr) 
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void main (String [] args) {
		
		System.out.println("MergeSort.java");
		
		int [] a = {2, 4, 5};
		int [] b = {1, 3, 6, 7};
		
		
		int findK = findKth (a, b, 6);
		
		System.out.println("Merge Kth = " + findK);
		
		int [] result = merge(a, b);
		
		printArray(result);
		
		
		
		System.out.println();
		
		int [] arr = { 4, 3 ,5, 9, 1, 8, 7, 2, 6, 0};
		
		//int [] sortResult = sort(arr);
		
		int [] sortResult = mergeSortX (arr);
		
		printArray(sortResult);
		
		
	}
}
