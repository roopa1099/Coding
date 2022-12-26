package com.coding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 *
 * Example 1:
 *
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 */
public class TripleSumZero {


    public static void searchTwoSum(int[] arr, int startIndex,int target,List<List<Integer>> triplets){
        int start=startIndex, end=arr.length-1;

        while(start<end){
            if(arr[start]+arr[end]==target){
                List<Integer> list=new ArrayList<>();
                list.add(0-target);
                list.add(arr[start]);
                list.add(arr[end]);
                triplets.add(list);
                start++;
                end--;
                // System.out.println(target+" "+arr[start]+" "+arr[end]);
                while(start<end && arr[start]==arr[start-1])
                    start++;
                while(start<end && arr[end]==arr[end+1])
                    end--;
            }
            else if(arr[start]+arr[end]<target)
                start++;
            else
                end--;
        }

    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        // TODO: Write your code here
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            int search=0-arr[i];
            while(arr[i]==arr[i+1])
                i++;
            searchTwoSum(arr,i+1,search,triplets);
        }

        return triplets;
    }

    public static void main(String[] args){
        int[] array={-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> list=searchTriplets(array);
        for(List<Integer> res:list)
        System.out.println(res);
    }
}
