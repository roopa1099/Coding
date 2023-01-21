package com.coding.recursion;

/**
 * Given a sorted array of non-negative distinct integers, find the smallest missing non-negative element in it.
 */
public class RecSmallestMissingNum {

    public static int smallesMissing(int[] array, int index) {

        if(index==array.length){
            return -1;
        }

        int smallestElement=smallesMissing(array, index+1);
        if(array[index]!=index)
            return index;
       
        return smallestElement;
    }
    public static void main(String[] args) {
        int[] array={0,1,2,3,4,5,6,23};
        System.out.println(smallesMissing(array,0));
    }
}
