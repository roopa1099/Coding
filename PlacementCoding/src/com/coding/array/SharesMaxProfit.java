package com.coding.array;

public class SharesMaxProfit {

    public static int profit(int[] array){
        int maxProfit=0;
        for(int start=0;start<array.length-1;start++){
            if(array[start+1]>array[start]){
                int i=start+1;
                while(i<array.length-1 && array[i+1]>array[i]){
                    i++;
                }
                maxProfit=maxProfit+(array[i]-array[start]);
                start=i;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args){
        int[] array={10, 8, 6, 5, 4, 2};
        System.out.println(profit(array));
    }
}
