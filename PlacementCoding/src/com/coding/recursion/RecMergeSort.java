package com.coding.recursion;

/*
 * Merge SOrt
 */
public class RecMergeSort {


    public static void merge(int[] array,int start,int mid, int end) {
        int[] newArray1=new int[mid-start+1];
        int[] newArray2=new int[end-(mid+1)+1];
        int p1=0,p2=0, ind=start;
        int str=0;
        for(int i=start;i<=mid;i++){
            newArray1[str]=array[i];
            str++;
        }
        str=0;
        for(int i=mid+1;i<=end;i++){
            newArray2[str]=array[i];
            str++;
        }

        while(p1<newArray1.length && p2<newArray2.length){
            if(newArray1[p1]<newArray2[p2]){
                array[ind]=newArray1[p1];
                p1++;
            }
            else{
                array[ind]=newArray2[p2];
                p2++;
            }
            ind++;
        }

        while(p1<newArray1.length){
            array[ind]=newArray1[p1];
            p1++;
            ind++; 
        }

        while(p2<newArray2.length){
            array[ind]=newArray2[p2];
            p2++;
            ind++; 
        }

    }
    public static void divide(int[] array,int start, int end) {
        int mid=(start+end)/2;

        if(start>=end){
            return;
        }

        divide(array,start,mid);
        divide(array, mid+1, end);
        merge(array, start, mid, end);
    }

    public static int[] mergeSort(int[] array) {
        divide(array, 0, array.length-1);
        return array;
    }
    
    public static void main(String[] args) {
        int[] array={4,1,6,3,8};
        mergeSort(array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
