package com.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers and a target number, find all unique quadruplets in it,
 * whose sum is equal to the target number.
 *
 * Example 1:
 *
 * Input: [4, 1, 2, -1, 1, -3], target=1
 * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 */

public class QuadripleSum {

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);
        // TODO: Write your code here
        int search1,search2;
        for(int i=0;i<arr.length-3;i++){
            search1=target-arr[i];
            for(int j=i+1;j<arr.length-2;j++){
                search2=search1-arr[j];
                int pt=j+1,pt2=arr.length-1;
                while(pt<pt2){
                    if(arr[pt]+arr[pt2]==search2){
                        List<Integer> list=new ArrayList<>();
                        list.add(arr[i]);list.add(arr[j]);list.add(arr[pt]);list.add(arr[pt2]);
                        pt++;
                        pt2--;
                        quadruplets.add(list);
                        while(arr[pt]==arr[pt-1] && pt<pt2)
                            pt++;
                        while(arr[pt2]==arr[pt2+1] && pt<pt2)
                            pt2--;
                    }
                    else if(arr[pt]+arr[pt2]>search2)
                        pt2--;
                    else
                        pt++;
                }
            }
        }

        return quadruplets;
    }

    public static void main(String[] args){
        int[] array={2, 0, -1, 1, -2, 2};

        List<List<Integer>> result= searchQuadruplets(array,2);
        for(List<Integer> val:result){
            System.out.println(val);
        }
    }
}
