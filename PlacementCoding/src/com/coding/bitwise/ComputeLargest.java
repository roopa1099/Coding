package com.coding.bitwise;

/**
 * Compute the minimum or maximum of two integers without branching
 */
public class ComputeLargest {
    

    public static void smallerGreater(int x,int y) {

        // n & -1 = n

        int small= y^((x^y) & -(x<y?1:0));

        int large= x^((x^y) & -(x<y?1:0));

        System.out.println("Smaller: "+small+" Larger: "+large);
        
    }

    public static void main(String[] args) {
        smallerGreater(54, 9);
    }
}
