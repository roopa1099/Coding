package com.coding;

/**
 * Mergesort=> D&C and merge tn=nLogn
 */
public class MergeSort {

    private static void merge(int[] array, int start,int end){
        int s=start;
        int end1=(start+end)/2;
        int start2=end1+1,k=0;
        int[] temp=new int[(end-start)+1];
        while(start<=end1 && start2<=end){
            if(array[start]>array[start2]){
                temp[k]=array[start2];
                start2++;
                k++;
            }
            else{
                temp[k]=array[start];
                start++;
                k++;
            }
        }


        while(start<=end1){
            temp[k]=array[start];
            start++;k++;
        }

        while(start2<=end){
            temp[k]=array[start2];
            start2++;k++;
        }

        k=0;
        int i=s;
        while(k<temp.length){
            array[i]=temp[k];
            i++;
            k++;
        }
    }

    public static int[] mergeSort(int[] array, int start,int end){
        if(start<end){
            int mid=(start+end)/2;
            mergeSort(array,start,mid);
            mergeSort(array,mid+1,end);
//            comes here if both parts are sorted
            merge(array,start,end);
        }
        return array;
    }

    public static void main(String[] args){
        int[] arr={3,1,7,9,10,2,5};
        mergeSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
}
