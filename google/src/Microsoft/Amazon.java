package Microsoft;

import java.util.LinkedList;
import java.util.List;

public class Amazon {
	
	public List<Integer> cellCompete(int[] states, int days) {
        // WRITE YOUR CODE HERE
        
        List <Integer> result = new LinkedList <>();
            
        if (states.length == 0) return result;
        
        
        while (days >= 0) {
            
            result = new LinkedList <>();
        
            if (states.length == 1) {
                result.add(states[0]);
                return result;
            }
            
            if (states.length == 2) {
                int first = states[0];
                int last = states[1];
                if (last == 1) states[0] = 0;
            }
            
            
        
            int [] temp = new int [states.length];
            for (int i = 0; i < states.length; i++) {
                temp[i] = states[i];
            }
        
            int first = temp[0];
            int last = temp[states.length - 1];
        
            
            
            for (int i = 1; i < states.length - 1; i++) {
                
                int before = temp[i - 1];
                int after = temp[i + 1];
                if (before == after) {
                    states[i] = 0;
                }
                else {
                    states[i] = 1;
                }
            }
        
        days--;
        
        }
        
        
        for (int i : states)
            result.add(i);
        
        return result;
    
    }

	
	public int gcd (int num, int [] arr) {
		
		if (arr.length == 0) return 0;
		if (arr.length == 1) return arr[0];
		
		int min = arr[0];
		for (int i: arr) 
			if (i < min) min = i;
		
		
		System.out.println("min = " + min);
		
		boolean gcd = true;
		
		while (min > 0) {
			for (int i : arr) {
				if (i % min != 0) {
					gcd = false;
					break;
				}
			}
			if (gcd) return min;
			else min--;
		}
		
		return 1;
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("main");
		
		int [] test = {6, 9, 12};
		
		Amazon amazon = new Amazon();
		
		int result = amazon.gcd(4, test);
		
		System.out.println(result);
		
	}
	
}
