package com.coding.day0;

/**
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers
 *
 * snums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
 *
 * Return true if there is a 132 pattern in nums, otherwise, return false.

 */
public class PatternCheck132 {

    public static boolean find132pattern(int[] nums) {


/**
 *
 * first find k considering every alement as j, then figure out best possible k.
 *          also keep checking if we get i less than k.
 */


        int possibleK=-1,n=nums.length;

        if(nums.length<3)
            return false;

        for(int j=n-2;j>=0;j--){

//             if nums[i]<nums[k]
            if(possibleK>-1 && nums[j]<nums[possibleK])
                return true;

//             for finding best possible k
            for(int k=j+1;k<n;k++){
//                 if(nums[j]<nums[k] where j<k then break)

                if(nums[j]<nums[k])
                    break;

/**            Or condition is to find best k means more closer to j, for cases like 17,21,16,20,19,14,5
**               here if we take j=20 and k=14, we won't get nums[i]<nums[k], but for j=20 if we take k=19, //
**               we get nums[i]=15. In the second or condition " && nums[j]>nums[k] " is becoz otherwie equal
**               conditionwill take place i.e. if nums[j]==nums[k] which is not correct
 */
                if((nums[j]>nums[k] && possibleK==-1) || (possibleK!=-1 && nums[j]>nums[k] && nums[possibleK]<nums[k]))
                    possibleK=k;
            }
        }


        return false;


    }


    public static void main(String[] args){
        int[] array={-2,1,1,-2,1,1};
        System.out.println(find132pattern(array));
    }
}
