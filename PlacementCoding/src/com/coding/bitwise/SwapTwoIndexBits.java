package com.coding.bitwise;

/**
 * Given an integer, swap two bits at given positions in a binary representation of it.
 */
public class SwapTwoIndexBits {

    // 2nd index means 3rd index, starting from 0 in the righ
    public static int swap(int num, int pos1,int pos2) {
        if((((num&(1<<pos1))>>pos1)^((num&(1<<pos2))>>pos2))==1){
            num=num^(1<<pos1);
            num=num^(1<<pos2);
        }

        return num;
        
    }

    public static void main(String[] args) {
        int num=31;
        System.out.println(swap(num, 2, 6));
    }
}