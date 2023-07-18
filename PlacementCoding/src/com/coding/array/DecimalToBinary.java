package com.coding.array;

//check
public class DecimalToBinary {

    public static double binary(int number) {
        double result = 0, pow = 0;
        while (number > 0) {
            int rem = number % 2;
            number = number / 2;
            result = Math.pow(10, pow) * rem + result;
            pow++;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        int num = 3;
        System.out.println(binary(num));
    }
}
