package miscellaneous_practice;

import java.util.HashMap;
import java.util.Map;

public class Subarraysum {
    
    /*
     * Return true or false, if subarray with sum k (Array contains positive & zero)
     */
    public static boolean subArrayExists(int[] array, int sum) {
       
        int pt1=0, pt2=0, calcSum=0;
        while(pt2<array.length){
           while(calcSum<sum){
            calcSum=calcSum+array[pt2];
            pt2++;
           }
           if(calcSum==sum){
            return true;
           }
           while(calcSum>sum){
            calcSum=calcSum-array[pt1]; 
            pt1++;
           }
        }
        return false;
    }

      /*
     * Return maxLength, if subarray with sum k((Array contains positive and neg and zero))
     */
    public static int subarrayPos(int[] array, int sum) {
        //Reverse engineering
        Map<Integer,Integer> storeSumPos=new HashMap<>();
        int cal_sum=0,maxLength=0;
        int pt1=0;
        while(pt1<array.length){
            cal_sum=cal_sum+array[pt1];
            //fo normal subarray starting from 0
            if(cal_sum==sum){
                maxLength=Math.max(maxLength, pt1+1);
            }
            int reverseSum=cal_sum-sum;
            // 2,3,5,6 for this prefix sum or calc_sum 16, now if i want to get a sum of 11, 
            // I will check if 16-11 i.e 5 has occure before, whichis 2+3 for the first time, so I subtract 3rd pos and 1st pos
            if(storeSumPos.containsKey(reverseSum)){
                maxLength=Math.max(maxLength, pt1-storeSumPos.get(reverseSum));
            }

            // will work when elements have o 2,0,0,3 where 0,0,3 is the subarray.
            if(!storeSumPos.containsKey(reverseSum)){
                storeSumPos.put(cal_sum, pt1);
            }
                  pt1++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] array={2,5,7,9};
        System.out.println(subArrayExists(array, 12));
         System.out.println(subarrayPos(array,2 ));
    }
}
