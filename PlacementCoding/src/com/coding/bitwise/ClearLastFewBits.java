package com.coding.bitwise;

/**
 * Clear last k bits in a number, i.e make it 0;
 */
public class ClearLastFewBits {

    public static int clearBits(int m,int lastBitNumber){
//        1111100=>(~0<<2)
        int mask=~0<<lastBitNumber;
        return m&mask;
    }
    public static void main(String[] args){
        int num=15;
        System.out.println(clearBits(num,2));
    }
}
