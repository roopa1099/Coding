package com.coding.day0;

import java.util.HashMap;
import java.util.Map;

/**
 * Find longest sub array with equal 1 and 0
 */
public class LargestSuArrayEqual0And1 {


    public static int lengthSubarray(int[] array){
        Map<Integer,Integer> mappingPos=new HashMap<Integer,Integer>();
        int maxLength=Integer.MIN_VALUE;

        for(int i=0;i<array.length;i++){
            if(array[i]==0)
                array[i]=-1;
        }

        int sum=0;
        for(int i=0;i<array.length;i++){
            sum=sum+array[i];
            if(mappingPos.containsKey(sum)){
                int length=i-mappingPos.get(sum);
                maxLength=Math.max(maxLength,length);
            }
            mappingPos.put(sum,i);
        }
        return maxLength;
    }
    public static void main(String[] args){

        int[] array={0,0,0,1,1,0,0,1,0,1,0,1,0,1,0,1,1};
        System.out.println(lengthSubarray(array));

    }
}
