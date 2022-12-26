package com.coding.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.
 *
 * Example 1:
 *
 * Input: [3, -1, 4, 5, 5], k=3
 * Output: [1, 2, 6]
 * Explanation: The smallest missing positive numbers are 1, 2 and 6.
 */
public class FindKSmallestMissingElements {

    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
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
        int pt=0;
        HashSet<Integer> set=new HashSet<>();
        while(missingNumbers.size()<k && pt<nums.length){
            if(nums[pt]!=pt+1){
                missingNumbers.add(pt+1);
                set.add(nums[pt]);
            }
            pt++;
        }

        while(pt>=nums.length && missingNumbers.size()<k){
            if(!set.contains(pt+1))
                missingNumbers.add(pt+1);
            pt++;
        }

        return missingNumbers;
    }

    public static void main(String[] args){
        int[] arr={-2, -3, 4};
        System.out.println(findNumbers(arr,2));
    }
}
