package com.coding;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in
 * haystack, or -1 if needle is not part of haystack.
 */
public class FirstIndexOfSubstrig {
    public static int strStr(String haystack, String needle) {

        if(!haystack.contains(needle)){
            return -1;
        }

        for(int i=0;i<haystack.length();i++){
            for(int j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)!=needle.charAt(j))
                    break;

                if(needle.length()-1==j)
                    return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        String word="sadbutsad";
        System.out.println(strStr(word,"sad"));
    }

}
