package com.coding.day0;

/**
 * Given an array of positive integers and a number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to ‘7’ is [5, 2].
 */
public class SmallestSubarrayGeaterThanGivenSum {

    public static int findMinSubArray(int S, int[] arr) {
        // TODO: Write your code here
        int tempSum=0,minSize=arr.length,start=0;
        for(int i=0;i<arr.length;i++){
            tempSum=tempSum+arr[i];

            while(tempSum>=S){
                tempSum=tempSum-arr[start];
                int size=i-start+1;
                minSize=Math.min(size,minSize);
                start++;

            }

        }
        return minSize;
    }

    public  static void main(String[] args){
       int[] array={3, 4, 1, 1, 6};
        System.out.println(findMinSubArray(8,array));
    }

}
