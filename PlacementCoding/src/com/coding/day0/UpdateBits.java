package com.coding;
/**
Update ith bit to either 1 or 0 dependin on the current bit 
 */
public class UpdateBits {

    public static int updateBit(int num,int pos,int bit){

        if(bit==0){
            int mask=~(1<<pos);
            return num & mask;
        }
        else{
            int mask=1<<pos;
            return num | mask;
        }


    }

    public static void main(String[] args){
        System.out.println(updateBit(5,2,0));
        System.out.println(updateBit(5,3,1));
    }
}
