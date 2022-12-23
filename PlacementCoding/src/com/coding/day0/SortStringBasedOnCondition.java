package com.coding;

import java.util.*;

/**
 * Sort a givrn array of strings based on a particular column i.e if a word i array is "102 105 109" and column is 2, then based on 105th pos we have to
 * sort all values, given length of all string are equal. And Sort either numeric wise or strin wise.
 */
public class SortStringBasedOnCondition {

    public static ArrayList<String> sort(int size, String[] arrayString, int column, String type,boolean reverse){
        if(type=="numeric"){
            ArrayList<String> res=new ArrayList<>();
            int[] tempArray=new int[size];
            HashMap<String,String> map=new HashMap<>();
            int pos=0;
            for(int i=0;i<arrayString.length;i++){
                String val=arrayString[i].split(" ")[column-1];
                tempArray[pos]=Integer.parseInt(val);
                map.put(val,arrayString[i]);
                pos++;
            }

                Arrays.sort(tempArray);
            for(int i:tempArray){
                res.add(map.get(String.valueOf(i)));
            }
            return res;

        }
        else{
            ArrayList<String> res=new ArrayList<>();
            String[] tempArray=new String[size];
            HashMap<String,String> map=new HashMap<>();
            int pos=0;
            for(int i=0;i<arrayString.length;i++){
                String val=arrayString[i].split(" ")[column-1];
                tempArray[pos]=val;
                map.put(val,arrayString[i]);
                pos++;
            }
            Arrays.sort(tempArray);
            for(String i:tempArray){
                res.add(map.get(i));
            }
            return res;
        }
    }

    public static void main(String[] args){
        String[] array={"105 102 106", "104 100 90","89 101 20"};
        System.out.println(sort(3,array,2,"string",false));
    }
}
