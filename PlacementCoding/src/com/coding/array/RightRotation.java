/**
 * Given an array arr[] of size N having distinct numbers sorted in increasing order and the array has been right rotated (i.e, the last element will be cyclically shifted to the starting position of the array) k number of times, the task is to find the value of k.
 * T(n)=log(n)
 * Auxiliary Space: O(log N)  [this is the space of recursion stack]
 */

package com.coding.array;

public class RightRotation {

    public int valueOfK(int array[],int length){
//        As it is right rotated, value of k is position of smallest element
        int start=0,end=length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(array[mid]<array[mid-1])
                return mid;
            else if(array[mid+1]<array[mid])
                return mid+1;
            else if(array[mid]<array[start])
                end=mid-1;
            else
                start=mid+1;
        }
        return 0;
    }

    public static void main(String[] args){
        RightRotation obj=new RightRotation();
        int[] array={19,22,25,36,47,12,13,15,17};
        int res=obj.valueOfK(array,array.length);
        System.out.println(res);

    }
}
