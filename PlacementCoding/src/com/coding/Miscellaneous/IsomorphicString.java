package com.coding.Miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, determine whether they are isomorphic. Two strings,
 *  X and Y, are called isomorphic if all occurrences of each character in X 
 * can be replaced with another character to get Y and vice-versa.

For example, consider strings ACAB and XCXY. They are isomorphic as we can map 
'A' —> 'X', 'B' —> 'Y' and 'C' —> 'C'.
 */
public class IsomorphicString {
    
    public static boolean isIsomorphic(String str1, String str2) {

        if(str1.length()!=str2.length()){
            return false;
        }

        Map<Character,Character> charMap=new HashMap<Character,Character>();

        int ptr1=0;
        while(ptr1<str1.length()){
            if(charMap.containsKey(str1.charAt(ptr1))){
                if(charMap.get(str1.charAt(ptr1))!=str2.charAt(ptr1)){
                    return false;
                }
            }
            else{
                charMap.put(str1.charAt(ptr1),str2.charAt(ptr1));
            }
            ptr1++;
        }
        return true;
    }
    public static void main(String[] args) {
        String string1="BACACAAB";
        String string2="YXZXZAXY";
        System.out.print(isIsomorphic(string1, string2));
    }
}
