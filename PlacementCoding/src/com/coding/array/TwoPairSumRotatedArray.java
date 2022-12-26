/**
 * Given an array arr[] of distinct elements size N that is sorted and then around an unknown point, the task is to check if the array has a pair with a given sum X.
 * t(n)=O(n);
 * space=O(1);
 */


package com.coding.array;

public class TwoPairSumRotatedArray {

    private int findSmallestElement(int[] array,int length){
        int start=0,end=length-1;
//        HashSet<Integer> et=new HashSet<>();
        while(start<=end){
            int mid=(start+end)/2;
            if(array[mid]>array[mid+1])
                return mid+1;
            else if(array[mid]<array[mid-1])
                return mid;
            else if(array[mid]<array[0])
                end=mid-1;
            else
                start=mid+1;
        }
        return 0;
    }


    public boolean sumExists(int[] array,int sum){
//        logic????
     int pivot=findSmallestElement(array,array.length);
     int l=pivot,r=pivot-1;
     while(l!=r){
         if(array[l]+array[r]==sum)
             return true;
         else if(array[l]+array[r]>sum){
             r=(array.length+(r-1))%array.length;
         }
         else{
             l=(l+1)%array.length;
         }
        }
     return false;
    }


    public static void main(String[] args){
        TwoPairSumRotatedArray obj=new TwoPairSumRotatedArray();
        int[] array={19,22,25,36,47,12,13,15,17};
        System.out.println(obj.sumExists(array,41));

    }
}
