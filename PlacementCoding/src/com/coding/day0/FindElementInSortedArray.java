package com.coding.day0;

/**
 * Given a sorted integer array containing duplicates,
 * count occurrences of a given number. If the element is not found in the array, report that as well.
 */

public class FindElementInSortedArray {

    static int pos=-1;
    public static int binarySearch(int[] array,int target, int start, int end){
        while(start<end){
            int mid=(start+end)/2;
            if(array[mid]==target){
                pos=mid;
                break;
            }
            else if(array[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return pos;
    }

    public static int countTarget(int[] array, int target){
        int pos=binarySearch(array,target,0,array.length-1);
        int count=0;
        if(pos==-1){
            return pos;
        }

        while(pos>0 && array[pos-1]==target){
            pos--;
        }

        while(pos<array.length && array[pos]==target){
            count++;
            pos++;
        }

        return count;
    }


    public static void main(String[] args){
        int[] x={2, 5, 5, 5, 6, 6, 7,7,7,7,7,8, 9, 9, 9};
        System.out.println(countTarget(x,9));

    }
}
