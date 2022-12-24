package com.coding.day0;

import java.util.ArrayList;
import java.util.List;


/**
 * We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have
 * duplicates, which means some numbers will be missing. Find all those missing numbers.
 *
 * Example 1:
 *
 * Input: [2, 3, 1, 8, 2, 3, 5, 1]
 * Output: 4, 6, 7
 * Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
 */
public class FindaAllMissingNumbers {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        boolean[] visited=new boolean[nums.length];
        for(int i=0;i<nums.length;i++)
            visited[i]=false;

        int start=0;

        while(start<nums.length){
            int value=nums[start];
            int pos=value-1;

            if(nums[start]!=start+1 && !visited[start] && !visited[pos]){
                nums[start]=nums[pos];
                nums[pos]=value;
                visited[pos]=true;

            }
            else if(nums[start]==start+1 && !visited[start]){
                visited[start]=true;
                start++;
            }
            else{
                start++;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                missingNumbers.add(i+1);
            }
        }


        // TODO: Write your code here
        return missingNumbers;
    }


    public static void main(String[] args){
        int[] arr={2,2, 3, 2, 5};
        System.out.println(findNumbers(arr));

    }

}
