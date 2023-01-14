package com.coding.recursion;

/**
 * Revrse string using recursion
 */

public class RecReverseString {

    public static StringBuilder reverse(StringBuilder word,int index) {
        if(index==word.length()-1){
           StringBuilder newWord=new StringBuilder("");
           newWord.append(word.charAt(index));
           return newWord;
        }
        StringBuilder revrseStr=reverse(word, index+1);
        revrseStr=revrseStr.append(word.charAt(index));
        return revrseStr;
        
    }

    public static void main(String[] args) {
        StringBuilder word=new StringBuilder("my world");
        System.out.println(reverse(word, 0));
    }
    
}
