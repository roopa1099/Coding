package com.coding.day0;

/**
 * Find max length possible for a mountains peak, a peak is a sequnace of consecutively
 * increasing element then strictly decreasing elements.
 */
public class MaxMountainsPeakLength {

    public static int maxLengthPeak(int[] array){
        int maxLength=Integer.MIN_VALUE;
        for(int i=1;i<array.length-1;i++){

            if(array[i+1]<array[i] && array[i-1]<array[i]){
                int left=i;
                int right=i;
                int count=1;
                while(left>=1 && array[left]>array[left-1]){
                    count++;
                    left--;
                }

                while(right<array.length-1 && array[right]>array[right+1]){
                    count++;
                    right++;
                }

                maxLength=Math.max(maxLength,count);
            }
        }
        return maxLength;
    }

    public static void main(String[] args){
        int[] array={5,6,1,2,3,4,5,4,3,2,0,1,2,3,-2,4};
        System.out.println(maxLengthPeak(array));
    }
}
