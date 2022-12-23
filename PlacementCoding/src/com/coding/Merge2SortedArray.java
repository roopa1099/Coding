package com.coding;

/**
 * Given 2 sorted array, merge them such that the elements are in X and Y
 * arrays like first p elements in X array and next N elements in Y array
 */
public class Merge2SortedArray {


    public static void merge(int[] x, int[]y){
        int pt2=0;
        for(int i=0;i<x.length;i++){
            if(x[i]>y[0]){
                int temp=x[i];
                x[i]=y[0];


                int j=1;
                while(j<y.length && y[j]<temp){
                    y[j-1]=y[j];
                    j++;

                }
                y[j-1]=temp;
            }
        }
    }
    public static void main(String[] args){



        int[] x={2,5,8,10};
        int[] y={3,4,7};
        merge(x,y);
        for(int i=0;i<x.length;i++){
            System.out.print(x[i]);
        }
        System.out.println();
        for(int i=0;i<y.length;i++){
            System.out.print(y[i]);
        }

    }
}
