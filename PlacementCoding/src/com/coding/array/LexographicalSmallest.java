package com.coding.array;

/**
 * Find lexographically smallest String.
 *
 * Hint: Simple sorting would not work, CHeck combining 2 strings
 */
public class LexographicalSmallest {

    private static void merge(String[] array,int start,int end){
        int end1=(start+end)/2,s=start;
        int start2=end1+1;
        String[] temp=new String[(end-start)+1];
        int pt=0;

        while(start<=end1 && start2<=end){
            if((array[start]+array[start2]).compareTo(array[start2]+array[start])==1)
            {
                temp[pt]=array[start2];
                start2++;
                pt++;
            }
            else{
                temp[pt]=array[start];
                start++;
                pt++;
            }
        }

        while(start<=end1){
            temp[pt]=array[start];
            pt++;
            start++;
        }

        while(start2<=end){
            temp[pt]=array[start2];
            pt++;
            start2++;
        }

        pt=s;
        for(int k=0;k<temp.length;k++){
            array[pt]=temp[k];
            pt++;
        }

    }

    public static String[] mergeSmallest(String[] array,int start,int end){
        if(start<end){
            int mid=(start+end)/2;
            mergeSmallest(array,start,mid);
            mergeSmallest(array,mid+1,end);
            merge(array,start,end);
        }
        return array;
    }

    public static void main(String[] args){
        String[] arr={"a","ab","aba"};
        String res=new String("");
        arr=mergeSmallest(arr,0,arr.length-1);
        for(String chr:arr){
            res=res+chr;
        }
        System.out.println(res);
    }

}
