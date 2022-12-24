package com.coding.day0;

/**
 * An ugly number is a positive integer that is divisible by a, b, or c.
 *
 * Given four integers n, a, b, and c, return the nth ugly number.
 */
public class UglyNumber3 {
    /**
     * different style of binary search
     * // first we take a random number and find aUbUc, if less than n then we increase low
     * // else we decrease high. We calculateanswer then apply binary search
     * @param a
     * @param b
     * @return
     */
    public static long gcd(long a,long b){
        if(a==0)
            return b;
        return(gcd(b%a,a));
    }

    private static long lcm(long a,long b){
        long val=(a*b)/gcd(a,b);
        return(val);
    }


    public static int nthUglyNumber(int n, int a, int b, int c) {
// different style of binary search
// first we take a random number and find aUbUc, if less than n then we increase low
// else we decrease high. We calculateanswer then apply binary search

        int low=1,high=Integer.MAX_VALUE;

        while(low<high){
            int mid=low + (high - low) / 2;
            int num=mid;

            int res=(int)((num / a) + (num / b) + (num / c)
                    - (num / lcm(a, b))
                    - (num / lcm(b, c))
                    - (num / lcm(a, c))
                    + (num / lcm(a, lcm(b, c)))); // lcm(a,b,c) = lcm(a,lcm(b,c))

            if(res<n)
                low=mid+1;
            else
                high=mid;
        }
        return (int)low;
    }
    public static void main(String[] args){
        int n=1000000000,a=2,b=217983653,c=336916467;
        System.out.println(nthUglyNumber(n,a,b,c));
    }
    }

