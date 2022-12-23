package com.coding;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.
 *
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 */

public class SubsequenceArrayWithSumMultipleOfK {
    public static boolean checkSubarraySum(int[] nums, int k) {

        int start=0,sum=0;
        Map<Integer,Integer> map=new HashMap<>();

//         to handle where remainder might be 0, but difference between index is not, we intialize 0,-1 as min difference between index should be 2;

        map.put(0,-1);

        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];

            int remainder=sum%k;

            if(map.containsKey(remainder)){
                if(i-map.get(remainder)>=2)
                    return true;
            }
            else{
                map.put(remainder,i);
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[] array={23,2,6,4,7};
        System.out.println(checkSubarraySum(array,6));
    }
}
