package com.coding.matrix;

/**
 * 28 Dec
 * Given an M × N matrix, check if it is a Toeplitz matrix or not. A Toeplitz matrix or diagonal-constant 
 * matrix is a matrix in which each descending diagonal from left to right is constant.
 */
public class ToeplitzClass {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        
        for(int row=1;row<matrix.length;row++){
            for(int col=1;col<matrix[0].length;col++){
                if(matrix[row][col]!=matrix[row-1][col-1]){
                    return false;
                }
            }
        }

        return true;
    }
    
    public static void main(String[] args) {

        int[][] mat={{1,2,3,4},{5,1,2,3},{6,5,1,2},{7,6,5,1}};
        System.out.println(isToeplitzMatrix(mat));
        
    }
}
