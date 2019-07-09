package playground;

public class MoveZeros {

	
	public static int [] moveZeros (int [] arr) {
		
		int lead = 0;
		int trailer = arr.length - 1;
		
		while (lead <= trailer) {
			
			while (arr[lead] != 0) {
				lead++;
				if (lead >= trailer) break;
			}
			while (arr[trailer] == 0) {
				trailer--;
				if (lead >= trailer) break;
			}
			if (lead < trailer) {
				swap(arr, lead, trailer);
			}
		}
		return arr;
	}
	
	public static void swap (int [] arr, int i, int j) {
		
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void printArray(int [] arr) {
		for (int i : arr) 
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void main (String [] args) {
		
		System.out.println("MoveZeros.java");
		
		int [] test1 = {1, 0, 2, 0, 3};
		
		int [] result1 = moveZeros(test1);
		
		printArray(result1);
		
		
		int [] test2 = {1, 0};
		printArray(moveZeros(test2));
		
		int [] test3 = {0, 1};
		printArray(moveZeros(test3));
		
		int [] test4 = {0};
		printArray(moveZeros(test4));
		
		int [] test5 = {1};
		printArray(moveZeros(test5));
		
		int [] test6 = {};
		printArray(moveZeros(test6));
		
		int [] test7 = {0, 0, 0, 0, 1, 2, 0, 0, 3, 0, 5, 6, 0, 7, 0};
		printArray(moveZeros(test7));
		
		int [] test8 = {0, 0, 0, 0, 0};
		printArray(moveZeros(test8));
		
		int [] test9 = {1, 1, 1, 1, 1};
		printArray(moveZeros(test9));
		
		int [] test10 = {0, 1, 1, 1, 1};
		printArray(moveZeros(test10));
		
		
		
		
		
	}
}
