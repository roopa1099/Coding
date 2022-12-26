package com.coding.recursion;

/**
 * Sum of n numbers;
 */
public class RecFirstNNaturalNumbers {

    public static int sum(int n, int sum){
        if(n==0){
            return sum;
        }
        sum=n+sum(n-1,sum);
        return sum;
    }

    public static void main(String[] args){
        System.out.println(sum(10,0));
    }
}
