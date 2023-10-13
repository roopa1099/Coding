package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * All possible subsequence
 */
public class SubsequenceInArray {

    public static void subsequence(int[] array,List<Integer> arrayList, int index) {

        //t(n)= 2^n => every index has 2 options take or not take
        if(index>=array.length){
            System.out.println(arrayList);
            return;
        }

        arrayList.add(array[index]);
        subsequence(array, arrayList, index+1);
        arrayList.remove(arrayList.size()-1);
        subsequence(array, arrayList, index+1);
    }
    public static void main(String[] args) {
        int[] array={2,35,6,7,84};
        List<Integer> arrayList=new ArrayList<>();
        subsequence(array, arrayList, 0);
    }
}
