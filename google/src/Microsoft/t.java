package Microsoft;

public class t {

}


//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.*;
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{     
 int minDist = 10000;
 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
 {
     // WRITE YOUR CODE HERE
 
     for (int r = 0; r < numRows; r++) {
         for (int c = 0; c < numColumns; c++) {
             if (lot.get(r).get(c) == 1) {
                 removeObstacleHelper (numRows, numColumns, r, c, lot, 0);
             }
         }
     }
     
     return minDist;
 }
 // METHOD SIGNATURE ENDS
 void removeObstacleHelper (int numRows, int numColumns, int row, int col, List<List<Integer>> lot, int dist) {
     
     //System.out.println(lot.get(row).get(col));
     
     if (lot.get(row).get(col) == 1) {
         Integer value = -(lot.get(row).get(col));
         System.out.println(value);
         
         List <Integer> columns = lot.get(row);
         columns.add(col, value);
         lot.add(row, columns);
         
         if (row > 0 && col > 0)  
         removeObstacleHelper (numRows, numColumns, row - 1, col - 1, lot, ++dist);
         if (row < numRows - 1 && col < numColumns - 1)  
         removeObstacleHelper (numRows, numColumns, row + 1, col + 1, lot, ++dist);
         if (row > 0 && col < numColumns - 1)  
         removeObstacleHelper (numRows, numColumns, row - 1, col + 1, lot, ++dist);
         if (row < numRows - 1 && col > 0)  
         removeObstacleHelper (numRows, numColumns, row + 1, col - 1, lot, ++dist);
         if (row > 0)  
         removeObstacleHelper(numRows, numColumns, row - 1, col, lot, ++dist);
         if (row < numRows - 1)  
         removeObstacleHelper (numRows, numColumns, row + 1, col, lot, ++dist);
         if (col > 0) 
         removeObstacleHelper (numRows, numColumns, row, col - 1, lot, ++dist);
         if (col < numColumns - 1)  
         removeObstacleHelper (numRows, numColumns, row, col + 1, lot, ++dist);
         
     }
     else if (lot.get(row).get(col) == 9) {
         Integer value = -(lot.get(row).get(col));
         System.out.println(value);
         if (dist < minDist) minDist = dist;
     }
    
 }
 
}