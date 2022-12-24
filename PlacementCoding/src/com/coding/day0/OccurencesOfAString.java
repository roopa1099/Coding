package com.coding.day0;

import java.util.ArrayList;

/**
 * Function to return all occurences of a small string in a givn string
 */
public class OccurencesOfAString {

    public static ArrayList<Integer> findPosition(String str, String substring){
        ArrayList<Integer> res=new ArrayList<>();
        int index=0;
        while(index<str.length() && str.indexOf(substring,index)!=-1){
            int val=str.indexOf(substring,index);
            res.add(val);
            index=val+1;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(findPosition("I liked the movie, acting in movie was great!","movie"));
    }
}
