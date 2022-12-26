/**
 * A sorted array arr[] (may be distinct or may contain duplicates) of size N is rotated at some unknown point, find the minimum element in it.
 * log(n);
 */


package com.coding.array;

public class MinimumElementInRotatedArray {

    public int findMinimum(int[] array,int length){
        int res=0,start=0,end=length-1;
        while(start<end){
            int mid=(start+end)/2;
            if(array[mid]<array[mid-1]) {
                res = array[mid];
                break;
            }
            else if(array[mid]>array[mid+1]) {
                res = array[mid + 1];
                break;
            }
            else if(array[mid]<array[start])
                end=mid-1;
            else
                start=mid+1;
        }
        return res;
    }

    public static void main(String[] args){
        MinimumElementInRotatedArray obj=new MinimumElementInRotatedArray();
        int[] array={32,35,36,42,52,62,2,2};
        int res=obj.findMinimum(array,array.length);
        System.out.println(res);

    }
}
