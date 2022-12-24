package com.coding.day0;

/**
 * We are given an array containing n distinct numbers taken from the range 0 to n.
 * Since the array has only n numbers out of the total n+1 numbers, find the missing number.
 *
 * Example 1:
 *
 * Input: [4, 0, 3, 1]
 * Output: 2
 */
public class FindMissingElement {

    public static int findMissingNumber(int[] nums) {
        // TODO: Write your code here

        int elements=nums.length,sum=0,tempSum=0;
        for(int i=1;i<=elements;i++)
            sum=sum+i;

        for(int i=0;i<nums.length;i++)
            tempSum=tempSum+nums[i];


        return (sum-tempSum);
    }


    public static int findMissingNumberNew(int[] nums) {
        // TODO: Write your code here
        int start=0;
        while(start<nums.length){
            if(nums[start]<nums.length && nums[start]!=start){
                int val=nums[start];
                int pos=val;
                nums[start]=nums[pos];
                nums[pos]=val;
            }
            else{
                start++;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i)
                return i;
        }

        return -1;
    }




    public static void main(String[] args){
        int[] arr={2,0, 3, 1, 5};
        System.out.println(findMissingNumber(arr));
        System.out.println(findMissingNumberNew(arr));

    }
}
