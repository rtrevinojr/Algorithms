package sorting;

public class HeapSort {
	
	
	
	public static void sink (int [] arr, int k, int n) {
		
		while (2*k <= n) {
			
			int j = 2 * k;
			
			if (j < n) {
				if (arr[j-1] < arr[j]) j++;
			}
			if (arr[k-1] < arr[j-1]) {
				int tmp = arr[k-1];
				arr[k-1] = arr[j-1];
				arr[j-1] = tmp;
			}
			else {
				break;
			}
			
			k = j;
		}
	}
	
	private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }
	
	private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            //StdOut.println(a[i]);
        	System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    private static void show(int [] a) {
        for (int i = 0; i < a.length; i++) {
        	System.out.print(a[i] + " ");
        }
        System.out.println();
    }
	
	
	public static void main (String [] args) {
		System.out.println("HeapSort.java");
		
		//int [] a1 = {2, 5, 4, 7, 9, 8, 9};
		
		int [] a2 = {5, 3, 6, 7, 8, 2, 1};
		
		Comparable [] c1 = {5, 3, 6, 7, 8, 2, 1};
		
		sink (a2, 3, 7);
		
		show (a2);
		
		sink (a2, 2, 7);
		
		show(a2);
		
		sink (c1, 3, 7);
		sink (c1, 2, 7);
		
		show (c1);
		
	}

}
