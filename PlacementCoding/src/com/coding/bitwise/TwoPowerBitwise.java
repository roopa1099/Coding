package com.coding.bitwise;

/**
  * Find out wherther numbe is power of 2;
 */
public class TwoPowerBitwise {

    public static boolean power(int m) {
//    if m is a power of 2 then m & m-1 is always 0=>01000 & 00111
        if ((m & m-1)==0)
            return true;
        return false;
    }

    public static void main(String[] args){
        System.out.println(power(3));
    }
}
