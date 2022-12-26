package com.coding.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 *
 * Every anagram is a permutation of a string. As we know, when we are not allowed to repeat characters while finding permutations of a string, we get N!
 * N!
 *  permutations (or anagrams) of a string having N
 * N
 *  characters. For example, here are the six anagrams of the string “abc”:
 *
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 *
 * Example 1:
 *
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 */


public class StartOfAllPossibleAnagramInString {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        // TODO: Write your code here
        int start=0,uniqueChar=0;
        Map<Character,Integer> map=new HashMap<>();
        char[] array=str.toCharArray();

        for(char val:pattern.toCharArray()){
            if(map.containsKey(val))
                map.put(val,map.get(val)+1);
            else
                map.put(val,1);
        }


        for(int i=0;i<array.length;i++){
            char current=array[i];
            if(map.containsKey(current)){
                map.put(current,map.get(current)-1);
                if(map.get(current)==0)
                    uniqueChar++;
            }

            if((i-start+1)>pattern.length()){
                char st=array[start];
                start++;
                if(map.containsKey(st)){
                    if(map.get(st)==0)
                        uniqueChar--;
                    map.put(st,map.get(st)+1);
                }
            }


            if(uniqueChar==map.size())
                resultIndices.add(start);
        }
        return resultIndices;
    }

    public static void main(String[] args){
        System.out.println(findStringAnagrams("abbcabc", "abc"));
    }

}
