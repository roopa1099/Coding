package com.coding.bitwise;


/**
 * Given an integer array of size n, with all its elements between 1 and n and one element occurring twice and one element missing. 
 * Find the missing number and the duplicate element in linear time and without using any extra memory.
 */
public class FindMissingAndDuplicate {

    public static void fndMissingDuplicate(int[] array) {
        int xorOfElements=array[0];
        // XOR of elements
        for(int i=1;i<array.length;i++){
            xorOfElements=xorOfElements^array[i];
        }

          // XOR of 1-n
          int xorOf1ToN=1;
          for(int i=2;i<=array.length;i++){
            xorOf1ToN=xorOf1ToN^i;
        }
        

        // XOR of both will give X^Y(X missing Y duplicate)
        int xorOfXAndY=xorOf1ToN^xorOfElements;

        int n=0,x=xorOfXAndY&1;
        int temp=xorOfXAndY;
        while(x!=1){
            n++;
            temp=temp>>1;
            x=temp & 1;
        }


    //  XOR  elements of array with 1<<n

    int num=1<<n;

        int setBit=0, unsetBit=0;

        for(int i=0;i<array.length;i++){
            if((array[i]&num)==0){
                unsetBit=unsetBit^array[i];
            }
            else{
                setBit=setBit^array[i];
            }
        }

// xor elements from 1-n with num

        for(int i=1;i<=array.length;i++){
            if((i&num)==0){
                unsetBit=unsetBit^i;
            }
            else{
                setBit=setBit^i;
            }
        }


        // find either of elemnts in array

        for(int i=0;i<array.length;i++){
            if(array[i]==unsetBit){
                System.out.println("Duplicate element is "+unsetBit);
                System.out.println("Missing element is "+setBit);
                break;
            }
            else if(array[i]==setBit){
                System.out.println("Duplicate element is "+setBit);
                System.out.println("Missing element is "+unsetBit);
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] array={3,1,4,5,6,1};
        fndMissingDuplicate(array);
    }

    
}
