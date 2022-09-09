package com.coding;

/**
 * Given an array A of n elements, sort the array according to the following relations :
 *
 * A[i] >= A[i-1]
 *
 *
 * , if i is even.
 *
 * A[i] <= A[i-1]
 *
 *
 * , if i is odd.
 * Print the resultant array.
 *
 * t(n)=O(n), space=O(1)
 */

public class RearrangeGreaterLesser {

    public int[] rearrrange(int[] array, int length){
        for(int i=1;i<length;i=i+2){
            if(array[i]<array[i-1]){
                int temp=array[i];
                array[i]=array[i-1];
                array[i-1]=temp;
            }
        }

        return array;
    }

    public static void main(String[] args){
        RearrangeGreaterLesser obj=new RearrangeGreaterLesser();
        int[] array={2,3,9,7,5,1,7,4};
        array=obj.rearrrange(array,array.length);
        for(int val:array){
            System.out.println(val);
        }
    }
}
