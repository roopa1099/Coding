package miscellaneous_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Gve all possible sum of subsets.
 */
public class AllSubsetSum {

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

    public static void main(String[] args) {
        int[] array={3,1,2};
        System.out.println(getSubSet(array));
    }
}