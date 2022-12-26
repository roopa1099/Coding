package com.coding.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 */
public class PermutationOfGivenString {

    public boolean checkInclusion(String s1, String s2) {

        Map<Character,Integer> map=new HashMap<>();

        for(char ch:s1.toCharArray()){
            if(map.containsKey(ch))
                map.put(ch,map.get(ch)+1);
            else
                map.put(ch,1);
        }

        int uniqueChar=0,start=0;

        char[] chr=s2.toCharArray();
        for(int i=0;i<chr.length;i++){

            if(map.containsKey(chr[i])){
                map.put(chr[i],map.get(chr[i])-1);

                if(map.get(chr[i])==0)
                    uniqueChar++;
            }


            if((i-start+1)==s1.length()){

                if(uniqueChar==map.size())
                    return true;

                else{
                    if(map.containsKey(chr[start])){
                        map.put(chr[start],map.get(chr[start])+1);

                        if(map.get(chr[start])==1)
                            uniqueChar--;


                    }

                    start++;
                }
            }

        }

        return false;
    }
}
