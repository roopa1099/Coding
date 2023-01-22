package com.coding.recursion;

import java.util.Arrays;

/**
 * Given a sorted integer array, find the k closest elements to target in the array where 
 * k and target are given positive integers.

The target may or may not be present in the input array. If target is less than or equal
 to the first element in the input array, return first k elements. Similarly, if target is 
 more than or equal to the last element in the input array, return the last k elements. 
The returned elements should be in the same order as present in the input array.
 */
public class RecKClosestElement {
    static int pt1=-1,pt2=-1;
    public static int closestPos(int[] array, int start, int end, int pos, int target) {

        int mid=(start+end)/2;
        if(start>end){
            return pos;
        }
        else if(array[mid]==target){
            return mid;
        }
        else if(array[mid]>target){
           pos= closestPos(array,start,mid-1,mid,target);
           return pos;
        } else{
            pos=closestPos(array,mid+1,end,mid,target);
            return pos;
        }
    }

    public static void subArray(int[] array, int p1, int p2, int target, int k) {
        int absDiffP1=Integer.MAX_VALUE, abseDiffP2=Integer.MAX_VALUE;
        if(p1>=0){
            absDiffP1=Math.abs(array[p1]-target);
        }
       if(p2<array.length){
        abseDiffP2=Math.abs(array[p2]-target);
       }   
        if(k==0){
            pt1=p1;
            pt2=p2;
            return;
        }
        if(absDiffP1<=abseDiffP2){
            p1--;
            k--;
            subArray(array, p1, p2, target, k);
        }else{
            p2++;
            k--;
            subArray(array, p1, p2, target, k); 
        }
    }

    public static int[] kClosestElementArray(int[] array, int target, int k) {

        if(k>array.length){
            System.out.println("Only "+array.length+"elements possible");
            return null;
        }

        int pos=closestPos(array, 0, array.length-1, -1, target);
        int p1=pos-1,p2=pos;
        subArray(array, p1, p2, target, k);
        return Arrays.copyOfRange(array,pt1+1,pt2);
    }
    public static void main(String[] args) {
        int[] array={4,6,7,18,19};
        int[] result=kClosestElementArray(array, 15, 41);
        for(int val:result){
            System.out.println(val);
        }
       
    }
}
