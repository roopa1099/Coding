package com.coding.array;

import java.util.HashMap;

/**
 * Given a rod of length n and a list of rod prices of length i, where 1 <= i <= n,
 * find the optimal way to cut the rod into smaller rods to maximize profit.
 */
public class MaxProfitableRod {

    public static int maxProfit(int[] parts,int[] revenue,int lengthReq){
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int start=0,end=parts.length-1;
        int maxProfit=Integer.MIN_VALUE;
        for(int i=0;i<parts.length;i++){
            map.put(parts[i],revenue[i]);
        }
        while(start<=end){
            if(parts[start]+parts[end]==lengthReq){
                int profit=map.get(parts[start])+map.get(parts[end]);
                maxProfit=Math.max(profit,maxProfit);
                start++;
                end--;
            }
            else if(parts[start]+parts[end]>lengthReq){
                end--;
            }
            else{
                start++;
            }
        }

        return maxProfit;

    }

    public static void main(String[] args){
        int[] arr={1, 2, 3, 4, 5, 6, 7, 8};
        int[] revenue={1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(maxProfit(arr,revenue,4));
    }
}
