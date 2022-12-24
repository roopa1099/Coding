package com.coding.day0;

/**
 * Array Products
 * Implement a function that takes in a vector of integers, and
 * returns a vector of the same length, where each element in the output
 * array is equal to the product of every other number in the
 * input array. Solve this problem without using division.
 *
 * In other words, the value at output[i] is equal to the product of
 * every number in the input array other than input[i]. You can assume
 * that answer can be stored inside int datatype and no-overflow will
 * occur due to products.
 *
 * Sample Input
 *
 * Both inputs and outputs are vectors.
 *
 * {1,2,3,4,5}
 * Sample Output
 *
 * {120, 60, 40, 30, 24}
 */

public class ArrayProductsWithoutDivision {

    public static int[] findProd(int[] array){
        int[] prefixArray=new int[array.length];
        int[] suffixArray=new int[array.length];

        prefixArray[0]=array[0];
        suffixArray[array.length-1]=array[array.length-1];

        for(int i=1;i<array.length;i++){
            prefixArray[i]=prefixArray[i-1]*array[i];
        }

        for(int i=array.length-2;i>=0;i--){
            suffixArray[i]=suffixArray[i+1]*array[i];
        }

       array[0]=suffixArray[1];
       array[array.length-1]=prefixArray[array.length-2];

       for(int i=1;i<array.length-1;i++){
           array[i]=prefixArray[i-1]*suffixArray[i+1];
       }

       return array;
    }

    public static void main(String[] args){
        int[] array1={1,2,3,4,5};


        int[] res=findProd(array1);
        for(int val:res){
            System.out.println(val);
        }
    }
}
