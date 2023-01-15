package com.coding.recursion;

/**
 * Given an array of integers, print a sum triangle from it such that the first level has all array elements. From then, at each level number of elements is one less than the previous level 
 * and elements at the level is be the Sum of consecutive two elements in the previous level. 
 */
public class RecTriangleSumArray {

    public static void prinTriangle(int[] array) {

        if (array.length == 2) {
            System.out.print(array[0] + array[1]);

        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
            return;
        }

        int[] newArray = new int[array.length - 1];
        int indx = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int sum = array[i] + array[i + 1];
            newArray[indx] = sum;
            indx++;
        }
        prinTriangle(newArray);

        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6};
        prinTriangle(array);
    }
}
