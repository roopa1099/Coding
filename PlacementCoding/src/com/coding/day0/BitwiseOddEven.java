package com.coding;

/**
 * Usinf bitwise find number is odd or even
 */
public class BitwiseOddEven {
    /**
     * In odd the last bit is 1 so, 1 & 1==1 and 0 & 1=0
     * @param args
     */
    public static void main(String[] args){
        int value=39;
        if((value & 1)==1){
            System.out.println("Odd");
        }
        else{
            System.out.println("Even");
        }
    }
}
