package miscellaneous_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unique elements, and a target sum N, find all possible combinations of elements that will sum upto N. he elements
 * can repeat any number of times.
 * CombinationSum
 */
public class CombinationSum {
    public static void combinationSum(int[] array, int target,List<Integer> list, int index) {
        /**
         * t(n)= 2^t * k
         * s(n) = k(avg length) * x(combinations)
         */
        
        if(index>=array.length){
            if(target==0){
                System.out.println(list);
            }
            return;
        }

        if(array[index]<=target){
            //take
            list.add(array[index]);
            combinationSum(array, target-array[index], list, index);
            list.remove(list.size()-1);
        }
        //not take
        combinationSum(array, target, list, index+1);
        
    }

    public static void uniqueCombinationSum(int[] array,int target, List<Integer> list, int index) {
        //sort

            if(target==0){
                System.out.println(list);
                return;
            }

        

        for(int i=index;i<array.length;i++){
            //2 case: consider element and not consider, but if elements are repeated, we need to move till position
            // where elements are different. Otherwise not taken case will go wrong
            // i>index ensures element is considered once. and also ensure elements are not repeating after that
            if(i>index && array[i]==array[i-1]) continue;
            //array is sorted
            if(array[i]>target) break;

            list.add(array[i]);
            uniqueCombinationSum(array, target-array[i], list, i+1);
            list.remove(list.size()-1);
        }
        
    }
    public static void main(String[] args) {
        int[] array={2,3,6,7};
        int[] array2={1,1,2,1,2};
        List<Integer> list=new ArrayList<>();
        combinationSum(array, 7, list, 0);
        Arrays.sort(array2);
        uniqueCombinationSum(array2, 3, list, 0);
    }
    
}