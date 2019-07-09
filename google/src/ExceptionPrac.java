
import java.util.*;

public class ExceptionPrac {
	
	
	
	public static void testPrimitiveArray () {
		
		int [] arr = new int [10];
		
		String [] strArr = new String [10];
		
		String y = null;
		
		int x = 0;
		
		if (strArr.length > 8) {
			
			x = 1;
			y = strArr[9];
		}
		
		System.out.println(x + " " + y);
	}
	
	
	public static void testObjectParams2 (TreeMap <Integer, String> treeMap) {
		

		
		treeMap.put(1, "one");
		treeMap.put(2, "two");
		treeMap.put(0, "zero");
		
		//testObjectUpdate(treeMap);
		
		System.out.println(treeMap.toString());
		
		System.out.println("end of test...");
		
	}
	
	
	public static void testObjectParams () {
		
		TreeMap <Integer, String> treeMap = new TreeMap <> ();
		
		treeMap.put(1, "one");
		treeMap.put(2, "two");
		treeMap.put(0, "zero");
		
		//testObjectUpdate(treeMap);
		
		System.out.println(treeMap.toString());
		
		System.out.println("end of test...");
		
	}
	
	public static void testObjectUpdate (TreeMap <Integer, String> map) {
		
		System.out.println("test...");
		
		map.put(5, "five");
		map.put(4, "four");
	}
	
	
	public static void testException () {
		
		System.out.println("test method");
		
		try {
			
			System.out.println("try");
			throw new Exception ();
		}
		catch (Exception e) {
			System.out.println("catch Exception");
		}
		finally {
			System.out.println("finally");
		}
		System.out.println("End of method");
		
	}
	
	public static void main (String [] args) {
		System.out.println("ExceptionPrac....");
		
		//testException();
		
//		TreeMap <Integer, String> map = new TreeMap <> ();
//		
//		testObjectParams2 (map);
//		
//		testObjectUpdate (map);
//		
//		System.out.println(map.toString());
		
		testPrimitiveArray();
		
		System.out.println("End...");
		
	}

}
