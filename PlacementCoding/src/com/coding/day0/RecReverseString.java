package com.coding;

/**
 * Reverse string
 */
public class RecReverseString {

    public  static void reverseString(int index,String word){
        if(index==0){
            System.out.print(word.charAt(index));
            return;
        }

        System.out.print(word.charAt(index));
        reverseString(index-1,word);
    }

    public static void main(String[] ags){
        reverseString(8,"chocolate");
    }
}
