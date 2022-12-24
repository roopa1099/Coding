package com.coding.day0;

public class ArrayProperties {

    public static void main(String[] args){

        int[] array1={};
        int[] array2={1,2,3};
        int[] array3=new int[5];
        array3[0]=1;
        array3[1]=2;

        int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };


        for(int i:array1){
            System.out.println(i);
        }

        System.out.println();

        for(int i:array2){
            System.out.println(i);
        }

        System.out.println();

        for(int i:array3){
            System.out.println(i);
        }

        System.out.println();

        for(int i:intArray){
            System.out.println(i);
        }

    }
}
