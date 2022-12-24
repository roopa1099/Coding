package com.coding.day0;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 */
public class MajorityElementBMoore2 {
    public static List<Integer> majorityElement(int[] nums) {

//        Max elements with a minimum count n/3+1 is 2, bcoz (n/3)*3=n, but (n/3+1)*3>n
        int num1=Integer.MIN_VALUE,num2=Integer.MIN_VALUE,count1=0,count2=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==num1){
                count1++;
            }
            else if(nums[i]==num2){
                count2++;
            }
            else if(count1==0){
                num1=nums[i];
                count1=1;
            }
            else if(count2==0){
                num2=nums[i];
                count2=1;
            }
            else{
//                if neither num1 and num2 matches decrase both count
                count1--;
                count2--;
            }
        }

        int ct1=0,ct2=0;

        for(int i=0;i<nums.length;i++){
            if(num1==nums[i])
                ct1++;
            if(num2==nums[i])
                ct2++;
        }


        List<Integer> res=new ArrayList<>();

        if(ct1>nums.length/3)
            res.add(num1);

        if(ct2>nums.length/3)
            res.add(num2);

        return res;
    }

    public static void main(String[] args){
        int[] array={1,2};
        System.out.println(majorityElement(array));
    }
}
