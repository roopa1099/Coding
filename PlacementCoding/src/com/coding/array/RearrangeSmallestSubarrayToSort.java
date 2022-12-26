package com.coding.array;

/**
 * Given an array, find the length of the smallest subarray in it which when sorted will
 * sort the whole array.
 *
 * Example 1:
 *
 * Input: [1, 2, 5, 3, 7, 10, 9, 12]
 * Output: 5
 * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
 * Input: [1, 2, 3]
 * Output: 0
 * Explanation: The array is already sorted
 */

public class RearrangeSmallestSubarrayToSort {
    public static int sort(int[] arr) {
        // TODO: Write your code here
        int length=0,start=0,end=arr.length-1;

// array i descending order;
        if(arr[start]>arr[start+1] && arr[end-1]>arr[end]){
            return arr.length;
        }

        int lastPeak=arr.length-1;

        while(end>start){
            if(end==arr.length-1 && arr[end-1]>arr[end]){
                lastPeak=end;
                break;
            }


            if(end<arr.length-1 && arr[end]<arr[end+1] && arr[end]<arr[end-1]){
                lastPeak=end;
                break;
            }
            end--;
        }

        int firstPeak=0;
        while(start<end){
            if(start==0 && arr[start]>arr[start+1]){
                firstPeak=start;
                break;
            }


            if(start>0 && arr[start]>arr[start+1] && arr[start]>arr[start-1]){
                firstPeak=start;
                break;
            }
            start++;
        }

        int smallest=Integer.MAX_VALUE, largest=Integer.MIN_VALUE;
        for(int i=firstPeak;i<=lastPeak;i++){
            smallest=Math.min(smallest,arr[i]);
            largest=Math.max(largest,arr[i]);
        }

        int p=firstPeak-1,q=lastPeak+1;
        /**
         * if any number larger than the smallest number is peak subarray exists on the left side, then we need to extend the
         * smalest peak i.e. first peak towards left until we get correct position of the smallest element in the subaray
         *
         * similarly for elements smaller;  largest value inside peak subarray, should have all elements greater than it
         * on right side of subarray. So  elements smaller to largest value inside peak subarrayis checked and subarray
         * is extended
         */

        while(p>=0 && arr[p]>smallest){
            firstPeak--;
            p--;
        }

        while(q<arr.length && arr[q]<largest){
            lastPeak++;
            q++;
        }

        if(start==end && firstPeak==0 && lastPeak==arr.length-1)
            return 0;
        length=lastPeak-firstPeak;
        return length+1;
    }

    public static void main(String[] args){
        int[] array={1,4,2,10,5,4,8,3,4,5,6};

            System.out.println(sort(array));

    }
}
