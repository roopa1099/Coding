package com.coding.array;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
public class TopKElements {
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }

        List<Map.Entry<Integer,Integer>> list=new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){

                    public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2){

                        if(o1.getValue()==o2.getValue())
                            return o1.getKey()-o2.getKey();
                        else
                            return o2.getValue()-o1.getValue();
                    }

                }
        );


        int[] res=new int[k];
        int p=0;
        for(Map.Entry<Integer,Integer> val:list){
            res[p]=val.getKey();
            p++;

            if(p>=k)
                break;
        }


        return res;

    }

    public static void main(String[] args){
        int[] array={5,5,5,2,2,3};
        System.out.println(topKFrequent(array,2));
    }
}
