package com.coding.array;

/**
 * Given an array of n positive integers and a number k. Find the minimum number of swaps
 * required to bring all the numbers less than or equal to k together.
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 */

public class MinimumSwapsToPartition {

    public int numberzOfSwap(int[] array, int length,int k){
        int count=0,i=0,neg=0;
        while(i<length){
            if(array[i]<=k && i!=neg){
                int temp=array[i];
                array[i]=array[neg];
                array[neg]=temp;
                count++;
                neg++;
            }
            else if(array[i]<=k && i==neg){
                neg++;
            }
            i++;
        }

        return count;
    }
    public static void main(String[] args){
        int[] array={2, 7, 9, 5, 8, 7, 4};
        MinimumSwapsToPartition obj=new MinimumSwapsToPartition();
        int val=obj.numberzOfSwap(array,array.length,5);
            System.out.println(val);

    }



}
