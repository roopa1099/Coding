package com.coding.day0;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringLengthWithUniqueCharacters {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int start=0,maxLength=0;
        char[] array=s.toCharArray();
        for(int i=0;i<array.length;i++){


            while(map.containsKey(array[i])){
                map.remove(array[start]);
                start++ ;
            }

            map.put(array[i],i);
            int length=(i-start)+1;
            maxLength=Math.max(maxLength,length);
        }
        return maxLength;

    }

    public static void main(String[] args){
        String word="aabcbcdbcaaad";
        System.out.println(lengthOfLongestSubstring(word));
    }

}
