package com.coding.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */
public class KClosestPointsToOrigin {

    private static int distance(int[] point){
        int distSq=(point[0]*point[0])+(point[1]*point[1]);
        return distSq;
    }
    public static int[][] kClosest(int[][] points, int k) {

        Arrays.sort(points,new Comparator<int[]>(){

            public int compare(int[] t1, int[]t2){
                return distance(t1)-distance(t2);
            }
        });




        int[][] res=new int[k][2];

        for(int i=0;i<k;i++){
            res[i][0]=points[i][0];
            res[i][1]=points[i][1];
        }

        return res;
    }

    public static void main(String[] args){
        int[][] array={{1,3},{-2,2}};
        System.out.println(kClosest(array,1));
    }
}
