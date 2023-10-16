package miscellaneous_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Print all possible permutations of given array.
 */
public class AllPermutationOfArray {
    public static void permutations(int[] array, List<Integer> set, Map<Integer,Boolean> checkMap) {
        /**
         * Time Complexity:  N! x N
           Space Complexity:  O(N)
         */
        if(set.size()==array.length){
            //all permutations will have all elements in different order
            System.out.println(set);
            return;
        }
        for(int i=0;i<array.length;i++){
            if(!checkMap.get(array[i])){
                set.add(array[i]);
                checkMap.put(array[i], true);
                //taken
                permutations(array, set, checkMap);
                //not taken
                set.remove(set.size()-1);
                checkMap.put(array[i], false);
            }
        }
    }

    private static void swap(int index1,int index2,int[] array) {
        int temp=array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }
    public static void permutationWithoutExtraSpace(int[] array, int index, List<List<Integer>> list) {
        // swap and make combination, swap from index to n-1
        if(index==array.length){
            List<Integer> tempList=new ArrayList<>();
            for(int i=0;i<array.length;i++){
                tempList.add(array[i]);
            }
            list.add(tempList);
        }
        for(int i=index;i<array.length;i++){
            swap(i, index, array);
            permutationWithoutExtraSpace(array, index+1, list);
            //revert
            swap(i, index, array);
        }
    }
    public static void main(String[] args) {
        int[] array={1,3,2};

        List<Integer> set=new ArrayList<>();
        Map<Integer, Boolean> map=new HashMap<>();
        for(int i=0;i<array.length;i++){
            map.put(array[i], false);
        }
     
        permutations(array,set,map);
        System.out.println("**************************");

        List<List<Integer>> res=new ArrayList<>();
        permutationWithoutExtraSpace(array, 0, res);
        System.out.println(res);

    }

}
