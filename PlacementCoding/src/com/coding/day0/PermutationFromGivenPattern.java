package com.coding.day0;

import java.util.HashMap;
import java.util.Map;

/**
 * t(n)=O(n)
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 *
 * Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:
 *
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * If a string has ‘n’ distinct characters, it will have n!
 * n!
 *  permutations.
 *
 * Example 1:
 *
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 */

public class PermutationFromGivenPattern {
    public static boolean findPermutation(String str, String pattern) {
        // TODO: Write your code here

        Map<Character,Integer> map=new HashMap<>();
        // frequncy map for pattern;
        int uniqueChar=0,start=0;
        for(char c:pattern.toCharArray()){
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }
        char[] array=str.toCharArray();
        for(int i=0;i<array.length;i++){
            // decrease coun from map
            if(map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])-1);

                // if a particular frequency of char is 0, then one unique character we have covered
                if(map.get(array[i])==0){
                    uniqueChar++;
                }
            }

            // if window size greater than pattern then shrink window size
            if((i-start+1)>pattern.length()){
                char st=array[start];
                start++;
                // if part of frequency map, then increase count ad adjust uniqueChar count
                if(map.containsKey(st)){
                    if(map.get(st)==0)
                        uniqueChar--;
                    map.put(st,map.get(st)+1);
                }
            }

            // if length of uniqueChar mathces length of map, we have covered everuthing
            if(uniqueChar==map.size()){
                return true;
            }


        }
        return false;
    }

    public static void main(String[] args){
        String str="abbcabc";
        String pattern="abc";

        System.out.println( findPermutation(str,pattern));
    }
}
