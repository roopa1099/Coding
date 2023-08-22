package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two sorted array, find intersection of the array
 */
public class Intersextion {


    public static List<Integer> intersection(int[] array1,int[] array2) {
          List<Integer> list=new ArrayList<>();

          /**
           * Bruteforce will be maintain a visited array for array 2, check if for every element in array1, there 
           * exists a element in array2 and also the visited position of that value in arry 2 is not visisted
           * t(n)=O(m*n) , extra s(n)=O(n)
           */

           /**\
            * Optimal t(n)=O(n+m);
            */

            int pt1=0,pt2=0;
            while(pt1<array1.length && pt2<array2.length){
                if(array1[pt1]<array2[pt2]){
                    pt1++;
                }
                else if(array1[pt1]>array2[pt2]){
                    pt2++;
                }
                else{
                    list.add(array1[pt1]);
                    pt1++;
                    pt2++;
                }
            }
            return list;
    }
    public static void main(String[] args) {
        int[] array1={4,5,7,8,8,9,9,9,10,13,13,15};
        int[] array2={2,5,6,6,6,6,6,7,8};
        System.out.println(intersection(array1, array2));
    }
}
