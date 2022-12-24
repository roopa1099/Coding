package com.coding.day0;

import java.util.HashMap;
import java.util.Map;

/**
 * You are visiting a farm to collect fruits. The farm has a single row of fruit trees. You will be given two baskets, and your goal is to pick as many fruits as possible to be placed in the given baskets.
 *
 * You will be given an array of characters where each character represents a fruit tree. The farm has following restrictions:
 *
 * Each basket can have only one type of fruit. There is no limit to how many fruit a basket can hold.
 * You can start with any tree, but you can’t skip a tree once you have started.
 * You will pick exactly one fruit from every tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 * Write a function to return the maximum number of fruits in both baskets.
 *
 * Example 1:
 *
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 */
public class TwoFruitBasket {

    public static int findLength(char[] arr) {
        // TODO: Write your code here
        Map<Character,Integer> map=new HashMap<>();
        int start=0,tempLength,maxLength=0;
        for(int i=0;i<arr.length;i++){
            char current=arr[i];
            if(map.containsKey(current)){
                map.put(current,map.get(current)+1);
            }
            else{
                map.put(current,1);
            }

            while(map.size()>2){
                map.put(arr[start],map.get(arr[start])-1);
                if(map.get(arr[start])==0){
                    map.remove(arr[start]);
                }
                start++;
            }
            tempLength=i-start+1;
            maxLength=Math.max(tempLength,maxLength);
        }
        return maxLength;

    }

    public static void main(String[] args){
        char[] arr={'A', 'B', 'C', 'B', 'B', 'C'};
        int val =findLength(arr);
        System.out.println(val);
    }

}
