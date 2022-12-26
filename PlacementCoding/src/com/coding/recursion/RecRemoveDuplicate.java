package com.coding.recursion;

/**
 * Remove duplicate characters using recursion
 */
public class RecRemoveDuplicate {


    static boolean[] visitedChar=new boolean[26];

    public static void removeDuplicate(String word,int index,String newWord){


        if(index==word.length()){
            System.out.println(newWord);
            return;
        }
        char chr=word.charAt(index);
        if(visitedChar[chr-'a']==true){
            removeDuplicate(word,index+1,newWord);
        }
        else{
            newWord=newWord+chr;
            visitedChar[chr-'a']=true;
            removeDuplicate(word,index+1,newWord);
        }


    }


    public static void main(String[] args){
        removeDuplicate("gdgfrufufnv",0,"");
    }
}
