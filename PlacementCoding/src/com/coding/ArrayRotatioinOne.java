package com.coding;
/**
 * Given an array arr[] of size N, the task is to rotate the array by d position to the left.
 *         Examples:
 *
 *         Input:  arr[] = {1, 2, 3, 4, 5, 6, 7}, d = 2
 *         Output: 3, 4, 5, 6, 7, 1, 2
 *         Explanation: If the array is rotated by 1 position to the left,
 *         it becomes {2, 3, 4, 5, 6, 7, 1}.
 *         When it is rotated further by 1 position,
 *         it becomes: {3, 4, 5, 6, 7, 1, 2}
 *
 *         Input: arr[] = {1, 6, 7, 8}, d = 3
 *         Output: 8, 1, 6, 7
 *
 *         Time Complexity: O(N)
 *         Auxiliary Space: O(1)
 */


public class ArrayRotatioinOne {

    private int[] reverseArray(int[] array,int start,int end){
        int i=start,j=end;
        while(i<j){
            int temp=array[i];
            array[i]=array[j];
            array[j]=temp;
            i++;
            j--;
        }
        return array;
    }

    public int[] rotate(int[] array, int numRotate){
        if(numRotate>array.length-1){
            numRotate=numRotate%(array.length);
        }
        reverseArray(array,0,array.length-1);
        int d=array.length-numRotate;
        int end2=d-1;
        reverseArray(array,d,array.length-1);
        reverseArray(array,0,end2);
        return array;
    }

    public static void main(String[] args){
        ArrayRotatioinOne obj=new ArrayRotatioinOne();
        int[] array={2,5,3,6,1,7};
        int[] res=obj.rotate(array,2);
        for(int i:res){
            System.out.println(i);
        }
    }
}
