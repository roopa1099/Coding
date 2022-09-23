package com.coding;
//Ask

/**
 *Given two strings containing backspaces (identified by the character ‘#’), check if the two
 * strings are equal.
 *
 * Example 1:
 *
 * Input: str1="xy#z", str2="xzz#"
 * Output: true
 * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
 * Input: str1="xywrrmp", str2="xywrrmu#p"
 * Output: true
 * Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 */

public class BackspaceStringComparison {

    public static boolean compare(String str1, String str2) {
        boolean doesItContainTheBackSpace = str1.contains("#") || str2.contains("#");
        int index1=str1.length()-1,index2=str2.length()-1,backSpace1=0;
        String output1 = new String("");
        String output2 = new String("");
        boolean check=false;
        if (doesItContainTheBackSpace==false){
            return false;
        }


          while(index1>=0){
              if(!(str1.charAt(index1)=='#')){
                  if(backSpace1>0){
                      backSpace1--;
                  }
                  else{
                      output1=str1.substring(index1,index1+1)+output1;
                  }
              }
              else{
                  backSpace1++;
              }
              index1--;
          }

          backSpace1=0;

        while(index2>=0){
            if(!(str2.charAt(index2)=='#')){
                if(backSpace1>0){
                    backSpace1--;
                }
                else{
                    output2=str2.substring(index2,index2+1)+output2;
                }
            }
            else{
                backSpace1++;
            }
            index2--;
        }

        if(!(output1.equals(output2)))
            return false;
        return true;
    }
    public static void main(String[] args){

        System.out.println(compare("abc#d##e","aa#b#e")); ;

    }
}
