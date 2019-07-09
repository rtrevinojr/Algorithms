package sorting;

public class Heapify {
	
	
	
	public static void sort (int [] arr) {
		
		createMinHeap(arr);
		
		int n = arr.length - 1;
		
		for (int i = arr.length - 1; i >= 0; i--) {
			
			swap (arr, i, 0);
			minHeapify(arr, i, 0);
		}
		
	}
	
	
	public static void createMinHeap (int [] arr) {
		
		int n = arr.length / 2;
		
		for (int i = n - 1; i >= 0; i--) {
			minHeapify (arr, i, arr.length - 1);
		}
		
	}
	
	
	public static void minHeapify (int [] arr, int k, int n)	{
		
		int left = 2 * k + 1;
		int right = 2 * k + 2;
		
		int current = k;
//		if (right < n && arr[right] < arr[left] && arr[right] < arr[current]) {
//			current = right;
//		}
//		else if (left < n && arr[left] < arr[current]) {
//			current = left;
//		}
		
		// If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
		
		if (current != k) {
			swap (arr, current, k);
			minHeapify (arr, current, n);
		}
		
	}
	
	public static void swap (int [] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void printArray (int [] arr) {
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String [] args) {
		
		System.out.println("Heapify.java");
		
		int [] arr = {3, 9, 2, 7, 1, 6, 8};
		
		sort (arr);
		
		printArray(arr);
		
		
		
	}

}