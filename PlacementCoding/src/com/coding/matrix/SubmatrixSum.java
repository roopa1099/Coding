package com.coding.matrix;


/**
 * 28 Dec
 * Given an M × N integer matrix and two coordinates (p, q) and (r, s) representing top-left and bottom-right coordinates of a submatrix of it, 
 * calculate the sum of all elements present in the submatrix. Here, 0 <= p < r < M and 0 <= q < s < N
 */
public class SubmatrixSum {
    

    private static int[][] prefixSumMatrix(int[][] matrix){


        int[][] prefixMatrix=new int[matrix.length][matrix[0].length];

        prefixMatrix[0][0]=matrix[0][0];

        // set 1st row from 0,0
        for(int col=1;col<matrix[0].length;col++){
            prefixMatrix[0][col]=prefixMatrix[0][col-1]+matrix[0][col];
        }

         // set 1st col from 0,0
        for(int row=1;row<matrix.length;row++){
            prefixMatrix[row][0]=prefixMatrix[row-1][0]+matrix[row][0];
        }

        // Setting sum for rest value from 0,0
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                prefixMatrix[i][j]=(prefixMatrix[i][j-1]+prefixMatrix[i-1][j]-prefixMatrix[i-1][j-1])+matrix[i][j];
            }
        }

        return prefixMatrix;
        
    }
   public static int sumOfSubmatrix(int[][] matrix,int p,int q, int r, int s) {

    // (p,q) (r,s)

    int[][]prefixMatrix=prefixSumMatrix(matrix);

    int sum=prefixMatrix[r][s]-(prefixMatrix[r][q-1]+prefixMatrix[p-1][s]-prefixMatrix[p-1][q-1]);

    return sum;  
    }
    public static void main(String[] args) {
        int[][] mat =
        {
            { 0, 2, 5, 4, 1 },
            { 4, 8, 2, 3, 7 },
            { 6, 3, 4, 6, 2 },
            { 7, 3, 1, 8, 3 },
            { 1, 5, 7, 9, 4 }
        };

       System.out.println(sumOfSubmatrix(mat, 1, 1, 3, 3));
    }
}
