package sorting;

public class MergeSort {
	
	
	
	public static int [] sort (int [] input) {
		
		if (input.length == 1) {
			return input;
		}
		
		int mid = input.length / 2;
		
		int [] A = new int [mid];
		int [] B = new int [input.length - mid];
		
		int indexA = 0;
		int indexB = 0;
		
		for (int i = 0; i < input.length; i++) {
			
			if (i < mid) {
				A[indexA] = input[i];
				indexA++;
			}
			else {
				B[indexB] = input[i];
				indexB++;
			}
		}
		
		int [] recA = sort(A);
		int [] recB = sort(B);
		
		return merge(recA, recB);
	}
	
	
	public static int [] merge (int [] A, int [] B) {
			
		int [] result = new int [A.length + B.length];	
		int indexA = 0;
		int indexB = 0;
		
		for (int i = 0; i < result.length; i++) {	
			if (indexA >= A.length) {
				result[i] = B[indexB++];
			}
			else if (indexB >= B.length) {
				result[i] = A[indexA++];
			}
			else if (A[indexA] > B[indexB]) {
				result[i] = B[indexB++];
			}
			else {
				result[i] = A[indexA++];
			}
		}
		return result;	
	}
	
	public static boolean isSorted (int [] input) {
		
		for (int i = 1; i < input.length; i++) {
			if (input[i] < input[i - 1]) return false;
		}
		return true;
	}
	
	public static void main (String [] args) {
		
		System.out.println("main...");
		
		int [] A = {1, 3, 5, 7, 9, 11, 12, 13};
		int [] B = {1, 2, 3, 4, 5};
		
		int [] result1 = merge(A, B);
		
		for (int i : result1) {
			System.out.println(i);
		}
		
		System.out.println("Result = " + isSorted(result1));
		
		System.out.println();
		
		int [] test1 = { 3, 5, 2, 6, 2, 9, 1};
		
		int [] result2 = sort(test1);
		
		for (int i : result2) {
			System.out.println (i);
		}
		
	}

}
