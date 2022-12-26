package com.coding.array;

/**
 * Given a list of non-negative integers, find the minimum number of merge operations to make it
 * a palindrome. A merge operation can only be performed on two adjacent elements.
 * The result of a merge operation is that the two adjacent elements are replaced with their sum.
 */
public class MergeForPallindrome {

    public static int countMerge(int[] array){
        int start=0,end=array.length-1;
        int count=0;
        while(start<=end){
            if(array[start]<array[end]){
                int sum=array[start], pt=start+1;
                while(sum<array[end]){
                    sum=sum+array[pt];
                    pt++;
                    count++;
                }

                if(sum>array[end]){
                    return -1;
                }
                else{
                    start=pt;
                    end--;
                }
            }

            else  if(array[start]>array[end]){
                int sum=array[end], pt=end-1;
                while(sum<array[start]){
                    sum=sum+array[pt];
                    pt--;
                    count++;
                }

                if(sum>array[start]){
                    return -1;
                }else{
                    start++;
                    end=pt;
                }
            }
            else{
                start++;
                end--;
            }
        }


        return count;
    }

    public static void main(String[] args){
        int[] array={6, 1, 3, 7};
        System.out.println(countMerge(array));
    }
}
