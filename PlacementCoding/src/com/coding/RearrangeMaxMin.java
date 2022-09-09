package com.coding;
/**
 * Given an array of n elements. Our task is to write a program to rearrange the array such that elements at even positions are greater than all elements before it and elements at odd positions are less than all elements before it.
 * Examples:
 *
 *
 * Input : arr[] = {1, 2, 3, 4, 5, 6, 7}
 * Output : 4 5 3 6 2 7 1
 *
 * Input : arr[] = {1, 2, 1, 4, 5, 6, 8, 8}
 * Output : 4 5 2 6 1 8 1 8
 *
 * t(n)=N(logN), Space=O(N)
 */

import java.util.Arrays;

public class RearrangeMaxMin {

    public int[] reArrange(int[] array, int length) {
        Arrays.sort(array);
        int last = length - 1, start = 0, pos = length - 1;
        int[] newArray = new int[array.length];
        while (start <= last)
            if (pos % 2 == 0) {
                newArray[pos] = array[start];
                pos--;
                start++;
            } else {
                newArray[pos] = array[last];
                pos--;
                last--;
            }
        return newArray;
    }

    public static void main(String[] args){
        int[] array={5,2,6,3,1,4};
        RearrangeMaxMin obj=new RearrangeMaxMin();
        int[] res= obj.reArrange(array,array.length);
        for(int val:res){
            System.out.println(val);
        }

    }


}
