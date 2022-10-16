package com.coding;

import java.util.Arrays;

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or
 * linear order.
 *
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2],
 * [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 *
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 */
public class NextPermutation {

    public static void nextPermutation(int[] nums) {

        if(nums.length<2)
            return;

        int index=nums.length-1;

        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1])
                break;
            index--;
        }

        int ind=index;
        if(index>0)
            index--;


        for(int j=nums.length-1;j>index;j--){
            if(nums[j]>nums[index]){
                int temp=nums[j];
                nums[j]=nums[index];
                nums[index]=temp;
                break;
            }
        }


        Arrays.sort(nums,ind,nums.length);

    }

    public static void main(String[] args){
        int[] arr={1,8,6,2,5,4,8,3,7};
      nextPermutation(arr);

      for(int i=0;i<arr.length;i++)
          System.out.println(arr[i]);
    }
}
