package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * KthPermutation
 * Ques:  Given N and K, where N is the sequence of numbers from 1 to N([1,2,3….. N]) find the Kth permutation sequence.
 * 
 * 
 * sol
 * Locate position of every element, at which nth permutation will it lie.
 */
public class KthPermutation {

    public static String findKthPermutation(int N,int k) {
        String res="";
        List<Integer> nums=new ArrayList<>();
        int fact=1;
        //i<N, fac required upto N-1
        for(int i=1;i<N;i++){
            nums.add(i);
            fact=fact*i;
        }
        nums.add(N);
        k=k-1; //0 based indexing
        while(true){
            res=res+nums.get(k/fact);
            nums.remove(k/fact);
            k=k%fact;
            if(nums.size()==0){
                break;
            }
            fact=fact/nums.size();
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(findKthPermutation(4,17));
    }
}