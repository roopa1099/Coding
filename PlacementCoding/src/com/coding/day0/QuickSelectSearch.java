package com.coding;

/**
 * Find element at ith position
 *
 * Hint: Compare pos with pivot element position, Only sort part containing that position
 */
public class QuickSelectSearch {
    static int element=-1;

    private static int  partition(int[] array,int start,int end){
            int pivotElement=array[end];
            int pt=start;
            for(int i=start;i<end;i++){
                if(pivotElement>array[i]){
                    int temp=array[i];
                    array[i]=array[pt];
                    array[pt]=temp;
                    pt++;
                }
            }
        int temp=array[end];
        array[end]=array[pt];
        array[pt]=temp;
        return pt;
    }
    public static int[] findElement(int[] array,int start, int end,int pos){

        if(start<end) {
            int pivotPosition = partition(array, start, end);
            if (pos > pivotPosition) {
                findElement(array, pivotPosition + 1, end, pos);
            } else if (pos == pivotPosition)
                element=array[pivotPosition];
            else {
                findElement(array, start, pivotPosition - 1, pos);
            }
        }
        else if(start==pos){
            element=array[start];
        }
        return array;
    }

    public static void main(String[] args){
        int[] arr={3,1,9,10,2,5};
        findElement(arr,0,arr.length-1,4);
        System.out.println(element);
    }
}
