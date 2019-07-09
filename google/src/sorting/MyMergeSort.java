package sorting;

public class MyMergeSort {

	
	public int [] sort (int [] arr) {
		
		if (arr.length <= 1) {
			return arr;
		}
		
		int mid = arr.length / 2;
		
		int [] left = new int [mid];
		int [] right = new int [arr.length - mid];
		
		int indexL = 0;
		int indexR = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			if (i < mid) 
				left [indexL++] = arr[i];
			else 
				right [indexR++] = arr[i];
		}
		
		return merge (sort(left), sort(right));
		
	}
	
	public int [] merge (int [] arr1, int [] arr2) {
		
		int [] result = new int [arr1.length + arr2.length];
		
		int index1 = 0;
		int index2 = 0;
		
		for (int i = 0; i < arr1.length + arr2.length; i++) {
			
			if (index1 > arr1.length - 1) 
				result[i] = arr2[index2++];
			else if (index2 > arr2.length - 1) 
				result[i] = arr1[index1++];
			else if (arr1[index1] < arr2[index2])
				result[i] = arr1[index1++];
			else 
				result[i] = arr2[index2++];
		}
		return result;
	}
	
	public static void printArray (int [] arr) {
		
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
	
	public static void main (String [] args) {
		
		System.out.println("MyMergeSort");
		
		int [] arr = {2, 3, 1, 8, 3, 9, 4, 7};
		
		MyMergeSort mergeSort = new MyMergeSort();
		
		int [] result = mergeSort.sort(arr);
		
		printArray(arr);
		
		printArray(result);
		
	}
}
