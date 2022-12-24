package com.coding.day0;

import java.util.Arrays;

/**
 * evem position should be greater than left and right elements
 */
public class ZIgZagArray {

    public  static void zigZag(int[] array){

        for(int i=0;i<array.length-1;i++){
            if(i%2==0 && array[i]>array[i+1]){
                int temp=array[i];
                array[i]=array[i+1];
                array[i+1]=temp;
            }
            else if(i%2!=0 && array[i]<array[i+1]){
                int temp=array[i];
                array[i]=array[i+1];
                array[i+1]=temp;
            }
        }
    }


    public static void main(String[] args){
        int[] x={3,1,5,7,4,8};
        zigZag(x);
        for(int i=0;i<x.length;i++){
            System.out.print(x[i]);
        }
    }
}
