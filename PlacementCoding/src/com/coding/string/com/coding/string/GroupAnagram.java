package com.coding.string;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
 * the original letters exactly once.
 */
public class GroupAnagram {

    private static String sort(String str){
        char[] array=str.toCharArray();
        Arrays.sort(array);
        StringBuilder string=new StringBuilder();
        for(char chr:array)
            string.append(chr);
        return string.toString();
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        List<List<String>> result=new ArrayList<>();


        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            String sorted=sort(str);
            if(map.containsKey(sorted)){
                List<String> list=map.get(sorted);
                list.add(str);
                map.put(sorted,list);
            }
            else{
                List<String> list=new ArrayList<>();
                list.add(str);
                map.put(sorted,list);
            }
        }


        for(List<String> val:map.values()){
            result.add(val);
        }

        return result;

    }

    public static void main(String[] args){
        String[] array={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(array));
    }
}
