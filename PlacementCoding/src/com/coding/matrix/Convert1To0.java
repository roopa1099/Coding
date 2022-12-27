package com.coding.matrix;

/**
 * 27 Dec
 * Given an M × N matrix consisting of only 0 or 1, change all elements of row i and column j
 *  to 0 if cell (i, j)
 *  has value 0. Do this without using any extra space for every (i, j) having value 0.
 */
public class Convert1To0 {

    public static void convertMatrix(int[][] matrix) {

        boolean row_flag=false,col_flag=false;

        // check if any element in 1st row is 0
        int row=0;
        for(int col=0;col<matrix[0].length;col++){
            if(matrix[row][col]==0){
                row_flag=true;
                break;
            }
        }
        
     // check if any element in 1st col is 0
        int col=0;
        for(row=0;row<matrix.length;row++){
            if(matrix[row][col]==0){
                col_flag=true;
                break;
            }
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;                    
                }
            }
        }


        if(row_flag){
            for(int c=0;c<matrix[0].length;c++){
                matrix[0][c]=0;
            }
        }

        if(col_flag){
            for(int r=0;r<matrix.length;r++){
                matrix[r][0]=0;
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }


    }
    
    public static void main(String[] args) {
        int[][] mat =
        {
            { 1, 1, 0, 1, 1 },
            { 1, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1 },
            { 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1 }
        };

        convertMatrix(mat);
    }
}
