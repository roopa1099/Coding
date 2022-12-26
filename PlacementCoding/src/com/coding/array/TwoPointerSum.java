package com.coding.array;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal
 * to the given target.
 *
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they
 * add up to the given target.
 *
 * Example 1:
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 */
public class TwoPointerSum {
    public static int[] search(int[] arr, int targetSum) {
        // TODO: Write your code here

        int start=0,end=arr.length-1;
        int[] result={-1,-1};
        while(start<end){
            if(arr[start]+arr[end]==targetSum){
                result[0]=start;
                result[1]=end;
                break;
            }
            else if(arr[start]+arr[end]<targetSum){
                start++;
            }
            else{
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] array={1, 2, 3, 4, 6};
        int[] res=search(array,6);
        System.out.println(res[0]+" "+res[1]);
    }

}
