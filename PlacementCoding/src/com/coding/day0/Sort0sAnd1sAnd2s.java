package com.coding.day0;

/**
 * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat
 * numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 *
 * The flag of the Netherlands consists of three colors: red, white and blue; and since
 * our input array also consists of three different numbers that is why it is called Dutch National Flag problem.
 *
 * Example 1:
 *
 * Input: [1, 0, 2, 1, 0]
 * Output: [0, 0, 1, 1, 2]
 */
public class Sort0sAnd1sAnd2s {
    /**
     * Taking a low and high, place 0 before low, and 2s after high
     * @param arr
     */
    public static void sort(int[] arr) {
        // TODO: Write your code here
        int low=0,high=arr.length-1;
        for(int i=0;i<=high;){
            int temp;

            if(arr[i]==0){
                temp=arr[low];
                arr[low]=arr[i];
                arr[i]=temp;
                low++;
                i++;
            }
            else if(arr[i]==1){
                i++;
            }
            else{
                temp=arr[high];
                arr[high]=arr[i];
                arr[i]=temp;
                high--;
            }
        }
    }


    public static void main(String[] args){
        int[] array={2,2,0,1,2,1,1,0,1};
        sort(array);
        System.out.println(array);
    }
}
