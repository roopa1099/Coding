package com.coding.day0;

import java.util.Arrays;

/**
 * Given a string s and an integer k, return the length of the longest substring of s such that the
 * frequency of each character in this substring is greater than or equal to k.
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public static int longestSubstring(String s, int k) {

        int[] counts=new int[26];
        int maxLength=0;
        for(int uni=1;uni<=26;uni++){
            Arrays.fill(counts,0);
//             this loop is to check for 1 uniqe char, 2 unique char...26 unique char all possibiltites
            int end=0,start=0,moreThanK=0,uniqueInSub=0;
            while(end<s.length()){

                if(uniqueInSub<=uni){
//                     unique is less than uni number of unique characters move end pointer a head
                    char val=s.charAt(end);
                    int pos=(int)val-(int)'a';
                    counts[pos]++;
                    if(counts[pos]==1)
                        uniqueInSub++;
                    if(counts[pos]==k)
                        moreThanK++;
                    end++;
                }
                else{
//                     unique is less than uni number of unique characters reduce window size
                    char val=s.charAt(start);
                    int pos=(int)val-(int)'a';
                    counts[pos]--;
                    start++;
                    if(counts[pos]==0)
                        uniqueInSub--;
                    if(counts[pos]==k-1)
                        moreThanK--;
//                     we are not increassing end until the number of unique char<uni

                }

                if(uni==uniqueInSub && uniqueInSub==moreThanK)
                    maxLength=Math.max(maxLength,end-start);
            }
        }

        return maxLength;
    }

    public static void main(String[] args){

        System.out.println(longestSubstring("weitong",3));
    }

}
