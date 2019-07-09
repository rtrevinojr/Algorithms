package Microsoft;

import java.util.List;

public class Solution {
	
	void printRepeating(int arr[], int size) 
    { 
        int i;   
        System.out.println("The repeating elements are : "); 
     
        for (i = 0; i < size; i++) 
        { 
            if (arr[Math.abs(arr[i])] >= 0) 
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])]; 
            else
                System.out.print(Math.abs(arr[i]) + " "); 
        }          
    }  
	
	public static void test (List <List <Integer>> list) {
		
		l
		
		list.add()
	}
  
    // Driver program  
    public static void main(String[] args) { 
        Solution duplicate = new Solution(); 
        int arr[] = {1, -2, -3, 1, 3, 6, 6, -2, 22}; 
        int arr_size = arr.length; 
  
        duplicate.printRepeating(arr, arr_size); 
    }
	


}
