package com.coding.recursion;

/**
 * Sum of array using reccursrion
 */
public class RecSumArray {

    public static int sumArray(int[] array,int index) {
        
        if(index==array.length-1){
            return array[index];
        }

        int sum=sumArray(array, index+1)+array[index];
        return sum;      
    }
    
    public static void main(String[] args) {
        int[] array={4,1,6,9};
        System.out.println(sumArray(array,0));
    }
}
