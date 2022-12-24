package com.coding.bs;

/**
 ************* Can reduce if condiitons******************
 */


/**
 * Given a nearly sorted array such that each of the n elements may be misplaced by no more than
 *  one position from the correct sorted order, search a given element in it efficiently. Report if the element is not present in the array.

An element at index i in a correctly sorted order can be misplaced by 
the ± 1 position, i.e., it can be present at index i-1 or i or i+1 in the input array.
 */
public class SmallestInMisplacedSortedrray {

    public static int findElement(int[] array, int target) {
        int start = 0, end = array.length, pos = -1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (target == array[mid]) {
                pos = mid;
                break;
            } else if (mid-1>=0 && array[mid - 1] >= array[mid] && array[mid - 1] > array[mid] && target == array[mid - 1]){
                pos = mid-1;
                break;
            }
            else if(mid+1<= array.length-1 && array[mid + 1] <= array.length-1 && array[mid + 1] < array[mid] && target == array[mid + 1]){
                pos=mid+1;
                break;
            }
            else if(mid-1>=0 && array[mid - 1] >= array[mid] && array[mid - 1] > array[mid] && target<array[mid] ){
                end=mid-2;
            }
            else if(mid+1<= array.length-1 && array[mid + 1] <= array[mid] && array[mid + 1] > array[mid] && target>array[mid]){
                start=mid+2;
            }
            else if(target<array[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] array={2, 1, 3, 5, 4, 7, 6, 8, 9};
        System.out.println(findElement(array, 5));
    }

}
