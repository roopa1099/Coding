/**
 * Given a sorted and rotated array arr[] of size N and a key, the task is to find the key in the array.
 *
 *         Note: Find the element in O(logN) time and assume that all the elements are distinct.
 */
package com.coding.array;

public class SearchElementInRotatedArray {

    private int pivotElement(int[] array,int length){
        int start=0,end=length-1;
        while(start<end){
            int mid=(start+end)/2;
            if(array[mid]>array[mid+1])
                return mid+1;
            else if(array[mid]<array[mid-1])
                return mid;
            else if(array[mid]<array[start]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }

        return 0;
    }


    public int findElement(int[] array,int length,int search){
        int pivot=pivotElement(array,array.length);
        int res;
        if(search<array[0] && search>array[pivot]){
            res=binarySearch(array,pivot+1,array.length-1,search);
        }
        else if(search>array[0] && search>array[pivot]){
            res=binarySearch(array,0,pivot-1,search);
        }
        else if(search<array[pivot]){
            return -1;
        }
        else
            return 1;
        return res;
    }

    private int binarySearch(int[] array, int start, int end, int search) {

        while(start<=end){
            int mid=(start+end)/2;
            if(search<array[mid]){
                end=mid-1;
            }
            else if(search>array[mid]){
                start=mid+1;
            }
            else{
                return 1;
            }
        }

        return -1;
    }



    public int findElement2(int[] array,int start,int length,int search){
//        instead of pivot element, we take compare with sorted part of array
        int res=0,end=length;
            int mid=(start+end)/2;
            if(array[mid]==search){
                res=mid;
            }
            else if(array[mid]>array[start]){
//                left side is sorted
                if(search>array[start]){
                    res=findElement2(array,start,mid-1,search);
                }
                else{
                    res=findElement2(array,mid+1,end,search);
                }
            }
            else {
//right side is sorted
                if(array[mid]<array[end]){
                    res=findElement2(array,mid+1,end,search);
                }
                else{
                    res=findElement2(array,start,mid-1,search);
                }

            }
        return res;
    }



    public static void main(String[] args){
        SearchElementInRotatedArray obj=new SearchElementInRotatedArray();
        int[] array={32,35,42,52,62,2,12,17};
        int res=obj.findElement(array,array.length,35);
        System.out.println(res);
        System.out.println(obj.findElement2(array,0,array.length-1,12));

    }
}
