package com.coding.matrix;

/**
 * 26Dec
 * Given an M × N integer matrix, print it in spiral order.
 */
public class SpiralPrint {
    
    public static void spiralMatrix(int[][] matrix, int down, int top, int right, int left){

        if(left>right)
            return;
        // top covered
        for(int i=left;i<=right;i++)
            System.out.println(matrix[top][i]+" ");
        top++;

        if(top>down)
        return;

        // right covered
        for(int i=top;i<=down;i++)
            System.out.println(matrix[i][right]+" ");
        right--;

        if(left>right)
             return;
        // bottom cover
        for(int i=right;i>=left;i--)
            System.out.println(matrix[down][i]+" ");
        down--;

        if(top>down)
           return;
        // left cover
        for(int i=down;i>=top;i--)
            System.out.println(matrix[i][left]);
        left++;

        spiralMatrix(matrix, down, top, right, left);

    }

    public static void main(String[] args){
        int[][] matrix={{1,2,3,4,5},{16,17,18,19,6}, {15, 24, 25, 20, 7},{14, 23, 22, 21, 8},{13, 12, 11, 10, 9}};
        spiralMatrix(matrix, matrix.length-1, 0, matrix[0].length-1, 0);

    }
}
