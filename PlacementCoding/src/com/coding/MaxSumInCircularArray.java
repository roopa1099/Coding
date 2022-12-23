package com.coding;


/**
 * Circular array max sum:
 *
 * We neg all the elements, then find out sub array with max sum. Then that max sum is the most ne sum in the original array. So we subtract
 * cfrom total sum
 * Then we also calculate mx sum in the original array, kandane ago. Then we compare both the sums and return max
 */
public class MaxSumInCircularArray {

    public static int kandaneSum(int[] array){
        int maxSum=Integer.MIN_VALUE,sum=0;
        for(int i=0;i<array.length;i++){
            sum=sum+array[i];
            if(sum<0){
                sum=0;
            }
            maxSum=Math.max(maxSum,sum);
        }

        return  maxSum;
    }

    public static int sum(int[] array){

//        normal array max sum
        int totalSum=0;
        for (int i=0;i<array.length;i++){
            totalSum=totalSum+array[i];
        }
        int maxSum1=kandaneSum(array);

        for(int i=0;i<array.length;i++){
            array[i]=-1*array[i];
        }

        int maxSum2=kandaneSum(array);
        int finalsum2=totalSum-maxSum2;
        int maxSUm=Math.max(finalsum2,maxSum1);
        return maxSUm;

    }

    public static void main(String[] args){
        int[] x={2, 1, -5, 4, -3, 1, -3, 4, -1};
        System.out.println(sum(x));

    }
}
