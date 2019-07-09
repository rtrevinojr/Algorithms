package sorting;

public class QuickSortTest {
	
	public static void testIsSorted () {
		
		int [] a = {1, 2, 5, 4, 9};
		assert !isSorted(a);
	}
	
	public static void testIsSortedEmpty () {
		assert isSorted(new int [] {});
	}
	public static void testIsSortedSingle () {
		assert isSorted(new int [] {1});
	}
	public static void testIsSortedPair () {
		assert isSorted (new int [] {1, 2});
	}
	public static void testNotSortedPair () {
		assert !isSorted (new int [] {2, 1});
	}
	
	public static void testQuick () {
		
		int [] a = {1, 3, 8, 2, 7, 4, 6, 5};	
		Partition.sort(a);
		assert isSorted(a);
	}
	
	public static void testQuickEmpty () {
		int [] a = new int [0];
		Partition.sort(a);
		assert isSorted(a);
	}
	
	public static void testQuickSingle () {
		int [] a = {1};
		Partition.sort(a);
		assert isSorted(a);
	}
	
	public static void testQuickPair () {
		int [] a = {1, 2};
		Partition.sort(a);
		assert isSorted(a);
	}
	
	public static void testQuickTriple () {
		int [] a = {5, 3, 8};
		Partition.sort(a);
		assert isSorted(a);
	}
	
	public static void testQuickOdd () {
		
		int [] a = {1, 3, 8, 2, 7, 4, 6, 5, 9, 10, 12};	
		Partition.sort(a);
		assert isSorted(a);
	}
	
	public static void testQuickLowPivot () {
		
		int [] a = {1, 3, 8, 2, 7, 4, 6, 5, 9, 12, 0};	
		Partition.sort(a);
		assert isSorted(a);
	}
	
	public static void testQuickHighPivot () {
		
		int [] a = {1, 3, 8, 2, 7, 4, 6, 5, 9, 10};	
		Partition.sort(a);
		assert isSorted(a);
	}
	
	public static void testQuickHighPivotOdd () {
		
		int [] a = {1, 3, 8, 2, 7, 4, 6, 5, 9};	
		Partition.sort(a);
		assert isSorted(a);
	}
	
	
	public static boolean isSorted (int [] arr) {
		for (int i = 1; i < arr.length; i++) 	
			if (arr[i] > arr[i - 1]) return false;
		return true;
	}
	
	
	
	
	public static void main (String [] args) {
		
		System.out.println("QuickSortTest");
		
		testIsSorted ();
		testIsSortedEmpty ();
		testIsSortedSingle ();
		testIsSortedPair ();
		testNotSortedPair ();
		
		testQuick ();
		
		testQuickEmpty ();
		testQuickSingle ();
		testQuickPair ();
		testQuickTriple ();

		testQuickLowPivot ();
		testQuickOdd ();
		testQuickHighPivot();
		testQuickHighPivotOdd();
		

	}

}
