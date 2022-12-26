package com.coding.array;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 */

public class SubarrayWithMaxKelementSum {

    public int maxSum(int[] array, int k,int length){
        int tempSum=0, maxSum=0, i, start=0;
         for(i=0;i<length;i++) {
             if((i-start)==k){
                 maxSum=Math.max(tempSum,maxSum);
                 tempSum=tempSum-array[start];
                 start++;
             }

             tempSum=tempSum+array[i];
         }
         return maxSum;
    }

    public static void main(String[] args){
        int[] array={2, 3, 4, 1, 5};
        SubarrayWithMaxKelementSum obj=new SubarrayWithMaxKelementSum();
        System.out.println(obj.maxSum(array,2,array.length));
        }
}

