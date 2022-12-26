package com.coding.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Minimum Difference
 * Implement a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each array) who absolute difference is closest to zero, and returns a pair containing these two numbers, with the first number from array. Only one such pair will exist for the test.
 *
 * Input
 *
 * Array1 = [23, 5, 10, 17, 30]
 * Array2 = [26, 134, 135, 14, 19]
 * Output
 *
 * 17,19
 */
public class MinDifferenceCloseToZero {

    public static ArrayList<Integer> minDiffPair(int[] array1, int[] array2){
        int i=0,j=0, minDiff=Integer.MAX_VALUE,p1=0,p2=0;
        ArrayList<Integer> res=new ArrayList<>();
        Arrays.sort(array1);
        Arrays.sort(array2);
        while(i<array1.length && j<array2.length){
            int diff=Math.abs(array1[i]-array2[j]);
            if(minDiff>diff){
                minDiff=diff;
                p1=i;
                p2=j;
            }
            if(array1[i]>array2[j]){
                j++;
            } else if (array1[i]<array2[j]) {
                i++;
            }
            else{
                res.add(array1[i]);
                res.add(array2[j]);
                return res;
            }
        }

        res.add(array1[p1]);
        res.add(array2[p2]);
        return res;
    }
    public static void main(String[] args){
        int[] array1={23, 5, 10, 17, 30};
        int[] array2={26, 134, 135, 14, 19};


        ArrayList<Integer> res=minDiffPair(array2,array1);
        for(int val:res){
            System.out.println(val);
        }
    }
}
