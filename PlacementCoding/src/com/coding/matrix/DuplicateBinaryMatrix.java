package com.coding.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 28 Dec
 * Find duplicate rows present in a given binary matrix by traversing the matrix only once.
 */

public class DuplicateBinaryMatrix {

    private static double binaryToDecimal(int[] array) {
        int i=array.length-1,pow=0;

        double sum=0;
        while(i>=0){
            sum=sum+(array[i]*Math.pow(2,pow));
            i--;
            pow++;
        }

        return sum; 
    }

    public static List<Integer> duplicateRow(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        Set<Double> sumSet=new HashSet<>();

        for(int i=0;i<matrix.length;i++){
            double binary=binaryToDecimal(matrix[i]);
            if(sumSet.contains(binary)){
                result.add(i+1);
            }
            else{
                sumSet.add(binary);
            }
        }
        return result;
    }
    

    public static void main(String[] args) {

        int mat[][] =
        {
            {1, 0, 0, 1, 0},
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 1, 0, 0}
        };

        System.out.println(duplicateRow(mat));
        
    }
}
