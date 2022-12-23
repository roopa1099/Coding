package com.coding;

/**
 * Find element in a sorted matrix
 */
public class SearchIn2DMatrix {

    public static int[] seach(int[][] matrix,int n,int m,int search){
        int i=0,j=m-1;

        while(i<n && j>=0){
            if(matrix[i][j]==search)
            {
                int[] res={i,j};
                return res;
            }
//top right most has max value in that row and min value in the column
            else if(matrix[i][j]>search)
                j--;
           else
               i++;
        }
        int[] res={-1,-1};
        return res;
    }


    public static void main(String[] args){
        int[][] arr=new int[3][3];
        arr= new int[][]{{1, 4, 9},
                {2, 5, 10},
                {6, 7, 11}};
        int[] res=seach(arr,3,3,10);
        for(int i:res){
            System.out.println(i);
        }

    }
}
