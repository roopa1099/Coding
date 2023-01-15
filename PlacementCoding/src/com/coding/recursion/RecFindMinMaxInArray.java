package com.coding.recursion;

import java.util.ArrayList;
import java.util.List;


/**
 * Find min max from an array using recursion
 */
public class RecFindMinMaxInArray {

    public static List<Integer> minMax(int[] array, int index) {
        List<Integer> res=new ArrayList<>();
        if(index==array.length-1){
            res.add(0,array[index]);
            res.add(1,array[index]);
            return res;
        }
        res=minMax(array, index+1);
        if(res.get(0)>array[index]){
            res.remove(0);
            res.add(0,array[index]);
        }
        else if(res.get(1)<array[index]){
            res.remove(1);
            res.add(1,array[index]);
        }
        return res;      
    }
    public static void main(String[] args) {
        int[] array={2,2,3,2};
        System.out.println(minMax(array, 0));
    }
    
}
