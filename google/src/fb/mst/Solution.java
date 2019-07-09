package fb.mst;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    
    public static void printArr (int [] arr) {
        for (int i: arr) {
            System.out.print(i);
        }
        System.out.println();
    }
    

    public static void insertIntoSorted(int[] ar) {
        // Fill up this function  
    	
        Scanner scan = new Scanner (System.in);
        int size = scan.nextInt();
        System.out.println("size = " + size);
        int [] arr = new int [size];
        int e = 0;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                e = scan.nextInt();
                        System.out.println("e = " + e);

                arr[i] = e;
            }
            else {
                arr[i] = scan.nextInt();
                        System.out.println("arr[i] = " + arr[i]);

            }
        }
        
        for (int i = size - 2; i > 0; i--) {
            if (arr[i] > e) {
                arr[i+1] = arr[i];
            }
            else {
                arr[i] = e;
            }
            printArr(arr);
        }
        
    }
    
    
/* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
        }
        insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
 

