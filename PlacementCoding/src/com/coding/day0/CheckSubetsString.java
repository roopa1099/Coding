package com.coding.day0;

import java.util.HashMap;

/**
 * Check if given string is a subseqnce(not substring).
 * Exmplw: codingminutes, mine
 * Answer Yes
 */
public class CheckSubetsString {

    public static boolean substringOrNot(String str, String substr){
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:substr.toCharArray()){
            if(map.containsKey(ch))
                map.put(ch,map.get(ch)+1);
            else
                map.put(ch,1);
        }

        char[] array=str.toCharArray();
        int uniqueChar=0;
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])-1);
                if (map.get(array[i])==0){
                    uniqueChar++;
                }
            }


            if (uniqueChar== map.size()){
                return true;
            }


        }
            return false;

    }

    public static void main(String[] args){
        String str1="codingminutes";
        String substr="cines";
        System.out.println(substringOrNot(str1,substr));
    }
}
