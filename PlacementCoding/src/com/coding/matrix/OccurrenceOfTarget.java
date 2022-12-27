package com.coding.matrix;

/** 
 * 27Dec
 * Given an M × N matrix, which is row-wise and column-wise sorted (with all strictly increasing
 *  elements in any row or column), 
 * report all occurrences of a given element in it in linear time.
 */
public class OccurrenceOfTarget {
    
    public static int occurenceOfNumber(int[][] matrix, int target){
        int row=0, col=matrix[0].length-1;
        int occurrence=0;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target){
                occurrence++;
                col--;  
                row++;
            }
            else if(matrix[row][col]>target){
                col--;
            }
            else{
                row++;
            }
        }

        return occurrence;
        
    }

    public static void main(String[] args) {
        int[][] matrix={{-4,-3,-1,3,5},{-3,-2,2,4,6},{-1,1,3,5,8},{3,4,7,8,9}};
        System.out.println(occurenceOfNumber(matrix, 3));
    }
}
