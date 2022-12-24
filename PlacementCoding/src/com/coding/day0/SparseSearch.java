package com.coding.day0;

/**
 * Given a sorted array containg spaces, find positio of given string.
 */
public class SparseSearch {

    public static int search(String[] array, int start, int end,String search){


        while(start<=end){
            int mid=(start+end)/2;
            if(array[mid]==" "){
                int right=mid+1;
                int endLeft=mid-1;
                while(array[right]==" " && right<=end && endLeft>=start && array[endLeft]==" "){
                    right++;
                    endLeft--;
                }

                if(array[right]!=" "){
                    mid=right;

                }

                if(array[endLeft]!=" "){
                    mid=endLeft;
                }

                if(array[mid]==search){
                    return mid;
                }
                else if(array[mid].compareTo(search)>1){
                    end=mid-1;
                    search(array,start,end,search);
                }
                else{
                    start=mid+1;
                    search(array,start,end,search);
                }
            }
            else if(array[mid]==search){
                return mid;
            }

            else if(array[mid].compareTo(search)>0){
                end=mid-1;
                search(array,start,end,search);
            }
            else{
                start=mid+1;
                search(array,start,end,search);
            }
        }

        return -1;
    }

    public static void main(String[] args){
        String[] arr={"cat"," ","mat","rat"," "," ","sat"};

        System.out.println( search(arr,0,arr.length-1,"mat"));
    }
}
