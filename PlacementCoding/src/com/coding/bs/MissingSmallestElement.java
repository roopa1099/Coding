package com.coding.bs;


/**
 * Given a sorted array of non-negative distinct integers, find 
 * the smallest missing non-negative element in it.
 */
public class MissingSmallestElement {
    
    public static int findSmallestMissing(int[] array){
        int start=0,end=array.length-1,result=array.length;
        while(start<=end){
            int mid=(start+end)/2;
            if(array[mid]==mid){
                start=mid+1;
            }
            else{
                result=mid;
                end=mid-1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array={0, 1, 2, 3, 4, 5, 6};
        System.out.println(findSmallestMissing(array));
    }
}
