package com.coding.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 6 jan
 * Find all substrings of a string that contains all characters of another string. 
 * In other words, find all substrings of the first string that are anagrams of the second string.


 */
public class AllPossiblePermutaion {

    public static List<String> permutations(String word, String permutation) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> countMap = new HashMap<>();
        int permutationCount = permutation.length();

        for (char chr : permutation.toCharArray()) {
            if (countMap.containsKey(chr)) {
                countMap.put(chr, countMap.get(chr) + 1);
            } else {
                countMap.put(chr, 1);
            }
        }

        char[] wordArray = word.toCharArray();
        int uniqueChars = 0;
        int start = 0, pt = start;
        while (start < word.length() - permutationCount + 1) {
            char element = wordArray[pt];
            if (countMap.containsKey(element)) {
                countMap.put(element, countMap.get(element) - 1);
            }

            if (countMap.containsKey(element) && countMap.get(element) == 0)
                uniqueChars++;

            if (uniqueChars == countMap.size()) {
                result.add(word.substring(start, pt + 1));
            }

            while (pt - start + 1 >= permutationCount) {
                char startChar = wordArray[start];
                start++;
                if (countMap.containsKey(startChar)) {
                    if (countMap.get(startChar) == 0) {
                        uniqueChars--;
                    }
                    countMap.put(startChar, countMap.get(startChar) + 1);
                }
            }
            pt++;
        }

        return result;
    }

    public static void main(String[] args) {
        String word = "ZYXZ";
        String permutaString = "XYZ";

        System.out.println(permutations(word, permutaString));
    }
}
