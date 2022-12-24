package com.coding.day0;

/**
 * Get bit at ith pos.
 */
public class BitwiseGetBitByPos {

    public static int getBit(int num, int pos){
        int leftShift=1<<pos;
//         & with 1 is and only if that bit is 1, else it will be zero 1<<2=00000100, so we and with 1 at that
//        that pos.
        if((num & leftShift)==0)
            return 0;
        return 1;

    }

    public static void main(String[] args){
        System.out.println(getBit(28,3));
    }
}
