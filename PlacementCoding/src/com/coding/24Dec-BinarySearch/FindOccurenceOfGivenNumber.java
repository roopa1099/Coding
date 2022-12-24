package com.coding;

/**
 * Given a sorted integer array containing duplicates, count occurrences of a given number. 
 * If the element is not found in the array, report that as well.
 */
public class FindOccurenceOfGivenNumber {

    private static int findPos(int[] array, int target,boolean firstPlace){

        int start=0,end=array.length-1,pos=-1;

        if(array.length==1)
            return 0;

        while(start<=end){
            int mid=(start+end)/2;
            if(array[mid]==target){
                pos=mid;
                if(firstPlace){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
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
    
    public static int findOccurence(int[] array,int target){
        int firstPos=findPos(array, target, true);
        int endPos=findPos(array,target,false);
        return endPos-firstPos+1;
    }

    public static void main(String[] args) {
        int[] array={2,2,5,5,5,5,6,7,7};
        System.out.println(findOccurence(array, 5));
    }
}
