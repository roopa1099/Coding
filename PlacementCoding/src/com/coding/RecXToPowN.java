package com.coding;

/**
 * X^n
 */

public class RecXToPowN {
    public static int pow(int x, int n,int mult){

        if(x==0)
            return 0;
        if(n==1)
            return x;

        mult=x*pow(x,n-1,mult);
        return mult;
    }

    public static int powLogNSpace(int x, int n,int mult){
//
//        n=n/2*n/2;
//        n/2=n/4*n/4;
        if(x==0)
            return 0;
        if(n==1)
            return x;

        if(n%2==0)
            mult=pow(x,n/2,mult)*pow(x,n/2,mult);
        else
            mult=pow(x,n/2,mult)*pow(x,n/2,mult)*x;
        return mult;
    }

    public static void main(String[] args){
        System.out.println(pow(7,3,1));
        System.out.println(powLogNSpace(7,3,1));
    }
}
