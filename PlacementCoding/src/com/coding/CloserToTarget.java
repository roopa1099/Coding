package com.coding;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum
 * is as close to the target number as possible, return the sum of the triplet. If there are
 * more than one such triplet, return the sum of the triplet with the smallest sum.
 * Example 2:
 *
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 */

public class CloserToTarget {



    public static int searchTriplet(int[] arr, int targetSum) {

        int minDiff=9999,smallestSum;
        int sum=0;
        Arrays.sort(arr);
        // TODO: Write your code here
        for(int i=0;i<arr.length-2;i++){
            int search=targetSum-arr[i];
            int end=arr.length-1,start=i+1;
            while(start<end){
                int diff=search-(arr[start]+arr[end]);
                if(diff==0){
                    return targetSum;
                }

// total sum has to be closer means abs value, as it can be greater or lesser than target sum
                if(Math.abs(diff)<minDiff){
                    minDiff=diff;
                    sum=arr[i]+arr[start]+arr[end];
                }
                else if(Math.abs(diff)==minDiff){
                    smallestSum=sum;
                    sum=arr[i]+arr[start]+arr[end];
                    if(smallestSum<sum){
                        sum=smallestSum;
                    }
                }
                if(diff>0)
                    // bcoz to make diff smaller sum has to be bigger, so start++;
                    // Abs value of 5-4 is better than abs value of
                    // 5-3
                    start++;
                else
                    // here if diff is negative, make diff smaller means abs value of diff will decease
                    // means sum will decraese
                    // we need a triplet with a smaller sum Abs value of 5-6 is better than abs value of
                    // 5-7, here 6 is the sum
                    end--;

            }
        }
        return sum;
    }

    public static void main(String[] args){
        int[] array={-2, 0, 1, 2};

        System.out.println(searchTriplet(array,2));
    }
}
