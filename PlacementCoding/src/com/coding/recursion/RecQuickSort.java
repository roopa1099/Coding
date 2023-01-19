package com.coding.recursion;

/**
 * Quick Sort
 */
public class RecQuickSort {

    public static int pivotPos(int[] array,int start, int end){
            int pt=start, element=array[end];
        int index=start;
        while(pt<end){
            if(element>array[pt]){
                int temp=array[index];
                array[index]=array[pt];
                array[pt]=temp;
                index++;
            }
            pt++;
        }
        
        array[end]=array[index];
        array[index]=element;

        return index;
    }

    public static void quickSort(int[] array, int start, int end) {

        if(start>=end){
            return;
        }

        int pos=pivotPos(array, start, end);
        quickSort(array, start, pos-1);
        quickSort(array, pos+1, end);
        
    }
    
    public static void main(String[] args) {
        int[] array={4,2,6,1,5,2};
        quickSort(array, 0, array.length-1);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
