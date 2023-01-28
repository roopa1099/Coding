package com.coding.divideAndconquer;


/**
 * ********IMPORTANT**************
 * Given an integer array, find the maximum sum among all subarrays possible.
 */
public class MaxSumSubarray {
    
    public static int maxSum(int[] array, int start, int end) {
        // once include the element and once without inlcuding the element

        
        if(start==end){
            return array[end];
        }

        // include element
        int mid=(start+end)/2;
        int sum=0;
        int maxLenft=Integer.MIN_VALUE;
        for(int k=mid;k>=start;k--){
            sum=sum+array[k];
            if(sum>maxLenft){
                maxLenft=sum;
            }
        }

         sum=0;
        int maxRight=Integer.MIN_VALUE;
        for(int k=mid+1;k<=end;k++){
            sum=sum+array[k];
            if(sum>maxRight){
                maxRight=sum;
            }
        }

        // without including the element
        int maxLeftRight=(int)Math.max(maxSum(array, start, mid-1),maxSum(array, mid+1, end));

        return Math.max(maxLeftRight, maxLenft+maxRight);



        
    }
    public static void main(String[] args) {
        int[] nums = { 2, -4, 1, 9, -6, 7, -3 };
        System.out.println(maxSum(nums, 0, nums.length-1));
    }
}
