package Microsoft;

import java.util.*;
import java.lang.*;

public class Practice {

	
	public static class IntPoint {
		
		int x;
		int y;
		
		public IntPoint (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	public boolean hasMidPoint (IntPoint [] arr) {
		
		HashSet <IntPoint> set = new HashSet <> ();
		
		for (IntPoint point : arr) {
			set.add(point);
		}
		
		for (IntPoint point : arr) {
			for (IntPoint p : arr) {
				//if (arr.contains())
			}
		}
		
		return true;
		
	}
	
	public static void test (IntPoint [] arr) {
		
		HashSet <IntPoint> set = new HashSet <> ();
		
		HashMap <IntPoint, String> map = new HashMap <> ();
		
		IntPoint point = new IntPoint (1, 2);
		
		set.add(point);
		set.add(new IntPoint (1, 2));
		
		boolean present = set.contains(point);
		
		System.out.println("Hashset contains " + present);
		
		map.put(point, "(1, 2)");
		map.put(new IntPoint(1, 2), "new IntPoint(1, 2)");
		
		System.out.println("HashMap contains = " + map.containsKey(new IntPoint (1, 2)));
		
		
		//HashMap <Coord, String> coordMap = new HashMap <> ();
		
		
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("Practice.java");
		
		IntPoint p1 = new IntPoint (1, 1);
		IntPoint p2 = new IntPoint (2, 2);
		IntPoint p3 = new IntPoint (3, 3);
		
		IntPoint [] arr = new IntPoint [] {p1, p2, p3};
		
		test (arr);
		
	}
}
