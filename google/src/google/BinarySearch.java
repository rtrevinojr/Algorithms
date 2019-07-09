package google;

public class BinarySearch {
	
	
	public static boolean binarySearch (int [] arr, int target) {
		
		int lo = 0;
		int hi = arr.length - 1;
		int mid = hi / 2 ;
		
		while (lo <= hi) {
			
			mid = lo + (hi - lo) / 2;
			
			if (arr[mid] == target) {
				return true;
			}
			else if (target > arr[mid]) {
				lo = mid + 1;
			}
			else {
				hi = mid - 1;
			}
		}
		return false;
	}
	
	
	public static int binarySearchRec (int [] arr, int target) {
		
		int lo = 0;
		int hi = arr.length - 1;
		
	
		return binarySearchHelper (arr, target, lo, hi);
		
	}
	
	public static int binarySearchHelper (int [] arr, int target, int lo, int hi) {
		
		int mid = lo + (hi - lo) / 2;
		
		if (lo > hi) {
			return -1;
		}
		else if (arr[mid] == target) {
			return mid;
		}
		else if (target > arr[mid]) {
			return binarySearchHelper (arr, target, mid + 1, hi);
		}
		else {
			return binarySearchHelper (arr, target, lo, mid - 1);
		}
	}
	
	public static void main (String [] args) {
		
		System.out.println("BinarySearch.java");
		
		
		/*
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		boolean result = binarySearch (a, 3);
		System.out.println("result = " + result);
		
		boolean result2 = binarySearch (a, 10);
		System.out.println("result2 = " + result2);
		*/
		
		int [] b = {1,2,3,4,5};
		assert binarySearch (b, 10);
		assert binarySearchRec (b, 10) == -1;
		
		int [] a2 = {1, 2, 3, 4, 5};
		assert binarySearch (a2, 0);
		assert binarySearchRec (a2, 0) == -1;
	
		
		int [] emptySet = {};
		boolean result5 = binarySearch(emptySet, 0);
		
		assert false;
		
		assert 0 == 9;
		
		assert binarySearch (emptySet, 0) == true;
		assert binarySearchRec (emptySet, 0) == 1;
		
		int [] singleSet = {1};	
		assert !binarySearch (singleSet, 0);
		assert binarySearchRec (singleSet, 0) == -1;
		
		int [] singleSetTrue = {1};	
		assert !binarySearch (singleSetTrue, 0);
		assert binarySearchRec (singleSetTrue, 0) == 0;
		
		int [] pairSet = {1, 2};
		assert !binarySearch (pairSet, 0);
		assert binarySearchRec (pairSet, 0) == -1;
		
		assert !binarySearch(pairSet, 1);
		
	}

}
