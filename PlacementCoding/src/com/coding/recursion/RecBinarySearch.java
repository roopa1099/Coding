package com.coding.recursion;

/**
 * Binary search using recursion
 */
public class RecBinarySearch {
    
    public static int binarySearch(int[] array, int start, int end, int search) {

        int mid=(start+end)/2;
        int pos=-1;
        if(search==array[mid]){
            pos=mid; 
        }
        else if(start>end){
            return -1;
        }
        else if(array[mid]<search){
            start=mid+1;
            pos=binarySearch(array, start, end, search);
        }
        else{
            end=mid-1;
            pos=binarySearch(array, start, end, search);
        }
        
        return pos;
        
    }

    public static void main(String[] args) {
        int[] array={2,4,6,7,9};
        System.out.println(binarySearch(array, 0, array.length-1, 7));
    }
}
