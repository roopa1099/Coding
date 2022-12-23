package com.coding;

import java.util.*;




public class LexographicallyLargestNumber {
    public static String largetNumber(int[] array){
       List<String> list=new ArrayList<>();
       for(int val:array){
           list.add(String.valueOf(val));
       }
        Collections.sort(list,new Sort());
       String res=new String("");
       for (String val:list){
           res=res+val;
       }
       return res;
       }

       public static void main(String[] args){
        int[] array={10,11,20,30,3};
        System.out.println(largetNumber(array));
       }
    }

class Sort implements Comparator<String>{


    @Override
    public int compare(String a, String b) {
        int val=(a+b).compareTo(b+a);
        if(val==1 || val==0)
            return Integer.parseInt(a+b);
        return Integer.parseInt(b+a);
    }

}
