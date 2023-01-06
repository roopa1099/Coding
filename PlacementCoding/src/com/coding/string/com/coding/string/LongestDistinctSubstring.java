package com.coding.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string, find the longest substring containing distinct characters.
 */
public class LongestDistinctSubstring {

    public static String longestSubstring(String word) {

        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> charPosMap = new HashMap<Character, Integer>();
        String finalString = "";
        int start = 0, pt = start;

        char[] wordArray = word.toCharArray();
        while (pt < word.length()) {
            while (charPosMap.containsKey(wordArray[pt])) {
                char element = wordArray[start];
                charPosMap.remove(element);
                start++;
            }
            charPosMap.put(wordArray[pt], pt);
            int length = pt - start + 1;
            if (maxLength < length) {
                maxLength = length;
                finalString = word.substring(start, pt + 1);
            }
            pt++;
        }

        return finalString;
    }

    public static void main(String[] args) {
        String words = "jhgjh";
        System.out.println(longestSubstring(words));
    }
}
