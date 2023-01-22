package com.coding.recursion;

/**
 * Given an integer array where every element appears an even number of times, 
 * except one element which appears an odd number of times. If the identical elements 
 * appear in pairs in the array and there cannot be more than two consecutive
 *  occurrences of an element, find the odd occurring element in logarithmic time and constant space.
 */
public class RecOddOccElements {

    public static int binarySearch(int [] array, int start, int end) {
        int mid=(start+end)/2;
        if(start>end){
            return -1;
        }
        else if(mid==array.length-1 && array[mid]!=array[mid-1]){
            return array[mid];
        }
        else if(mid==0 && array[mid]!=array[mid+1]){
            return array[mid];
        }
        else if(array[mid]!=array[mid+1] && array[mid]!=array[mid-1]){
            return array[mid];
        }
        else if(mid%2==0 && array[mid]==array[mid+1]){
            return binarySearch(array, mid+2, end);
        }
        else if(mid%2!=0 && array[mid]==array[mid-1]){
           return binarySearch(array, mid+1, end);
        }
        else{
            return binarySearch(array, start, mid-1);
        }
           
    }
    
    public static void main(String[] args) {
        int[] array={2, 2, 3, 3, 2, 2, 4,4, 3,3,4, 1, 1};
        System.out.println(binarySearch(array, 0, array.length-1));
    }
}
