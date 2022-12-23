package com.coding;

import java.util.HashSet;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 *
 * You must write an algorithm that runs in O(log n) time.
 */
public class FindPeakELement {

    static int res=0;
    private static int findaElement(int[] array, int start,int end){
        res=0;
        int mid=(start+end)/2;
        if((mid>0) && (mid<array.length-1) && (array[mid]>array[mid+1] && array[mid]>array[mid-1])){
            res= mid;
            return res;
        }
        else if(mid==array.length-1){
            res=mid;
            return res;
        }

        else if((mid<array.length-1) && array[mid+1]>array[mid])
            findaElement(array,mid+1,end);
        else if((mid>0) && array[mid-1]>array[mid])
            findaElement(array,0,mid-1);

        return res;
    }
    public static int findPeakElement(int[] nums) {

        if(nums.length<2)
            return 0;
        if(nums.length==2){
            if(nums[0]>nums[1])
                return 0;
            else
                return 1;
        }
        int res=findaElement(nums,0,nums.length-1);
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,1};


        System.out.println(findPeakElement(array));
    }
}
