package com.coding.day0;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring, which has all distinct characters.
 *
 * Example 1:
 *
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring with distinct characters is "abc".
 */
public class AllDistinctElemetSubArrayMax {

    public static int findLength(String str) {
        // TODO: Write your code here
        Map<Character,Integer> map=new HashMap<>();
        char[] array=str.toCharArray();
        int tempLength,maxLength=0,start=0;
        for(int i=0;i<array.length;i++){
            char current=array[i];
            if(!map.containsKey(current)){
                map.put(current,i);
            }
            else{
                // update start with last index of current + 1
                start=map.get(current)+1;
                map.put(current,i);
            }
            tempLength=i-start+1;
            maxLength=Math.max(tempLength,maxLength);

        }
        return maxLength;
    }

    public static void main(String[] args){
        String str="abccde";
        int val=findLength(str);
        System.out.println(val);
    }
}
