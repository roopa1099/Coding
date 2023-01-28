package com.coding.Miscellaneous;


/**
 * **********IMPORTANT******************
 * Given a positive number, convert the number to the corresponding Excel column name.
 */
public class FindStringFromNumber {
    
    public static StringBuilder convertNumToStr(int num) {
        StringBuilder str=new StringBuilder("");
        // 0 represents 0 and Z represent Z
        while(num>0){
            int ind=(num-1)%26;
            str=str.append((char)(ind+'A'));
            num=(num-1)/26;
        }
        return str.reverse();
    }
    public static void main(String[] args) {
        System.out.println(convertNumToStr(962));
    }
}
