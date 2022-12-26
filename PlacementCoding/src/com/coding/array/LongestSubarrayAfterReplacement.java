package com.coding.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than k letters with any letter, find the length of the longest substring having the same letters after replacement.
 *
 * Example 1:
 *
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have the longest repeating substring "bbbbb".
 */

public class LongestSubarrayAfterReplacement {
    public static int findLength(String str, int k) {
        // TODO: Write your code here
        char[] array=str.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        int start=0,maxLength=0,tempLength,mapRepeatingCharLength=0;
        for(int i=0;i<array.length;i++){
            char current=array[i];
            if(map.containsKey(current))
                map.put(current,map.get(current)+1);
            else
                map.put(current,1);

            mapRepeatingCharLength=Math.max(mapRepeatingCharLength,map.get(current));

// check if characters in the subarray except the maxRepeating one's are less that k, so tha we can replcae it

            if(((i-start+1)-mapRepeatingCharLength)>k){
                // move start
                map.put(array[start],map.get(array[start])-1);
                start++;
            }
            tempLength=i-start+1;
            maxLength=Math.max(tempLength,maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args){
        String str="abecbbj";
        int val=findLength(str,2);
        System.out.println(val);
    }
}
