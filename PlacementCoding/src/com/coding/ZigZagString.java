package com.coding;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 */
public class ZigZagString {

//    Make a stringbuilder array of mentioned rows, if index is 0, then increatment by 1, if index is mentioned
//    rows-1 ten decrement by 1, and add in builder.
    public static String convert(String s, int numRows) {
        StringBuilder[] pattern=new StringBuilder[numRows];

        if(numRows<=1)
            return s;

        for(int i=0;i<numRows;i++){
            pattern[i]=new StringBuilder("");
        }

        int index=0;
        int increment=1;
        for(int i=0;i<s.length();i++){
            pattern[index].append(s.charAt(i));

            if(index==0)
                increment=1;
            if(index==numRows-1)
                increment=-1;

            index=index+increment;
        }


        String result=new String("");
        for(int j=0;j<pattern.length;j++)
            result=result+pattern[j];



        return result;
    }

    public static void main(String[] args){
        int[][] array={{4,5},{7,8}};
        System.out.println(convert("PAYPALISHIRING",4));
    }
}
