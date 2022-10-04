package com.coding;

/**
 * Given time in minutes,return time in digital clock manner
 */
public class ConvertTimeToDigiClock {

    public static String convertTime(int min){
        int hours=min/60;
        int minutes=min-(hours*60);
        String time=String.valueOf(hours)+":"+String.valueOf(minutes);
        return time;
    }

    public static void main(String[] args){
        System.out.println(convertTime(1180));
    }
}
