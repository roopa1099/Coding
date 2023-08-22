package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two sorted array, find union of the array
 */

public class UnionArray {
    
    public static List<Integer> unionArray(int[] array1,int[] array2) {
        List<Integer> list=new ArrayList<>();
        //bruteforce: Use set, insert all elements t(n)=nLogn+mLogm insert in set takes nLogn

        //optimal solution t(n)=O(n+m)
        int pt1=0,pt2=0;

        while(pt1<array1.length && pt2<array2.length){
            if(array1[pt1]<array2[pt2]){
                if(!list.contains(array1[pt1]))
                     list.add(array1[pt1]);
                pt1++;
            }
            else{
                if(!list.contains(array2[pt2]))
                    list.add(array2[pt2]);
                pt2++;
            }

        }

        while(pt1<array1.length){
            if(!list.contains(array1[pt1]))
                list.add(array1[pt1]);
            pt1++;
        }

        while(pt2<array2.length){
            if(!list.contains(array2[pt2]))
                list.add(array2[pt2]);
            pt2++;
        }

        return list;
    }
    public static void main(String[] args) {
        int[] array1={4,5,7,8,8,9,9,9,10,13,13,15};
        int[] array2={2,5,6,6,6,6,6,7,8};
        List<Integer> list=unionArray(array2,array1);
        System.out.println(list);
    }
}
