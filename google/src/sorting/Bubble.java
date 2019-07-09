package sorting;

public class Bubble {

	public static void insertionSort (int [] arr) {
		int totalExchanges = 0;
		int totalIterations = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				totalIterations++;
				if (arr[j] < arr[j - 1]) {
					swap (arr, j, j - 1);
					totalExchanges++;
				}
				else {
					break;
				}
			}
		}
		System.out.println("Exchanges = " + totalExchanges);
		System.out.println("Iterations = " + totalIterations);
	}
	
	public static void bubbleSort (int [] arr) {
		int totalIterations = 0;
		int totalExchanges = 0;
		int exchanges = 0;
		for (int i = 0; i < arr.length; i++) {	
			exchanges = 0;
			for (int j = arr.length - 1; j > i; j--) {
				totalIterations++;
				if (arr[j] < arr[j - 1]) {
					swap (arr, j, j - 1);
					exchanges++;
					totalExchanges++;
				}
			}
			if (exchanges == 0) break;
		}
		System.out.println("BubbleSort Exchanges = " + totalExchanges);
		System.out.println("Iterations = " + totalIterations);
	}
	
	public static void swap (int [] arr, int i, int j) {
		
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void printArray (int [] arr) {
		
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("BubbleSort...");
		
		int [] test1 = {5, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		printArray(test1);
		
		int [] test2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		Bubble.insertionSort(test1);
		
		printArray(test1);
		
		int [] test11 = {5, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		Bubble.bubbleSort(test11);
		
		printArray(test11);
	}
}
