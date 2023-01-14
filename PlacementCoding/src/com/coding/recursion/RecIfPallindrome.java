package com.coding.recursion;

/**
 * Chck if number is pallindrome
 */
public class RecIfPallindrome {

    public static boolean isPallindorme(String strNumber, int start, int end) {

        if(start==strNumber.length()/2){
            // when number is of odd length
            if(start==end){
                return true;
            }
            else{
                // number is of even length
                if(strNumber.charAt(start)==strNumber.charAt(end)){
                    return true;
                }
                return false;
            }
        }

        boolean ifPallindrome=isPallindorme(strNumber, start+1, end-1);
        if(ifPallindrome && strNumber.charAt(start)==strNumber.charAt(end)){
                return true;
        } 
            return false; 
    }

    public static void checkPallindorme(int number) {
        String strNumber=String.valueOf(number);
        System.out.print(isPallindorme(strNumber, 0, strNumber.length()-1));
        
    }
    
    public static void main(String[] args) {
        checkPallindorme(3220);
    }
}
