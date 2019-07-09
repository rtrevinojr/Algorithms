package sorting;

public class QuickSort {
	
	
	// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) { 

            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            //StdOut.println(a[i]);
        	System.out.println(a[i]);
        }
    }
    
    
    
    /* This function takes last element as pivot, 
    places the pivot element at its correct 
    position in sorted array, and places all 
    smaller (smaller than pivot) to left of 
    pivot and all greater elements to right 
    of pivot */
    public static int partition2(int arr[], int low, int high) { 
     
    	int pivot = arr[high];  
    	int i = (low-1); // index of smaller element 
    	for (int j=low; j<high; j++) { 
         // If current element is smaller than or 
         // equal to pivot 
    		if (arr[j] <= pivot) { 
             
    			i++; 

	             // swap arr[i] and arr[j] 
	             int temp = arr[i]; 
	             arr[i] = arr[j]; 
	             arr[j] = temp; 
         } 
     } 

	     // swap arr[i+1] and arr[high] (or pivot) 
	     int temp = arr[i+1]; 
	     arr[i+1] = arr[high]; 
	     arr[high] = temp; 
	
	     return i+1; 
 } 


 /* The main function that implements QuickSort() 
   arr[] --> Array to be sorted, 
   low  --> Starting index, 
   high  --> Ending index */
 	public static void sort2(int arr[], int low, int high) { 
     
 		if (low < high) { 
	         /* pi is partitioning index, arr[pi] is  
	           now at right place */
	         int pi = partition2(arr, low, high); 
	
	         // Recursively sort elements before 
	         // partition and after partition 
	         sort2(arr, low, pi-1); 
	         sort2(arr, pi+1, high); 
     	} 
 	} 
	
	public static void main (String [] args) {
		
		System.out.println("QuickSort.java");
		
		String [] a = {"a", "f", "g", "c", "b" };
		
		int  [] x = {6, 3, 8, 2, 7, 4, 1, 5};
		
		int p = partition2(x, 0, 7);
		
		System.out.println("pivot = " + p);
		//show (x);
		
		for (int i: x) System.out.println(i);
		System.out.println();
		
		
		/*int [] x2 = {2, 3, 1, 5, 4};
		
		sort2 (x, 0, 4);
		for (int i: x) System.out.println(i);
		System.out.println();*/
		
		/*
		Integer [] y = {3, 5, 4};
		
		int p2 = partition (y, 0, 2);
		
		System.out.println("pivot 2 = " + p2);
		
		show(y);
		
		Integer [] z = {5, 4};
		
		int p3 = partition (z, 0, 1);
		System.out.println("pivot 3 = " + p3);
		
		show (z);
		*/
		
		//QuickSort.sort(a);
        //show(a);
        //assert isSorted(a);

        // shuffle
        //StdRandom.shuffle(a);
	}

}
