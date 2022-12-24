package com.coding.day0;

/**
 * Given an array of sorted numbers, remove all duplicate number instances from it in-place,
 * such that each element appears only once. The relative order of the elements should be kept
 * the same and you should not use any extra space so that that the solution have a space complexity
 * of O(1).
 *
 * Move all the unique elements at the beginning of the array and after moving return the length of
 * the subarray that has no duplicate in it.
 *
 * Example 1:
 *
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 */
public class RemoveDuplicate {
    public static int remove(int[] arr) {
        // TODO: Write your code here

        int i,start=0;
        for(i=0;i<arr.length-1;i++){
//            if duplicate keep moving a head
            while((i+1)<arr.length && arr[i]==arr[i+1]){
                i++;
            }
            arr[start]=arr[i];
            start++;
        }


        if(i==arr.length-1)
            arr[start]=arr[i];
        else
            start--;

        return (start-0+1);
    }

    public static void main(String[] args){
        int[] array={1,2,2,3, 4,4,4,4,4,5,6,7};
        int res=remove(array);
        System.out.println(res);
    }
}
