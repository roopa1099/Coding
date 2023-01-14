package com.coding.recursion;

/**
 * Reverse array using recursion
 */
public class RecArrayReverse {

    public static int[] reverseArray(int[] array,int index) {
        // base condition
        if(array.length%2!=0 && index==(array.length/2)){
                return array;
              
        }
        else if(array.length%2==0 && index==(array.length/2)-1){
                int temp=array[index];
                array[index]=array[index+1];
                array[index+1]=temp;
                return array;
        }

        array=reverseArray(array, index+1);
        // what we have to do
        int temp=array[index];
        array[index]=array[array.length-1-index];
        array[array.length-1-index]=temp;
        return array;
    }
    
    public static void main(String[] args) {
        int[] array={2,5,8,9,5};
        array=reverseArray(array, 0);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }    

    }
}
