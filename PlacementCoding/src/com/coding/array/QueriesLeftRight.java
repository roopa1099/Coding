package com.coding.array;

/**
 * Given an array arr[] of N integers. There are three types of commands:
 *
 * 1 x: Right Circular Shift the array x times. If an array is a[0], a[1], …., a[n – 1], then after one right circular shift the array will become a[n – 1], a[0], a[1], …., a[n – 2].
 * 2 y: Left Circular Shift the array y times. If an array is a[0], a[1], …., a[n – 1], then after one left circular shift the array will become a[1], …., a[n – 2], a[n – 1], a[0].
 * 3 l r: Print the sum of all integers in the subarray a[l…r] (l and r inclusive).
 * Given Q queries, the task is to execute each query.
 *
 * t(n)=O(n), spcae=o(1)
 */

import java.util.ArrayList;

public class QueriesLeftRight {

    public ArrayList<Integer> findSum(int[] array, int length, ArrayList<ArrayList<Integer>>queries){
        ArrayList<Integer> result=new ArrayList<>();

        int[] prefSum=new int[length];
        prefSum[0]=array[0];
        int rot=0;
        for(int i=1;i<array.length;i++){
            prefSum[i]=prefSum[i-1]+array[i];
        }

        for(int j=0;j<queries.size();j++){
            int sum=0;
            int val=queries.get(j).get(0);
            if(val==1)
                rot=rot-queries.get(j).get(1);
            else if(val==2)
                rot=rot+queries.get(j).get(1);
            else{
                int l=queries.get(j).get(1);
                int r=queries.get(j).get(2);
//                Calculating original array position
                l=(length+rot+l)%length;
                r=(length+rot+r)%length;

                if(r<l){
                 sum=sum+(prefSum[l]-prefSum[l-1])+(prefSum[r]);
//                    sum=sum+prefSum[r];
                }
                else if(l==0){
                    sum=sum+prefSum[r];
                }
                else {
                    sum = prefSum[r] - prefSum[l - 1];

                }
                result.add(sum);
            }
        }

        return result;

    }



    public static void main(String args[]){
        int[] array={ 1, 2, 3, 4, 5 };
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        ArrayList<Integer> val=new ArrayList<>();
        val.add(2);
        val.add(1);
        list.add(val);

        ArrayList<Integer> val2=new ArrayList<>();
        val2.add(3);
        val2.add(0);
        val2.add(2);
        list.add(val2);

        ArrayList<Integer> val3=new ArrayList<>();
        val3.add(1);
        val3.add(3);
        list.add(val3);

        ArrayList<Integer> val4=new ArrayList<>();
        val4.add(3);
        val4.add(1);
        val4.add(4);
        list.add(val4);
        QueriesLeftRight obj=new QueriesLeftRight();
        ArrayList<Integer> result=obj.findSum(array, array.length,list);
        for(int i:result){
            System.out.println(i);
        }
    }
}
