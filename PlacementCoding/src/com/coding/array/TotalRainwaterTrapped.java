package com.coding.array;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
 * 6 units of rain water (blue section) are being trapped.
 */
public class TotalRainwaterTrapped {

    public static int trap(int[] height) {

        int[] leftHeight=new int[height.length];

        int[] rightHeight=new int[height.length];

        rightHeight[height.length-1]=0;
        leftHeight[0]=0;

        int length=height.length;

        for(int i=1;i<length;i++){
            leftHeight[i]=Math.max(leftHeight[i-1],height[i-1]);
        }

        for(int i=length-2;i>=0;i--){
            rightHeight[i]=Math.max(rightHeight[i+1],height[i+1]);
        }

        /**
         * minimum between Left highest height and righthighest height - height
         */
        int qty=0;
        for(int i=1;i<length-1;i++){
            int minHeight=Math.min(leftHeight[i],rightHeight[i]);
            if(minHeight>height[i]){
                qty=qty+(minHeight-height[i]);
            }
        }

        return qty;

    }

    public static void main(String[] args){
        int[] arr={4,2,0,3,2,5};
        System.out.println(trap(arr));
    }

}
