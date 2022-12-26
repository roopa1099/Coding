package com.coding.array;
//check
public class DecimalToBinary {

    public static double binary(int number){
        double pow=0,result=0;
        while (number>0){
            int rem=number%2;
            number=number/2;
            result=Math.pow(10,pow)+rem;
            pow++;
        }

        return result;
    }

    public static void main(String[] args){
        int num=15;
        System.out.println(binary(num));
    }
}

