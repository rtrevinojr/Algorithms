package playground;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

	List <ArrayList <Integer>> powerSet = null;
	
	public PowerSet () {
		powerSet = new ArrayList <ArrayList <Integer>> ();
	}
	
	public void getPowerSet (ArrayList <Integer> set) {
		
		int [] result = new int [set.size()];
		
		getPowerSetHelperX (set, result, 0);
	}	
	
	public void getPowerSetHelper (ArrayList <Integer> set, ArrayList <Integer> result) {
		
		if (!result.isEmpty()) {
			powerSet.add(new ArrayList<>(result));
		}
		
		for (int i = 0; i < set.size(); i++) {
			
			Integer val = set.get(i);
			set.remove(val);
			result.add(val);
			getPowerSetHelper (set, result);
		}
		
	}
	
	public void getPowerSetHelperX (ArrayList <Integer> set, int [] result, int len) {
		
		if (len > 0) {
			powerSet.add(makeList (result, len));
		}
		for (int i = 0; i < set.size(); i++) {
			
			Integer val = set.get(i);
			set.remove(i);
			powerSet.add(new ArrayList <>(set));
			result[len] = val;
			len++;
			//printArray(result, len);
			getPowerSetHelperX (set, result, len);
			//set.add(val);
		}
		
	}
	
	public static ArrayList <Integer> makeList (int [] arr, int len) {
		
		ArrayList <Integer> result = new ArrayList <Integer> ();
		for (int i = 0; i < len; i++) {
			result.add(arr[i]);
		}
		return result;
	}
	
	/*
	 * Runtime Complexity - O(n*2^n)
	 */
	public static ArrayList <ArrayList <Integer>> getSubsetsX (ArrayList <Integer> set) {
		
		ArrayList <ArrayList <Integer>> result = new ArrayList <ArrayList <Integer>> ();
		
		int max = 1 << set.size();
		
		for (int k = 0; k < max; k++) { // O(2^n)
			ArrayList <Integer> subset = convertIntToSet (k, set); // O(n)
			result.add(subset); // O(1)
		}
		return result;
	}
	
	/*
	 * 
	 * RuntimeComplexity - O(n)
	 */
	public static ArrayList <Integer> convertIntToSet (int k, ArrayList <Integer> set) {
		
		ArrayList <Integer> result = new ArrayList <> ();
		int index = 0;
		for (int i = k; i > 0; i >>= 1) { // O(n)
			if ((i & 1) == 1) {
				result.add(set.get(index)); // O(1)
			}
			index++;
		}
		return result;
	}
	
	public static ArrayList <ArrayList <Integer>> getSubsets (ArrayList <Integer> set, int index) {
		
		ArrayList <ArrayList <Integer>> result;
		
		if (set.size() == index) {
			result = new ArrayList <ArrayList <Integer>> ();
			result.add(new ArrayList <Integer> ());
		}
		else {
			result = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList <ArrayList <Integer>> moreSubsets = new ArrayList <ArrayList<Integer>> ();
			for (ArrayList <Integer> subset : result) {
				ArrayList <Integer> newSubset = new ArrayList <>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			result.addAll(moreSubsets);
		}
		return result;
	}
	
	public void printPowerSet () {
		
		for (ArrayList <Integer> entry : this.powerSet) {
			System.out.println(entry.toString());
		}
	}
	
	public static void printArray (int [] arr, int len) {
		
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main (String [] args) {
		
		System.out.println("PowerSet.java");
		
		ArrayList <Integer> set = new ArrayList <>();
		set.add(1);
		set.add(2);
		set.add(3);
		
		//PowerSet pset = new PowerSet ();
		
		ArrayList <ArrayList <Integer>> powerset = getSubsetsX(set);
		
		System.out.println("Power set size = " + powerset.size());
		
		System.out.println(powerset.toString());
		
		//pset.getPowerSet(set);
		
		//pset.printPowerSet();
		
	}
}
