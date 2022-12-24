package com.coding.day0;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may
 * assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 */
public class MajorityElementMoore {
    public static int majorityElement(int[] nums) {

        int element=nums[0],count=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]==element){
                count++;
            }
            else{
                count--;
                if(count==0){
                    element=nums[i];
                    count=1;
                }
            }
        }

        int fiCount=0;
        for(int i=0;i<nums.length;i++){
            if(element==nums[i])
                fiCount++;
        }

        if(fiCount>nums.length/2)
            return element;

        return -1;
    }

    public static void main(String[] args){
        int[] array={2,2,1,1,1,2};
        System.out.println(majorityElement(array));
    }
}



