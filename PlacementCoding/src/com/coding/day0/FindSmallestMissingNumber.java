package com.coding.day0;


/**
 *
 Given an unsorted array containing numbers, find the smallest missing positive number in it.

 Note: Positive numbers start from ‘1’.

 Example 1:

 Input: [-3, 1, 5, 4, 2]
 Output: 3
 Explanation: The smallest missing positive number is '3'
 */
public class FindSmallestMissingNumber {


    public static int findNumber(int[] nums) {
        // TODO: Write your code here
        int start=0;
        while(start<nums.length){
            if(nums[start]>0 && nums[start]-1<nums.length && nums[start]!=nums[nums[start]-1]){
                int temp=nums[nums[start]-1];
                nums[nums[start]-1]=nums[start];
                nums[start]=temp;
            }
            else{
                start++;
            }
        }


        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr={3, 1, 2, 5};
        System.out.println(findNumber(arr));
    }
}
