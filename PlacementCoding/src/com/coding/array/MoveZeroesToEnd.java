package com.coding.array;

/**
 * Given an array of n numbers. The problem is to move all the 0’s to the end of the array while
 * maintaining the order of the other elements. Only single traversal of the array is required.
 * Time Complexity: O(n).
 * Auxiliary Space: O(1).
 */
public class MoveZeroesToEnd {

    public int[] rearrange(int[] array,int length){
        int count=0;
        for(int i=0;i<length;i++){
            if(array[i]!=0){
                array[count]=array[i];
                count++;
            }
        }
        while(count<length){
            array[count]=0;
            count++;
        }
        return array;
    }

    public static void main(String[] args){
        int[] array={0,2,2,2,0,6,6,0,0,8 };
        MoveZeroesToEnd obj=new MoveZeroesToEnd();
        array=obj.rearrange(array,array.length);
        for(int val:array){
            System.out.println(val);
        }
    }
}
