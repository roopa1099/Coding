package com.coding;

import java.util.HashMap;

/**
 * Given a string, find the smallest window (substring) which contains all distinct
 * characters of the given input string.
 *
 * Sample Inputs
 *
 * aabcbcdbcaaad
 * aaaa
 */
public class OnlyDistinctCharacterSubarray {

    public static String findSubarray(String str){
        HashMap<Character,Integer> mapPos=new HashMap<>();
        int uniqueChar=0,start=0,minLength=Integer.MAX_VALUE, startPos=0,endPos=str.length();
        char[] array=str.toCharArray();

        for(char val:str.toCharArray()){
           mapPos.put(val,1);
        }

        for(int i=0;i<array.length;i++){
            char val=array[i];
            if(mapPos.containsKey(val)){
                mapPos.put(val,mapPos.get(val)-1);
                if(mapPos.get(val)==0)
                    uniqueChar++;
            }

            while(uniqueChar==mapPos.size()){

                if(minLength>(i-start+1)){
                    minLength=i-start+1;
                    startPos=start;
                    endPos=i;
                }

                if(mapPos.get(str.charAt(start))==0){
                    uniqueChar--;
                }
                mapPos.put(str.charAt(start),mapPos.get(str.charAt(start))+1);
                start++;
            }
        }
        return str.substring(startPos,endPos+1);
    }

    public static void main(String[] args){
        String word="aabcbcdbcaaad";
        System.out.println(findSubarray(word));
    }

}
