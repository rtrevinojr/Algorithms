package practice;

import java.io.*;
import java.util.*;

class Solution {

  static double root(double x, int n) {
      // your code goes here
    if (x == 0) {
      return 0;
    }
    
    double lowerBound = 0;
    double upperBound = Math.max(1, x);
    double approxRoot = (upperBound - lowerBound) / 2;
    
    double difference = approxRoot - lowerBound;
    
    while (approxRoot - lowerBound >= 0.001) {
    	
      double power = Math.pow(approxRoot, n);
      
      if (power > x) {
        upperBound = approxRoot;
      }
      else if (power < x) {
        lowerBound = approxRoot;
      }
      else break;
      
      approxRoot = (upperBound + lowerBound) / 2;
    }
    
    return approxRoot;
  }
  
  static double rootX (double x, int n) {
    
    if (x == 0) {
      return 0;
    }
    
    double lowerBound = 0;
    double upperBound = Math.max(1, x);
    double approxRoot = (upperBound - lowerBound) / 2;
    
    while (approxRoot - lowerBound >= 0.001) {
      
      if (Math.pow(approxRoot, n) > x) {
        upperBound = approxRoot;
      }
      else if (Math.pow(approxRoot, n) < x) {
        lowerBound = approxRoot;
      }
      else break;
      
      approxRoot = (upperBound - lowerBound) / 2;
    }
    
    return approxRoot;
    
    
  }

  public static void main(String[] args) {

    
    double num = 16.0;
    int n = 3;
    double result = root(num, n);
    
    System.out.println(result );
  }

}
