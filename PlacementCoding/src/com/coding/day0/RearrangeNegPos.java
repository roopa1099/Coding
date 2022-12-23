package com.coding;

/**
 * An array contains both positive and negative numbers in random order. Rearrange
 * the array elements so that positive and negative numbers are placed alternatively. A number of
 * positive and negative numbers need not be equal. If there are more positive numbers they appear
 * at the end of the array. If there are more negative numbers, they too appear at the end of the array.
 * For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the output should
 * be [9, -7, 8, -3, 5, -1, 2, 4, 6]
 *
 * t(n)=O(n), space=O(1)
 */
public class RearrangeNegPos {

    /**
     *
     * @param array
     * @param length
     * @return
     */
    public int[] rearrange(int[] array, int length){
        int i=0,negTive=0;
//        negative will point to next element to the last negative element of the partition
        while(i<length){
            if(array[i]<0){
                int temp=array[negTive];
                array[negTive]=array[i];
                array[i]=temp;
                negTive++;
            }
                i++;
        }

        int pos=negTive,neg=0;

        while(neg<pos){
            if(array[neg]<0){
                int temp=array[neg];
                array[neg]=array[pos];
                array[pos]=temp;
            }
//            alternate needs to be positive
            neg=neg+2;
            pos++;
        }
        return array;
    }

    public static void main(String[] args){
        int[] array={2,6,-2,-1,5,-2,1,2,4};
        RearrangeNegPos obj=new RearrangeNegPos();
        int[] res=obj.rearrange(array,array.length);
        for(int val:array){
            System.out.println(val);
        }
    }
}
