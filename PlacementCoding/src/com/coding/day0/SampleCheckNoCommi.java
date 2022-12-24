package com.coding.day0;

import java.util.*;

public class SampleCheckNoCommi {

    public static boolean search(int[] nums, int target) {


        if(nums.length==1 && nums[0]==target)
            return true;

        int start=0,end=nums.length-1;

        while(start<end){
            int mid=(start+end)/2;
            if(nums[mid]==target)
                return true;
            else if(nums[mid]==nums[end])
                end--;
            else if(nums[mid]>nums[start]){
                if(target<nums[mid] && target>nums[start])
                    end=mid-1;
                else
                    start=mid+1;
            }
            else{
                if(target>nums[mid] && target<nums[end])
                    start=mid+1;
                else
                    end=mid-1;
            }

        }

        return false;
    }


    public static void main(String[] args){
        int[] array={1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};


        System.out.println(search(array,2));
//        System.out.println(result[1]);
//        s
    }
}
