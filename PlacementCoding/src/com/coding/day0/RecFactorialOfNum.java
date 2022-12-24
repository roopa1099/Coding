package com.coding.day0;

/*
Factorial of number
 */
public class RecFactorialOfNum {

    public static int factorial(int num, int prod){


        if(num==0){
            return prod;
        }
        prod=num*(factorial(num-1,prod));
        return prod;
    }

    public static void main(String[] args){
    System.out.println(factorial(5,1));
    }
}
