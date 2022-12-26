package com.coding.array;

/**
 * Problem Description
 *
 * Given an array of integers A, every element appears twice except for one. Find that single one.
 */
public class SingleElement {

    public static int findSIngle(int[] number){
        int val=number[0];
        for(int i=1;i<number.length;i++){
            val=val^number[i];
        }
        return val;
    }

    public static void main(String[] args){
        int[] arr={2,5,6,5,3,2,3,7,9,7,9};
        System.out.println(findSIngle(arr));
    }
}
