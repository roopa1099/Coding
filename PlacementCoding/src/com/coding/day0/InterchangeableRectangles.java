package com.coding.day0;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given n rectangles represented by a 0-indexed 2D integer array rectangles,
 * where rectangles[i] = [widthi, heighti] denotes the width and height of the ith rectangle.
 *
 * Two rectangles i and j (i < j) are considered interchangeable if they have the same
 * width-to-height ratio. More formally, two rectangles are interchangeable if widthi/heighti ==
 * widthj/heightj (using decimal division, not integer division).
 *
 * Return the number of pairs of interchangeable rectangles in rectangles.
 */
public class InterchangeableRectangles {

    public static long interchangeableRectangles(int[][] rectangles) {

        Map<Double,Integer> map=new HashMap<>();
        long count=0;
        for(int[] val:rectangles){
            double fract= (double) val[0]/val[1];
            if(map.containsKey(fract)){
                count=count+map.get(fract);
                map.put(fract,map.get(fract)+1);
            }
            else{
                map.put(fract,1);
            }
        }

        return count;

    }
    public static void main(String[] args){
        int[][] array={{4,5},{7,8}};
        System.out.println(interchangeableRectangles(array));
    }
}
