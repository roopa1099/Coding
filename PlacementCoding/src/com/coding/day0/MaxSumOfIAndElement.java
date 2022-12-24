package com.coding.day0;

/**
 * Question:Given an array arr[] of size N, the task is to find the maximum possible sum of i*arr[i]
 * when the array can be rotated any number of times.
 *
 *
 *
 *  Case 1- In case of rotated ascending array, the max some of i*arrayy[i] is when the array is in its
 *         normal acending order.
 *
 * Case 2- In a unsorted array,
 *
 * Lets consider P as total sum of elements=array[0]+array[1]+array[2]+array[3]+.....+array[n-1]
 *         Let given arrayof elements be n0,n1,n2,n3,......
 *
 * for first time sum S= n0*0 + n1*1 + n2*2 + .....
 *
 * after rotation 1, S1= n1*0 + n2*1 + n3*2 + .... + n0 * (N-1);
 *
 * S-S1= n1(1-0) +n2(2-1) + n3(3-2) + .... n(N-1 - (N-2)) + n0(0-(N-1))
 *
 * S-S1=n1+n2+n3+....+n(N-1)-n0(N-1)
 *
 * S-S1=(P-n0)-n0(N-1);
 *
 * S1=S-(P-n0)+(n0(N-1))
 *
 * S1=S-P+n0(N)=S+n0(N-2)-P=> for ith rotation => PrevSum+array[i-1](N)-TotalSum
 */



public class MaxSumOfIAndElement {

    public int maxSum(int[] array){
        int totalSum=0,prevSum=0,currentSum,maxSum;

        for(int i=0;i< array.length;i++){
            totalSum=totalSum+array[i];
            prevSum=prevSum+(array[i]*i);
        }
        maxSum=prevSum;

//        n elements=>1 to n-1 rotation
        for(int i=1;i<array.length;i++){
            currentSum=prevSum+array[i-1]*(array.length)-totalSum;
            maxSum=Math.max(maxSum,currentSum);
            prevSum=currentSum;
        }

        return maxSum;
    }

    public static void main(String[] Args){
        MaxSumOfIAndElement obj=new MaxSumOfIAndElement();
        int[]  array={10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(obj.maxSum(array));
}

}
