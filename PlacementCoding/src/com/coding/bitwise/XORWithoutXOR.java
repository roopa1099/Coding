package com.coding.bitwise;


/**
 * Given two integers, find their XOR without using the XOR operator.
 */
public class XORWithoutXOR {

    public static int xor(int x, int y) {
        return (x|y)-(x&y);
    }
    public static void main(String[] args) {
        System.out.println(xor(3,3));
    }
}
