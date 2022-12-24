package com.coding.day0;

/**
 * Given an integer array nums and an integer k, return the
 * number of subarrays of nums where the greatest common divisor of the
 * subarray's elements is k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * The greatest common divisor of an array is the largest integer that evenly divides
 * all the array elements.
 */
public class SubarrayWithKGcd {
    public static int subarrayGCD(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int cur_gcd=nums[i];
            for(int j=i;j<nums.length;j++){
                cur_gcd=gcd(nums[j],cur_gcd);
                if(cur_gcd==k)
                    count++;
            }
        }
        return count;
    }


    private static int gcd(int a,int b){
        if(a==0)
            return b;
        return gcd(b%a,a);
    }

    public static void main(String[] args){
        int[] array={9,3,1,2,6,3};
        System.out.println(subarrayGCD(array,3));
    }
}
