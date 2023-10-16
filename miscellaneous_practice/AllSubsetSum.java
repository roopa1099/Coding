package miscellaneous_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Gve all possible sum of subsets.
 */
public class AllSubsetSum {

    /**
     * Will contain duplicate elements
     */
    public static void subsetSum(int[] array, int index,int sum,List<Integer> subsetList) {

        // t(n)=2^n + 2^n*log(2^n) // for sorting
        //s(n) = 2^n 
        if(index==array.length){
            subsetList.add(sum);
            return;
        }

        subsetSum(array,index+1,sum+array[index],subsetList);
        subsetSum(array,index+1,sum,subsetList);
        
    }

    public static  List<Integer> getSubSet(int[] array) {
        List<Integer> subset=new ArrayList<>();
        subsetSum(array,0,0,subset);
        Collections.sort(subset);
        return subset;
    }


    /**
     * Should contain only unique set
     * @param args
     */
    public static void uniqueSubSetOfSums(int[] array,int index,List<Integer> subset,int sum) {
        
        if(index==array.length){
            subset.add(sum);
            return;
        }

        for(int i=index;i<array.length;i++){
            //ensure first time index is considered
            if(i>index && array[index]==array[index-1]) continue;

            //taken
            subset.add(array[i]);
            uniqueSubSetOfSums(array, index+1, subset, sum+array[i]);
            subset.remove(subset.size()-1);
            //not taken condition in next round
        }
        
    }

      public static  List<Integer> getSubSet2(int[] array) {
        List<Integer> subset=new ArrayList<>();
        subsetSum(array,0,0,subset);
        Collections.sort(subset);
        return subset;
    }

    public static void main(String[] args) {
        int[] array={3,1,2};
        System.out.println(getSubSet(array));
        int[] array2={3,1,3,2};
        System.out.println(getSubSet2(array2));
    }
}