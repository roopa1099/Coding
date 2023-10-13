package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceWithSum {
    // Print subsequnce with sum K if any(not all subsequnce with sum k)
    public static boolean subsequnceWithSum(int[] array,List<Integer> arrayList,int index, int sum, int k) {

        if(index>=array.length){{
            if(sum==k){
                // to print subsequence we require arraylist
                System.out.println(arrayList);
                return true;
            }
            return false;
        }}

        sum=sum+array[index];
        arrayList.add(array[index]);
        if(subsequnceWithSum(array,arrayList, index+1, sum,k)){
            return true;
        }
        sum=sum-array[index];
        arrayList.remove(arrayList.size()-1);
        if(subsequnceWithSum(array,arrayList ,index+1, sum,k)){
            return true;
        }

        return  false;  
    }

// count subsequence with sum k
        public static int subsequnceWithSumCount(int[] array,int count,int index, int sum, int k) {

        if(index>=array.length){{
            if(sum==k){      
                return 1;
            }
            return 0;
        }}

        sum=sum+array[index];
        int taken=subsequnceWithSumCount(array,count, index+1, sum,k);
        sum=sum-array[index];
        int notTaken=subsequnceWithSumCount(array,count ,index+1, sum,k);
        return  taken+notTaken;  
    }
    
    public static void main(String[] args) {
        int[] array={1,2,1};
        List<Integer> arrayList=new ArrayList<>();
        subsequnceWithSum(array, arrayList, 0,0,2);
        System.out.println(subsequnceWithSumCount(array, -1, 0,0,2));
    }
}
