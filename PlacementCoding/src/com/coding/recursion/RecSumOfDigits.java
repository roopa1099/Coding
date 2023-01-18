package com.coding.recursion;

/**
 * Given a number, find the sum of its digits.
 */
public class RecSumOfDigits {

    public static int sumOfDigits(int num) {

        if(num/10==0){
            int sum=num;
            return sum;
        }

        int sum=sumOfDigits(num/10);
        sum=sum+(num%10);  
        return sum;
    }
    
    public static void main(String[] args) {
        int num=145;
        System.out.println(sumOfDigits(num));

    }
}
