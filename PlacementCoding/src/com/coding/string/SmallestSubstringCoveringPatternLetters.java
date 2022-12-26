package com.coding.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern, find the smallest substring in the given string which has all the character occurrences of the given pattern.
 *
 * Example 1:
 *
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 */

public class SmallestSubstringCoveringPatternLetters {

    public static String findSubstring(String str, String pattern) {
        // TODO: Write your code here
        Map<Character,Integer> map=new HashMap<>();
        int uniqueChar=0,start=0,end=0,minLength=9999,strStart=0,strEnd=0;
        char[] array=str.toCharArray();
        for(char val:pattern.toCharArray()){
            if(map.containsKey(val))
                map.put(val,map.get(val)+1);
            else
                map.put(val,1);
        }

        for(end=0;end<array.length;end++){

            if(map.containsKey(array[end])){
                map.put(array[end],map.get(array[end])-1);
                if(map.get(array[end])==0)
                    uniqueChar++;
            }

            while(uniqueChar==map.size()){
                char st=array[start];

                if(minLength>(end-start+1)){
                    minLength=end-start+1;
                    strStart=start;
                    strEnd=end;
                }

                if(map.containsKey(st)){
                    if(map.get(st)==0){
                        uniqueChar--;
                    }
                    map.put(st,map.get(st)+1);
                }
                start++;
            }
        }

        if(strEnd==0){
            return "";
        }


        return str.substring(strStart,strEnd+1);
    }

    public static void main(String[] args){
        String str="abbcabc";
        String pattern="abc";

        System.out.println( findSubstring(str,pattern));
    }
}
