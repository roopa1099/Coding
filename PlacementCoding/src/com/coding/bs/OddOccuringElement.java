package com.coding.bs;


/**
 * 25Dec
 * Given an integer array where every element appears an even number of times, 
 * except one element which appears an odd number of times. If the identical elements 
 * 
 * appear in pairs in the array and there cannot be more than two consecutive occurrences
 *  of an element, find the odd occurring element in logarithmic time and constant space.
 */
public class OddOccuringElement {
    
    public static int oddOccuringElement(int[] array){

        int start=0,end=array.length-1,value=-1;
        while(start<end){
            int mid=(start+end)/2;
            if(array[mid]!=array[mid+1] && array[mid]!=array[mid-1]){
                value=array[mid];
                break;
            }
            else if(mid%2==0 && array[mid]==array[mid+1]){
                start=mid+1;
            }
            else if(mid%2==0 && array[mid]!=array[mid+1]){
                end=mid-1;
            }

            else if(mid%2==1 && array[mid]==array[mid-1]){
                start=mid+1;
            }
            else if(mid%2!=0 && array[mid]!=array[mid-1]){
                end=mid-1;
            }
        }

        return value;
    }


    public static void main(String[] args)
    {
        int[] list = {2, 2, 3, 3, 2, 2, 4, 4, 3, 1, 1};
        System.out.println(oddOccuringElement(list));
    }
}
