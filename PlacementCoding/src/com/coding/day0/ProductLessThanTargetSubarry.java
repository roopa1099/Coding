package com.coding.day0;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array with positive numbers and a positive target number, find all of its contiguous subarrays whose product is less than the target number.
 *
 * Example 1:
 *
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 * Explanation: There are six contiguous subarrays whose product is less than the target.
 */
public class ProductLessThanTargetSubarry {


    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        int start=0,product=1;
        // TODO: Write your code here
        for(int end=0;end<arr.length;end++){
            product=product*arr[end];

            while(product>=target && start<=end){
                product=product/arr[start];
                start++;
            }

// subarray containing all elements
            List<Integer> subar = new ArrayList<>();
            for(int i=end;i>=start;i--){
                subar.add(0,arr[i]);
                subarrays.add(new ArrayList<>(subar));
            }

        }
        return subarrays;
    }

    public static void main(String[] args){
        int[] array={2, 5, 3, 10};

        List<List<Integer>> result= findSubarrays(array,30);
        for(List<Integer> val:result){
            System.out.println(val);
        }
    }
}
