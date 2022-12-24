package com.coding.day0;

/**
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 *
 * Example 1:
 *
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 */
public class SortSquaresOfArray {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        // TODO: Write your code here
        int start=0;
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]*arr[i];
        }

        int smallestIndex=0,smallest=arr[0];
        for(int i=1;i<arr.length;i++){
            if(smallest>arr[i]){
                smallest=arr[i];
                smallestIndex=i;
            }
        }

        if(smallestIndex==0){
            return arr;
        }

        int pos=smallestIndex;
        int neg=smallestIndex-1;

        while(neg>=0 && pos<arr.length){
            if(arr[pos]<=arr[neg]){
                squares[start]=arr[pos];
                pos++;
            }
            else{
                squares[start]=arr[neg];
                neg--;
            }
            start++;
        }

        while(neg>=0){
            squares[start]=arr[neg];
            neg--;
            start++;
        }

        while(pos<arr.length){
            squares[start]=arr[pos];
            pos++;
            start++;
        }

        return squares;
    }

    /**
     * Another approach can be, we know the ends contains the max values, so we can start comparing values
     * at both ends, which ever is bigger we can assign from the last of the result array
     *
     * e can avoid finding the smallet square
     */


    public static void main(String[] args){
        int[] array={-5,-3,0,2,4,5};
        int[] res=makeSquares(array);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }

    }

}
