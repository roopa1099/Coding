package com.coding.recursion;
import java.util.Arrays;

/**
 * Given an unsorted integer array, find all pairs with a given difference k 
 * in it without using any extra space.
 */
public class TargetSum {

    public static int binSearch(int[] array, int start, int end, int target) {
        int mid=(start+end)/2;
       
        if(start>end){
            return -1;
        }
        else if(array[mid]==target){
            return mid;
        }
        else if(array[mid]<target){
           return binSearch(array, start, mid-1, target);
        }
        else{
          return binSearch(array, mid+1, end, target);
        }
    }

    public static void difference(int[] array, int k) {
        Arrays.sort(array);
        for(int i=0;i<array.length;i++){
            // remove duplicate
            while(i<array.length-1 && array[i]==array[i+1] && k!=0){
                i++;
            }

            /**
             * array[pos]-array[i]=k;
             * array[pos]=array[i]+k
             */
            int pos=binSearch(array, i+1, array.length-1, array[i]+k);
            if(pos>=0){
                System.out.println();
                System.out.print(array[i]+" "+array[pos]);
            }
        }
    }
    


    public static void main(String[] args) {
        int[] aray={1, 5, 2, 2, 2, 5, 5, 4};
        difference(aray,3);
    }
    
}
