package com.coding.recursion;

/**
 * decimal to binary
 */
public class RecDecToBin {

    public static int decToBin(int number) {

        if(number/2==0){
            int bin=number%2;
            return bin;
        }
        int bin=decToBin(number/2);
        bin=(bin*10)+(number%2);
        return bin;
        
    }
    
    public static void main(String[] args) {
        System.out.print(decToBin(9));
    }
}
