package com.coding.day0;

public class RecSorted {
    public static boolean isSorted(int[] array, int index){
        if(index==array.length-1){
            return  true;
        }
        if(array[index]<array[index+1]){
            return isSorted(array,index+1);
        }
        else{
            return false;

        }
    }

    public static void main(String[] args){
        int[] array={3,3,6};
        System.out.println(isSorted(array,0));
    }
}
