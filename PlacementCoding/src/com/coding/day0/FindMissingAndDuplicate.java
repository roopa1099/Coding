package com.coding.day0;

/**
 * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array originally contained all the numbers from 1 to ‘n’, but due to a data error, one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.
 *
 * Example 1:
 *
 * Input: [3, 1, 2, 5, 2]
 * Output: [2, 4]
 * Explanation: '2' is duplicated and '4' is missing.
 */
public class FindMissingAndDuplicate {

    public static int[] findNumbers(int[] nums) {
        // TODO: Write your code here

        int start=0;
        while(start<nums.length){
            if(nums[start]!=nums[nums[start]-1]){
                int temp=nums[nums[start]-1];
                nums[nums[start]-1]=nums[start];
                nums[start]=temp;

            }
            else{
                start++;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return new int[] {nums[i], i+1 };
            }
        }


        return new int[] { -1, -1 };
    }

    public static void main(String[] args){
        int[] arr={3, 1, 2, 5, 2};
        int[] res=findNumbers(arr);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
