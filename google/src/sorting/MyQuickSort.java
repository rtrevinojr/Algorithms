package sorting;

public class MyQuickSort {

	
	public int [] sort (int [] arr) {
		
		return sort (arr, 0, arr.length - 1);
	}
	
	public int [] sort (int [] arr, int lo, int hi) {
		
		if (lo >= hi) {
			return arr;
		}
		int pivot = partition (arr, lo, hi);
		sort (arr, lo, pivot - 1);
		sort (arr, pivot + 1, hi);
		
		return arr;
	}
	
	public int partition (int [] arr, int left, int right) {
		
		int lo = left;
		int hi = right;
		int pivot = arr[hi];
		hi--;
		
		while (true) {
			
			while (arr[lo] < pivot) {
				lo++;
				if (lo >= right) break;
			}
			
			while (arr[hi] > pivot) {
				hi--;
				if (hi <= left) break;
			}
			
			if (lo < hi) {
				int tmp = arr[lo];
				arr[lo] = arr[hi];
				arr[hi] = tmp;
			}
			else {
				break;
			}
		}
		
		//if (lo < right) {
			int tmp = arr[lo];
			arr[lo] = arr[right];
			arr[right] = tmp;
		//}
		
		return lo;
	}
	
	public static void printArray(int [] arr) {
		
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("QuickSort");
		
		MyQuickSort quickSort = new MyQuickSort ();
		
		int [] arr = {3, 0, 5, 1, 2};
		
		int [] result = quickSort.sort(arr);
		
		printArray(result);
		
		printArray(arr);
		
		int [] arr2 = {3, 5, 1, 2, 0};
		
		quickSort.sort(arr2);
		printArray(arr2);
		
		int [] arr3 = {3, 0, 1, 2, 5};
		quickSort.sort(arr3);
		printArray(arr3);
		
		int [] arr4 = {5, 1, 3, 9, 4, 6};
		quickSort.sort(arr4);
		printArray(arr4);
		
		int [] emptyArray = {};
		quickSort.sort(emptyArray);
		printArray(emptyArray);
		
		int [] singleEle = {0};
		quickSort.sort(singleEle);
		printArray(singleEle);
		
		int [] twoEle = {2, 0};
		quickSort.sort(twoEle);
		printArray(twoEle);
		
		int [] sorted = {1, 2, 3};
		quickSort.sort (sorted);
		printArray(sorted);
		
		int [] reverse = {3, 2, 1};
		quickSort.sort(reverse);
		printArray(reverse);
		
		int [] test = {7, 9, 3, 11, 15, 1, 18, 12, 5, 4, 14, 19, 8, 6, 16, 13};
		quickSort.sort(test);
		printArray(test);
		
		
		
	}
}
