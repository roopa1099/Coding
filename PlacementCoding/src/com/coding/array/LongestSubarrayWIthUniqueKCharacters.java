package com.coding.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * Example 1:
 *
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Here unique means togeher all characters in the subarray, like only  distinct characters in entire sub arrays
 */

public class LongestSubarrayWIthUniqueKCharacters {
    public static int findLength(String str, int k) {
        // TODO: Write your code here
        int start=0, maxLength=0,tempLength;
        Map<Character,Integer> map=new HashMap<>();

        char[] stringArray=str.toCharArray();
        for(int i=0;i<stringArray.length;i++){
            char current=stringArray[i];
            if(map.containsKey(current)){
                map.put(current,map.get(current)+1);
            }
            else{
                map.put(current,1);
            }
            while(map.size()>k){
                map.put(stringArray[start],map.get(stringArray[start])-1);

                if(map.get(stringArray[start])==0){
                    map.remove(stringArray[start]);
                }
                start++;
            }
            tempLength=i-start+1;
            maxLength=Math.max(maxLength,tempLength);

        }
        return maxLength;
    }

    public static void main(String[] args){
        String str="araaci";
        int val=findLength(str,2);
        System.out.println(val);
    }

}
