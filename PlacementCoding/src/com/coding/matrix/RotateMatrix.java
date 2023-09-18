package com.coding.matrix;

/**
 *"You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation."
 */
public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        /**
         *rotating clockwise and swap
         * Brute force: Take a new matrix, [j],[n-1-i]
         */

        int row=0,column=0;
        while(row<matrix.length/2){
            for(column=0;column<matrix[0].length;column++){
                int temp=matrix[row][column];
                matrix[row][column]=matrix[matrix.length-1-row][column];
                matrix[matrix.length-1-row][column]=temp;
            }
            row++;
        }

        for(int i=0;i<matrix.length;i++){
            int j=i;
            while(j<matrix[0].length){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
                j++;
            }
        }

    }

    public static void main(String[] args){
        int[][] array={{1,2,3},{4,5,6},{7,8,9}};
        rotate(array);
    }
}
