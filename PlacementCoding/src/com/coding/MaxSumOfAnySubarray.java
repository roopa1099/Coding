package com.coding;

/**
 * Maximum Subarray Sum
 * Implement a function that takes an input a vector of integers, and prints the maximum
 * subarray sum that can be formed. A subarray is defined as consecutive segment of the array. If
 * all numbers are negative, then return 0.
 *
 * Input
 *
 * {-1,2,3,4,-2,6,-8,3}
 * Output
 *
 * 13
 */
public class MaxSumOfAnySubarray {
//Kandane's algo: overall negative sum will reduce the sum upcoming, sodon't includeneg total sum
    public static int findMaxSum(int[] array){
        int curentSum=0,maxSum=Integer.MIN_VALUE,countNeg=0;

        for(int val:array){
            if(val<0) {
                countNeg++;
            }
        }

        if(countNeg==array.length)
            return -1;

        for(int i=0;i<array.length;i++){
            curentSum=curentSum+array[i];
            if(curentSum>maxSum){
                maxSum=curentSum;
            }

            if(curentSum<=0){
                curentSum=0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args){
        int[] array={-1,2,3,4,-2,6,-8,3};
        System.out.println(findMaxSum(array));

    }
}
