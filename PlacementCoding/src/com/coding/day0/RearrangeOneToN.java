package com.coding.day0;

/**
 * Given an array of elements of length N, ranging from 0 to N – 1. All elements may
 * not be present in the array. If the element is not present then there will be -1 present in
 * the array. Rearrange the array such that A[i] = i and if i is not present, display -1 at that
 * place.
 *
 * t(n)=O(n),space=O(1)
 *
 */

public class RearrangeOneToN {


    public int[] rearrange(int[] array) {
        int X, temp;
        for (int i = 0; i < array.length; i++) {
            X = array[i];
//            if not at correct place and also the element at correct position is not -1,
//            then keep swapping
            if(X!=-1){
                while (array[X]!=-1 && array[X]!= X) {
                    temp=array[X];
                    array[X]=X;
//                new X will be the swapped element
                    X=temp;

                }
//            in case the correct place is filled with -1, then simply put value, no swap required
                array[X] = X;
//            finally checking if the position of the current loop is currectly filled, else -1, later on if elements exists then
//            it will come here while swapping till then -1
                if (array[i] != i) {
                    array[i] = -1;
                }

            }

        }
        return array;
    }


    public static void main(String[] args){
        int[] array={5,-1,3,1,2,-1};
        RearrangeOneToN obj=new RearrangeOneToN();
        array=obj.rearrange(array);
        for(int val:array)
            System.out.println(val);
    }
}
