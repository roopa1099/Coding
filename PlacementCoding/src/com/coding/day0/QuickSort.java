package com.coding.day0;

/**
 * 1. Pivot element 2. Based on pivot divide 3. and do swap pivot element, Recursive call.
 */
public class QuickSort {

    private static int partition(int[] array,int start,int end){
            int pivot=array[end];
            int pt=start;
            while(start<end){
                if(array[start]<pivot){
                    int temp=array[pt];
                    array[pt]=array[start];
                    array[start]=temp;
                    pt++;
                }
                start++;
            }
            int temp=array[pt];
            array[pt]=pivot;
            array[end]=temp;
            return pt;
    }

    public static int[] sort(int[] array, int start, int end){
        if(start<end){
            int part=partition(array,start,end);
            sort(array,start,part-1);
            sort(array,part+1,end);
        }
        return array;
    }

    public static void main(String[] args){
        int[] arr={3,1,7,9,10,2,5};
        int[] res=sort(arr,0,arr.length-1);
        for(int i=0;i<res.length;i++)
            System.out.println(res[i]);
    }
}
