package com.coding.array;

/**
 * For a given array of n integers and assume that ‘0’ is an invalid number and all others as a
 * valid number. Convert the array in such a way that if both current and next element is valid and
 * both have same value then double current value and replace the next number with 0.
 * After the modification, rearrange the array such that all 0’s shifted to the end.
 * t(n)=O(n), space=(1)

 */

public class DoubleFirstElement {
    public int[] doubleElement(int[] array, int length){
        for(int i=0;i<length-1;i++){
            if(array[i]==array[i+1]){
                array[i]=array[i]+array[i+1];
                array[i+1]=0;
                i=i+1;
            }
        }

        int j=0,k=length-1;
//        while(j<k){
//            if(array[j]==0 && array[k]!=0){
//                int swap=array[j];
//                array[j]=array[k];
//                array[k]=swap;
//                k--;
//                j++;
//            }
//            else if(array[j]==0 && array[k]==0){
//                k--;
//            }
//            else{
//                j++;
//            }
//        }
        int count=0;
        for(j=0;j<length;j++){
            if(array[j]!=0){
                array[count]=array[j];
                count++;
            }
        }

        while(count<length){
            array[count]=0;
            count++;
        }
        return array;
    }


    public static void main(String[] args){
        int[] array={0,2,2,2,0,6,6,0,0,8 };
        DoubleFirstElement obj=new DoubleFirstElement();
        array=obj.doubleElement(array,array.length);
        for(int val:array){
            System.out.println(val);
        }
    }
}
