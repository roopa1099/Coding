package com.coding.day0;

/**
 * IMPORTANT
 *
 * Find and print all possible subsequence
 *
 * time= O(2^n)
 */
public class RecAllPossibleSubsequence {

    public static void subsequence(String word, int index, String newString){

        if(index==word.length()){
            System.out.print(newString+" ");
            return;
        }

        char chr=word.charAt(index);

        //include
        subsequence(word,index+1,newString+chr);

        //exclude
        subsequence(word,index+1,newString);
    }

    public static void main(String[] args){
        subsequence("abcd",0,"");
    }
}
