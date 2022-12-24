package com.coding.day0;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * You must solve it in O(n) time complexity.
 */
public class KthLargetElementInArray {
    static int pos=-1;
    public static int returnPivotPos(int[] array,int start,int end){
        int pivot=array[end],st=start;
        for(int i=start;i<=end;i++){
            if(pivot>array[i]){
                int temp=array[st];
                array[st]=array[i];
                array[i]=array[st];
                st++;
            }

        }

        int temp=array[end];
        array[end]=array[st];
        array[st]=temp;

        return st;
    }


    public static int findElement(int nums[],int start,int end,int k){

        int pivotPos=returnPivotPos(nums,start,end);

        if(pivotPos==k)
            pos=nums[k];
        else if(pivotPos>k)
            findElement(nums,0,pivotPos-1,k);
        else
            findElement(nums,pivotPos+1,end,k);
        return pos;

    }


    public static int findKthLargest(int[] nums, int k) {

        return findElement(nums,0,nums.length-1,nums.length-k);
    }

    public static void main(String[] args){
        int[] array={3,1,2,4};
        System.out.println(findKthLargest(array,2));
    }
}
