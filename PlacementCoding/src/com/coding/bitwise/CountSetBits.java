package com.coding.bitwise;

/**
 * Return Number of set bits i.e number of binary 1.
 */
public class CountSetBits {

    public static int bitsCount(int number){
//goes through every bit
        int count=0;
        while(number>0){
            int lastBit=number & 1;
            count=count+lastBit;
            number=number>>1;
        }

        return count;
    }

    public static int bitsCountOPtimised(int number){
//only bits having 1
        int count=0;
        while(number>0){
            count++;
//            the below expression reduces every 1 to 0, hence only covering number of 1
            number=number&(number-1);
        }

        return count;
    }


    public static void main(String[] args){
        System.out.println(bitsCount(11));
        System.out.println(bitsCountOPtimised(11));
    }
}
