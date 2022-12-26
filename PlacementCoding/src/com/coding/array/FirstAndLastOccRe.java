package com.coding.array;

/**
 * First and last occurebnce of givern chanaracter i word
 */
public class FirstAndLastOccRe {

    static int firstCount=-1, lastCount=-1;
    public static void occurence(int index,String word, char character){

        if(index==word.length()-1){
            return;
        }
        if(word.charAt(index)==character){
            if(firstCount==-1){
                firstCount=index;
            }
            else{
                lastCount=index;
            }
        }
        occurence(index+1,word,character);
    }

    public static  void main(String[] args){
        occurence(0,"chocolaote",'o');
        System.out.println(firstCount);
        System.out.println(lastCount);
    }
}
