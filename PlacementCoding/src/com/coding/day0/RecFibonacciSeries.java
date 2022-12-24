package com.coding.day0;

public class RecFibonacciSeries {

    public static void fibonacci(int a,int b, int n,int seq){

        if(n==seq){
            return;
        }

            System.out.println(a);
            int temp=a;
            a=b;
            b=temp+b;
            fibonacci(a,b,n+1,seq);
    }

    public static void main(String[] args){
        fibonacci(0,1,0,7);
    }
}
