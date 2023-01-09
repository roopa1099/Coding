package com.coding.string;

/**
 * 9 jan
 * Given a string, find the maximum length contiguous substring of it that is also a palindrome.
 *  For example, the longest palindromic substring of “bananas” is “anana”, and the longest palindromic
 *  substring of “abdcbcdbdcbbc” is “bdcbcdb”.
 */
public class LongestPallindrome {

    public static String pallindromeString(String str, int low,int high){
        char[] array=str.toCharArray();
       while(low>=0 && high<str.length()){
        if(str.charAt(low)==str.charAt(high)){
            low--;high++;
        }
        else{
            break;
        }
     
       }

       return(str.substring(low+1,high));
    }


    public static String longestPallindrome(String str) {
        if(str==null || str.length()==0){
            return null;
        }
        int maxLength=Integer.MIN_VALUE;
        String maxString="";
        for(int i=0;i<str.length();i++){
            String currentPallindrome=pallindromeString(str, i, i);
            int length=currentPallindrome.length();
            if(length>maxLength){
                maxLength=length;
                maxString=currentPallindrome;
            }

            String currPallindrome=pallindromeString(str, i, i+1);
            length=currPallindrome.length();
            if(length>maxLength){
                maxLength=length;
                maxString=currPallindrome;
            }
        }

        return maxString;
    }
    
    public static void main(String[] args) {
        String str = "ABDCBCDBDCBBC";
        System.out.println(longestPallindrome(str));
    }
}
