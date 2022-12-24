package com.coding.day0;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
 *
 * Example 1:
 *
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 */
public class LongestSubarrayReplaced0With1 {
    public static int findLength(int[] arr, int k) {
        // TODO: Write your code here
        int one=0,start=0,maxLength=0,tempLength;
        for(int i=0;i<arr.length;i++){
            int current=arr[i];
            if(current==1)
                one++;
            // rest 0's in subarray can it be replaced within k
            if(((i-start+1)-one)>k){
                if(arr[start]==1)
                    one--;
                start++;
            }

            tempLength=i-start+1;
            maxLength=Math.max(maxLength,tempLength);
        }
        return maxLength;
    }

    public static void main(String[] args){
        int[] array={0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int val=findLength(array,1);
        System.out.println(val);
    }
}
