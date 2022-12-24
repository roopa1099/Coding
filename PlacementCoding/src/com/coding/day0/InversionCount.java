package com.coding.day0;

/**
 * Inversion id arr[i]>arr[j]
 * and i<j
 * */
public class InversionCount {

    static int ct=0;
    private static void count(int[] array, int start, int end){
        int end1=(start+end)/2,start2=end1+1;
        int s=start;
        int k=0;
        int[] temp=new int[(end-start)+1];
        while(start<=end1 && start2<=end){
//            if right side value is small add count
            if(array[start]>array[start2]){
                ct=ct+(end1-start+1);
                temp[k]=array[start2];
                k++;
                start2++;
            }
            else{
                temp[k]=array[start];
                k++;
                start++;
            }
        }

        while(start<=end1){
            temp[k]=array[start];
            k++;
            start++;
        }

        while(start2<=end){
            temp[k]=array[start2];
            k++;
            start2++;
        }

        k=0;
        int i=s;
        while(i<=end){
            array[i]=temp[k];
            k++;i++;
        }
    }

    public static int[] inversionCount(int[] array,int start,int end){
        if(start<end){
            int mid=(start+end)/2;
            inversionCount(array,start,mid);
            inversionCount(array,mid+1,end);
            count(array,start,end);
        }
        return  array;
    }

    public static void main(String[] args){
        int[] arr={3,1,7,9,10,2,5};
        inversionCount(arr,0,arr.length-1);
        System.out.println(ct);
    }

}
