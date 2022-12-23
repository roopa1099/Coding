package com.coding;

/**\
 * We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’. The array has only one duplicate but it can be repeated multiple times. Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.
 *
 * Example 1:
 *
 * Input: [1, 4, 4, 3, 2]
 * Output: 4
 */
public class DuplicateElement {

    public static int findNumber(int[] nums) {
        // TODO: Write your code here

        int start=0;
        boolean[] visited=new boolean[nums.length];
        for(int i=0;i<nums.length;i++)
            visited[i]=false;
        while(start<nums.length){
            int value=nums[start];
            int pos=value-1;
            if(nums[start]!=start+1 && !visited[start] && !visited[pos]){
                value=nums[start];
                pos=value-1;
                nums[start]=nums[pos];
                nums[pos]=value;
                visited[pos]=true;
            }
            else if(nums[start]==start+1 && !visited[start]){
                visited[start]=true;
                start++;
            }
            else{
                start++;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                return nums[i];
        }
        return -1;
    }


    public static void main(String[] args){
        int[] arr={3,1,2,1,4};
        System.out.println(findNumber(arr));

    }


}
