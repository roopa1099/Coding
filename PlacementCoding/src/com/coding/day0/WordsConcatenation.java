package com.coding.day0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Given a string and a list of words, find all the starting indices of substrings in the given string that are a concatenation of all the given words exactly once without any overlapping of words. It is given that all words are of the same length.
 *
 * Example 1:
 *
 * Input: String="catfoxcat", Words=["cat", "fox"]
 * Output: [0, 3]
 * Explanation: The two substring containing both the words are "catfox" & "foxcat".
 */
public class WordsConcatenation {

    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int j;
        // TODO: Write your code here
        Map<String,Integer>map=new HashMap<>();
        char[] array=str.toCharArray();
        for(String val:words){
            if(map.containsKey(val)){
                map.put(val,map.get(val)+1);
            }
            else{
                map.put(val,1);
            }
        }


        // i can move max upto length-(words*no. of char){no. of char is same for al words in pattern}
        // becoz the subarray will be contiguos so last letter will be word*no of char a head of first letter in the subarray
        for(int i=0;i<=str.length()-(words.length*words[0].length());i++){
            // j represents the number of words in the pattern
            Map<String,Integer> tempMap=new HashMap<>();
            for(j=0;j<words.length;j++){
                int startPosOfEachWord=i+j*words[0].length();
                int endPosOfEachWord=startPosOfEachWord+words[0].length();
                String check=str.substring(startPosOfEachWord,endPosOfEachWord);
                if(!map.containsKey(check)){
                    break;
                }

                if(tempMap.containsKey(check))
                    tempMap.put(check,tempMap.get(check)+1);

                else
                    tempMap.put(check,1);


                if(tempMap.get(check)>map.get(check))
                    break;

                if(j+1==words.length)
                    resultIndices.add(i);


            }

        }

        return resultIndices;
    }
    public static void main(String[] args){
        String str="catfoxcat";
        String[] words= {"cat", "fox"};

        System.out.println(findWordConcatenation(str,words));
    }
}
