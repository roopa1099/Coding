package miscellaneous_practice;
import java.util.Arrays;

public class FindMaxOfMinCows {
  /**
   * You are given an array consisting of n integers which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. You are given the task of assigning stalls to k cows such that the minimum DISTANCE between any two of them is the maximum possible.
The first line of input contains two space-separated integers n and k.
The second line contains n space-separated integers denoting the position of the stalls.

Example 1:

Input:
n=5 
k=3
stalls = [1 2 4 8 9]
Output:
3
Explanation:
The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows, in this case, is 3, 
which also is the largest among all possible ways.
   * @param arrayDistance
   * @param totalCows
   * @return
   */
  public static int findMaxOfMin(int[] arrayDistance, int totalCows) {
    Arrays.sort(arrayDistance);

    //min cows will be two, so the distance between two cows can be any "ith" and "jth" element in the Array, and the max of the distance between two cows will be max-min
    // min distance between cows is the distance between any two adjacent cows
    //hence possible range of distance between n number of cows can be 1 to (max-min)

      int high=arrayDistance[arrayDistance.length-1]-arrayDistance[0];
      int low=1;
      //here distance is not the value in array, it is difference of values in array;

      while(low<=high){
        int mid=low+(high-low)/2;
        if(isDistancePossibleForCows(arrayDistance, mid, totalCows)){
          low=mid+1;
        }
        else{
          high=mid-1;
      }
    }

    //based on pollaarity high will be the atmost value possible and low will be min value not possible;
    return high;

    
  }

  private static boolean isDistancePossibleForCows(int[] array, int distance, int cows){
// to get max distance, first cow will be in the smallest value
    int numbeOfCows=1, lastCowPosition=array[0];
    for(int i=0;i<array.length;i++){
      if(array[i]-lastCowPosition>=distance){
          lastCowPosition=array[i];
          numbeOfCows++;
      }
      if(numbeOfCows>=cows){
        return true;
      }
    }

    return false;
  }
  public static void main(String[] args) {
    int[] array={1, 2, 4, 8, 9};
    System.out.println(findMaxOfMin(array, 3));
  }
}
