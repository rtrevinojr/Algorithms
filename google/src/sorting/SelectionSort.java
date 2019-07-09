package sorting;

import java.util.Random;

public class SelectionSort {
	
	
	public static void bubbleSort (int [] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = arr.length - 1; j > i; j--) {
				
				if (arr[j] > arr[j - 1]) {
					swap (arr, j, j - 1);
				}
				
			}
		}
	}
	
	public static void swap (int [] arr, int i, int j) {
		
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void insertionSort (int [] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			
			for (int j = i; j > 0; j--) {
				
				if (arr[j] < arr[j - 1]) {
					
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
				else {
					break;
				}
			}
		}
		
		
	}
	
	
	public static void selectionSort (int [] arr) {
		
		
		for (int i = 0; i < arr.length; i++) {
			
			int min = arr[i];
			int minIndex = i;
			
			for (int j = i; j < arr.length; j++) {
				
				if (arr[j] < min) {
					min = arr[j];
					minIndex = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			
		}
	}
	
	
	public static int [] generateRandomArray (int N) {
		
		int [] result = new int [N];
		for (int i = 0; i < N; i++) {
			int num = generateRandomIntIntRange(0, 10);
			result[i] = num;
		}
		return result;
	}
	
	public static int generateRandomIntIntRange(int min, int max) {
	    Random r = new Random();
	    return r.nextInt((max - min) + 1) + min;
	}
	
	public static String printArray (int [] arr) {
		
		String result = "";
		
		for (int i : arr) {
			result += i + " - ";
			
		}
		return result;
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("SelectionSort.java");
		
		int [] test1 = generateRandomArray(10);
		
		int [] insertTest1 = test1.clone();
		
		System.out.println("Random array 1 = " + printArray(test1));
		
		SelectionSort.selectionSort(test1);
		
		System.out.println("Selection Sorted array 1 = " + printArray(test1));
		
		SelectionSort.insertionSort(insertTest1);
		
		System.out.println("Insertion Sorted array 1 = " + printArray(insertTest1));
		
		int [] test2 = generateRandomArray(11);
		
		int [] insertTest2 = test2.clone();
		
		System.out.println("Random array 2 = " + printArray(test2));
		
		SelectionSort.selectionSort(test2);
		
		System.out.println("Selection Sorted array 2 = " + printArray(test2));
		
		SelectionSort.insertionSort(insertTest2);
		
		System.out.println("Insertion Sorted array 2 = " + printArray(insertTest2));
		
		
	}

}
