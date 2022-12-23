package com.coding;

import java.util.Arrays;

/**
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such
 * that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write
 * a function to return the count of such triplets.
 *
 * Example 1:
 *
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 */
public class TripletSumLessThanTargetCount {
    public static int findTrip(int[] arr, int target,int start)
    {
        int count=0;
        int end=arr.length-1;
        while(start<end){
            if(arr[start]+arr[end]<target){
                // count is increased so bcoz, now with start, all less than end will also make sum
                //  less than target. If we only do count++; then we  will leave values less than
                // end with start, bcoz start++ is done.
                count=count+(end-start);
                start++;
                while(arr[start]==arr[start-1])
                    start++;
            }
            else{
                end--;
            }
        }
        return count;
    }

    public static int searchTriplets(int[] arr, int target) {
        int count = 0;

        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){

            int search=target-arr[i];
            int temp=findTrip(arr,search,i+1);
            count=count+temp;
        }
        // TODO: Write your code here
        if(count==0)
            return -1;
        return count;
    }

    public static void main(String[] args){
        int[] array={-1, 0, 2, 3};
        int res=searchTriplets(array,3);
        System.out.println(res);
    }
}
