package com.coding.day0;

/**
 * Given a circular integer array nums of length n, return the maximum possible sum of a
 * non-empty subarray of nums.
 *
 * A circular array means the end of the array connects to the beginning of the array.
 * Formally, the next element of nums[i] is nums[(i + 1) % n]
 * and the previous element of nums[i] is nums[(i - 1 + n) % n].
 *
 * A subarray may only include each element of the fixed buffer nums at most once.
 * Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1,
 * k2 <= j with k1 % n == k2 % n.
 */
public class CircularArrayMAxSum {

    public static int maxSubarraySumCircular(int[] nums) {

        int cur_max=0,cur_min=0,max_sum=nums[0],min_sum=nums[0],sumTotal=0;

        for(int val:nums){
            cur_max=Math.max(cur_max+val,val);//cur_max can be negative previusly
            max_sum=Math.max(cur_max,max_sum);
            cur_min=Math.min(cur_min+val,val);
            min_sum=Math.min(cur_min,min_sum);
            sumTotal=sumTotal+val;
        }


        if(min_sum==sumTotal)
            return max_sum;

        return Math.max(max_sum,sumTotal-min_sum);


    }


    public static void main(String[] args){
        int[] array={5,-3,5};
        System.out.println(maxSubarraySumCircular(array));
    }
}
