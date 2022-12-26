package com.coding.recursion;

import java.util.HashSet;

public class RecUniqueSubsequence {

    public static void subsequence(String word, int index, String newString, HashSet<String> setCheck){

        if(index==word.length()){
//            Since we are only printing in the final stage, we only need to put check here
            if(!setCheck.contains(newString)){
                setCheck.add(newString);
                System.out.print(newString+" ");
            }

            return;
        }

        char chr=word.charAt(index);

        //include
        subsequence(word,index+1,newString+chr,setCheck);

        //exclude
        subsequence(word,index+1,newString,setCheck);
    }

    public static void main(String[] args){
        HashSet<String> set=new HashSet<>();
        subsequence("aaa",0,"",set);
    }
}
