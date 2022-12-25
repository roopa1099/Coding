package com.coding.day0;

/**
 * Problem Statement#
 * We are given an array containing n objects. Each object, when created, was assigned a unique number from the range 1 to n based on their creation sequence. This means that the object with sequence number 3 was created just before the object with sequence number 4.
 *
 * Write a function to sort the objects in-place on their creation sequence number in O(n)
 * O(n)
 *  and without using any extra space. For simplicity, let’s assume we are passed an integer array containing only the sequence numbers, though each number is actually an object.
 *
 * Example 1:
 *
 * Input: [3, 1, 5, 4, 2]
 * Output: [1, 2, 3, 4, 5]
 */
public class Sort1ToN {

    public static void sort(int[] nums) {
        // TODO: Write your code here
        int start=0;
        while(start<nums.length){
            if(nums[start]!=start+1){
                int val=nums[start];
                int pos=val-1;
                nums[start]=nums[pos];
                nums[pos]=val;
            }
            else{
                start++;
            }

        }
    }

    public static void main(String[] args){
        int[] arr={2, 6, 4, 3, 1, 5};
        sort(arr);
        for(int i:arr){
            System.out.println(i);
        }
    }
}