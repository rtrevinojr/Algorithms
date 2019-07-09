package gmtopcoder;

class BinarySearch {
	
	
	static int binarySearchRec (int [] arr, int target) {
		
		return binarySearchRecHelper (arr, target, 0, arr.length - 1);
	}
	
	static int binarySearchRecHelper (int [] arr, int target, int lo, int hi) {
		
		if (lo <= hi) {
			
			int mid = lo + (hi - lo) / 2;
			
			if (target > arr[mid]) {
				return binarySearchRecHelper (arr, target, mid + 1, hi);
			}
			else if (target < arr[mid]) {
				return binarySearchRecHelper (arr, target, lo, mid - 1);
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	
	static int binarySearch (int [] arr, int target) {
		
		int lo = 0;
		int hi = arr.length - 1;
		
		while (lo <= hi) {
			
			int mid = lo + (hi - lo) / 2;
			
			if (target == arr[mid]) {
				return mid;
			}
			else if (target > arr[mid]) {
				lo = mid + 1;
			}
			else {
				hi = mid - 1;
			}
		}
		return -1;
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("BinarySearch");
		
		int [] test1 = {0, 1, 2, 3, 4, 5};
		
		int result1 = binarySearch(test1, 3);
		
		System.out.println("Index of target 3 = " + result1);
		
		System.out.println("Index of target 5 = " + binarySearch(test1, 5));
		
		System.out.println("Index of target 0 = " + binarySearch(test1, 0));
		
		System.out.println("Index of no target 6 = " + binarySearch(test1, 6));
		
		int [] test2 = {};
		
		System.out.println("Index of single element = " + binarySearch(test2, 0));
		System.out.println("Index of single element = " + binarySearch(test2, 1));
		
		System.out.println();
		
		int [] test1r = {0, 1, 2, 3, 4, 5};
		
		int result1r = binarySearch(test1r, 3);
		
		System.out.println("Index of target 3 = " + result1r);
		
		System.out.println("Index of target 5 = " + binarySearch(test1r, 5));
		
		System.out.println("Index of target 0 = " + binarySearch(test1r, 0));
		
		System.out.println("Index of no target 6 = " + binarySearch(test1r, 6));
		
		int [] test2r = {0};
		
		System.out.println("Index of single element = " + binarySearch(test2r, 0));
		System.out.println("Index of single element = " + binarySearch(test2r, 1));
		
	}
	

}
