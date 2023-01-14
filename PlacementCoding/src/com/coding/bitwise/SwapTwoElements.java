package com.coding.bitwise;

import java.util.ArrayList;
import java.util.List;

public class SwapTwoElements {

    public static int decimal(List<Integer> list) {
        int sum=0,i=0;
        for(i=list.size()-1;i>=0;i--){
           sum=sum+list.get(i);
           sum=sum<<1;
        }
        sum=sum+list.get(i);
        return sum;

    }

    public static int swapBinary(int number,int p, int q) {
        int a=0,b=0,num=number;
        List<Integer> list=new ArrayList<>();
        while(num!=0){
            int digit=num&1;
            list.add(digit);
            num=num>>1;
        }
        a=list.get(list.size()-p);
        b=list.get(list.size()-q);

        if((a^b)==0){
            return number;
        }
        else{
          list.add(list.size()-1-p,b);
          list.add(list.size()-1-q,a);
          int res=decimal(list);
          return res;
        }

    }

    public static void main(String[] args) {
        int ip=31;
        System.out.println(swapBinary(ip, 2, 6));
    }
}
