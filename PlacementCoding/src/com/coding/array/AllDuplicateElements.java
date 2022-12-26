package com.coding.array;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given an unsorted array containing n numbers taken from the range 1 to n. The array has some numbers appearing twice, find all these duplicate numbers using constant space.
 *
 * Example 1:
 *
 * Input: [3, 4, 4, 5, 5]
 * Output: [4, 5]
 */
public class AllDuplicateElements {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        int start=0;
        boolean[] visited=new boolean[nums.length];
        for(int i=0;i<nums.length;i++)
            visited[i]=false;
        while(start<nums.length){
            int value=nums[start];
            int pos=value-1;
            if(nums[start]!=start+1 && !visited[start] && !visited[pos]){
                value=nums[start];
                pos=value-1;
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
            if(nums[i]!=i+1)
                duplicateNumbers.add(nums[i]);
        }
        // TODO: Write your code here
        return duplicateNumbers;
    }

    public static void main(String[] args){
        int[] arr={1,3,5,1,3};
        System.out.println(findNumbers(arr));

    }


}
