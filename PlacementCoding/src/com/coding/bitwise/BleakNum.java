package com.coding.bitwise;


/**
 * A number ‘n’ is called Bleak if it cannot be represented as sum of a positive number x 
 * and set bit count in x, i.e., x + countSetBits(x) is not equal to n for any non-negative number x.
 */
public class BleakNum {

    public static int ceilLog2(int num) {
        int count=0;
        while(num>0){
            num=num>>1;
            count++;
        }
        return count;
    }

    public static int countSetBits(int num) {

        int count=0;
        while(num>0){
            int n=num & 1;
            count=count+n;
            num=num>>1;
        }


        return count;
        
    }

    public static boolean isBleak(int num) {
        
        // Ex=100
        // ceilLog2(100)=7;
        // max binray digit possible is 7, so start from 93
        for(int i=num-ceilLog2(num);i<num;i++){
            if(i+countSetBits(i)==num)
                return false;
        }

        return true;

    }

    public static void main(String[] args) {
        int p=4;
        System.out.print(isBleak(p));
    }
    
}
