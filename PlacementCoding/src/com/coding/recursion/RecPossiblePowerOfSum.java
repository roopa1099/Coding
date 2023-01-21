package com.coding.recursion;

/**
 * Given two integers x and n, we need to find number of ways to express x 
 * as sum of n-th powers of unique natural numbers. It is given that 1 <= n <= 20.
 */
public class RecPossiblePowerOfSum {

    public static int possSum(double target, int pow, int num) {

        int diff = (int) (target - Math.pow(num, pow));

        if (diff == 0)
            return 1;

        if (diff < 0)
            return 0;

        // include the diff and once do not include target
        return possSum(target, pow, num + 1) + possSum(diff, pow, num + 1);
    }

    public static void main(String[] args) {
        System.out.print(possSum(100, 2, 1));
    }
}
