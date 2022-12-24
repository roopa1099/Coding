package com.coding.bs;

/**
 * Given a positive number, return the square root of it. If the number
 *  is not a perfect square, return the floor of its square root.
 */
public class SquareRoot {
    
    public static int findSquareRoot(int number){
        int end=number/2;
        int start=1, value=-1;

        while(start<=end){
            int mid=(start+end)/2;

            if(mid*mid==number){
                value=mid;
                break;
            }
            else if((mid*mid)<number){
                start=mid+1;
                value=mid;
            }
            else{
                end=mid-1;
            }
        }

        return value;
    }

    public static void main(String[] args) {
        System.out.println(findSquareRoot(441));
    }
}
