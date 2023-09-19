package miscellaneous_practice;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraySumK {
    public static int subarrayCount(int[] array,int sum) {
        Map<Integer,Integer> sumCountMap=new HashMap<>();
        int currSum=0, count=0;
        sumCountMap.put(0,1);
        for(int i=0;i<array.length;i++){
            currSum=currSum+array[i];
            int revSum=currSum-sum;
        

            if(sumCountMap.containsKey(revSum)){
                count=count+sumCountMap.get(revSum);
                if(sumCountMap.containsKey(currSum))
                     sumCountMap.put(currSum,sumCountMap.get(currSum)+1);
                else
                    sumCountMap.put(currSum,1);
                
            }
            else{
                   sumCountMap.put(currSum,1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] array={1, 2, -3, 4, 4};
        System.out.println(subarrayCount(array, 5));
        
    }
}
