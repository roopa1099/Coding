package com.coding.matrix;

/**
 * 27 Dec
 * Given an M × N integer matrix, print all its diagonal elements having a positive slope.
 */
public class PositiveSlopeELements {


    public static void printElements(int[][] matrix) {
        
        int row_max=matrix.length,col_max=matrix[0].length;

        int col=0;

        while(col<col_max){
            int row=0,j=col;
            while(j>=0){
                System.out.print(matrix[row][j]+" ");
                row++;
                j--;
            }
            col++;
            System.out.println();
        }

        int row=1;
        while(row<row_max){
            int column=col_max-1,j=row;
            while(j<row_max){
                System.out.print(matrix[j][column]+" ");
                j++;
                column--;
            }
            row++;
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{2,3,4,5},{3,4,5,6},{4,5,6,7}};
        printElements(matrix);
       
    }
    
}
