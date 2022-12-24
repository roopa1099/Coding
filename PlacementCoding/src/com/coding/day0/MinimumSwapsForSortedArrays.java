package com.coding.day0;

import java.util.Arrays;
import java.util.HashMap;


/**
 * Minimum numbe of swaps to make an array sorted;
 */
public class MinimumSwapsForSortedArrays {

    public static int swaps(int[] array){
        int[] sortedArray=new int[array.length];
        int i=0;
        for(int val:array){
            sortedArray[i]=val;
            i++;
        }

        Arrays.sort(sortedArray);
        HashMap<Integer,Integer> map=new HashMap<>();
        boolean[] visited=new boolean[array.length];
        for(int j=0;j<sortedArray.length;j++){
            map.put(sortedArray[j],j);
            visited[j]=false;
        }
        int element=array[0],swaps=0;
        for(int j=0;j<array.length;j++){
            int correct_pos=map.get(array[j]);
            if(!visited[correct_pos]){
                int count=0;
            while(!visited[correct_pos]){
                int newElementToBePlaced=array[correct_pos];
                array[correct_pos]=element;
                visited[correct_pos]=true;
                array[j]=newElementToBePlaced;
                count++;
                element=newElementToBePlaced;
                correct_pos=map.get(element);
            }
            swaps=swaps+(count-1);
            }

        }
        return swaps;
    }

    public static void main(String[] args){
        int[] array={10,11,5,4,3,2,1};
        System.out.println(swaps(array));
    }
}
