package com.coding.bs;

/**
 * 25Dec
 * Given a sorted integer array, find the floor and ceiling of a given number in it. 
 * The floor and ceiling map the given number to the largest previous or the smallest 
 * following integer in the array.
 */
public class FloorAndCeilngOfNumber {
    
    static int ceiling=-1,floor=-1;
    public static void findFloor(int[] nums,int number, int start, int end){
        if(number<=nums[start]){
            floor=nums[start];
            return;
        }

        int mid=(start+end)/2;
        if(nums[mid]>=number && nums[mid-1]<number)
            {
                floor=nums[mid];
                return;
            }
        else if(nums[mid]<number)
            findFloor(nums, number, mid+1, end);
        else
              findFloor(nums, number, start, mid-1);
    }

    public static void findCeiling(int[] nums,int number, int start, int end){
        if(number>=nums[end]){
            ceiling=nums[end];
            return;
        }

        int mid=(start+end)/2;
        if(nums[mid]<=number && nums[mid+1]>number)
            {
                ceiling=nums[mid];
                return;
            }
        else if(nums[mid]<number)
            findCeiling(nums, number, mid+1, end);
        else
        findCeiling(nums, number, start, mid-1);
       
    }

    public static void findFloorCeilng(int[] array, int number){
        if(number<array[0]){
            System.out.println("Ceiling "+-1);
            System.out.println("Floor "+ array[0]);
        }

       else if(number>array[array.length-1]){
            System.out.println("Ceiling "+ array[array.length-1]);
            System.out.println("Floor "+ -1);
        }
        else{
            findCeiling(array, number, 0, array.length-1);
            findFloor(array, number, 0, array.length-1);
            System.out.println("Ceiling "+ ceiling);
            System.out.println("Floor "+ floor); 
        }
    }

    public static void main(String[] args)
    {
        int[] words = {1, 4, 6, 8, 9};
        findFloorCeilng(words,10);
    }
}
