package miscellaneous_practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class LongestConsecutiveSubsequence {

    //bruteorce: for every element check the next element=>better==> Sort array and check 
    public static int longestSubsequence(int[] array) {
    
       HashSet<Integer> set=new HashSet<>();
       for(int val:array){
        set.add(val);
       }
       int maxLength=1;

       //check if prev element is present, if not then that is the startin of any sequence, so search net
       Iterator<Integer> iterator = set.iterator();
       while(iterator.hasNext()){
        //t(n)=O(n);
        int element_to_check=iterator.next();
        if(!set.contains(element_to_check-1)){
            int len=1;
            //will run as much sequnce present in array, definetly ot n times
            while(set.contains(element_to_check+1)){
                len++;
                element_to_check=element_to_check+1;
            }
            maxLength=Math.max(maxLength, len);
        }
       }
       return maxLength;
       }
    public static void main(String[] args) {
        int[] array={3,6,101,8,7,102,9};
        System.out.println(longestSubsequence(array));
    }
}
