package com.coding.bitwise;


/**
 * Set bit at ith pos.
 */
public class BitwiaeSetAtPos {

    public static int setBit(int num, int pos){
        int leftShift=1<<pos;
//         & with 1 is and only if that bit is 1, else it will be zero 1<<2=00000100, so we and with 1 at that
//        that pos.
        return num | leftShift;

    }
    public static int clearBit(int num, int pos){
        int leftShift=~(1<<pos);
//        All bits, except that ith bit to be 1 bcoz 1&0=0 and 1&1=1
        return num & leftShift;

    }

    public static void main(String[] args){
        System.out.println(setBit(5,3));
        System.out.println(clearBit(5,2));
    }
}
