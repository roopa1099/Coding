package com.coding.recursion;

/**
 *Given an array of positive and negative integers, segregate them without changing the relative order of elements. The output should 
 contain all positive numbers follow negative numbers while maintaining the same relative ordering.
 */
public class RecPosNegInt {

    public static void merge(int[] array, int start, int end, int mid) {

        int[] array1 = new int[mid - start + 1];
        int[] array2 = new int[end - (mid + 1) + 1];

        int p1 = 0, p2 = 0, ind = start;

        for (int i = start; i <= mid; i++) {
            array1[p1] = array[i];
            p1++;
        }

        for (int i = mid + 1; i <= end; i++) {
            array2[p2] = array[i];
            p2++;
        }

        p1 = 0;
        p2 = 0;

        while (p1 < array1.length && array1[p1] < 0) {
            array[ind] = array1[p1];
            ind++;
            p1++;
        }

        while (p2 < array2.length && array2[p2] < 0) {
            array[ind] = array2[p2];
            ind++;
            p2++;
        }

        while (p1 < array1.length) {
            array[ind] = array1[p1];
            ind++;
            p1++;
        }

        while (p2 < array2.length) {
            array[ind] = array2[p2];
            ind++;
            p2++;
        }

    }

    public static void divide(int[] array, int start, int end) {

        if (start >= end)
            return;
        int mid = (start + end) / 2;
        divide(array, start, mid);
        divide(array, mid + 1, end);
        merge(array, start, end, mid);
    }

    public static void main(String[] args) {
        int[] array = { 3, -1, 5, -22, -6, -8, 2, 5 };
        divide(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
