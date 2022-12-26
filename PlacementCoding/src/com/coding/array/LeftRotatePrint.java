package com.coding.array;

public class LeftRotatePrint {


    public void printRotatedArray(int[] array,int k){
        for(int i=k;i<array.length+k;i++){
            System.out.print(array[i%array.length]);
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] array={2,4,3,6,5,8,6};
        int k1=3,k2=2,k3=5;
        LeftRotatePrint obj=new LeftRotatePrint();
        obj.printRotatedArray(array,k1);
        obj.printRotatedArray(array,k2);
        obj.printRotatedArray(array,k3);

    }

}
