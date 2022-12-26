package com.coding.array;

import java.util.HashSet;

/**
 * Finf length of longest band possible from array. A band is a sequnce of consecutive numbers,
 * with a fixed difference of 1.
 *
 * Hint: Why to search for band if the element considered is not starting of a band.
 * t(n)=O(n)
 */

public class LongestBand {

    public static int longestBandLength(int[] array){
        HashSet<Integer> set=new HashSet<>();
        int maxLenth=0;
        for(int i:array){
            set.add(i);
        }

        for(int i=0;i<array.length;){
            if(!set.contains(array[i]-1)){
                int count=1;
                int val=array[i]+1;
                while(set.contains(val)){
// worst condition for this while loop is the entire array contains the logest band and eement is 1st element
//  but for all other values in "for" loop they won't come inside while loop only so O(n)
                    count++;
                    val++;
                }
                if(maxLenth<count)
                    maxLenth=count;
            }
            i++;
        }
        return  maxLenth;
    }

    public static void main(String[] args){
        int[] array={1,9,3,0,18,5,2,4,10,7,12,6};
        System.out.println(longestBandLength(array));
    }
}
