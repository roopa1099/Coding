package com.coding;

/**
 * Given a circularly sorted integer array, find the total number of times the array is rotated. Assume
 *  there are no duplicates in the array, and the rotation is in the anti-clockwise direction.
 */
public class RotationsInCirclarArray {

    public static int findSmallestPos(int[] array){

       
        int start=0,end=array.length-1,pos=-1;
        if((array.length==1) || array[start]<array[start+1] && array[start]<array[end])
            return 0;

        while(start<=end){
            int mid=(start+end)/2;
            if(array[mid]<array[mid+1] && array[mid]<array[mid-1]){
                pos=mid;
                break;
            }
            else if(array[mid]>array[0]){
                start=mid+1;
            }
            else if(array[mid]<array[0]){
                end=mid-1;
            }
        }

        return pos;
    }

    public static int findRotation(int[] array){
        int pos=findSmallestPos(array);
        return pos;
    } 

    public static void  main(String[] args) {
        int[] array={8, 9, 10, 2, 5, 6};
        System.out.println(findRotation(array));
    }
    
}
