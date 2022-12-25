package com.coding.bs;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * 25Dec
 * Given a sorted integer array, find the k closest elements to target in the array
 *  where k and target are given positive integers.
 */
public class KNearestElement {
    
    private static int findPos(List<Integer> list,int target){
            int start=0,end=list.size()-1,pos=-1;
            if(target<list.get(0))
                return 0;
            if(target>list.get(end))
                return end+1;
            while(start<=end){
                int mid=(start+end)/2;
                if(list.get(mid)==target){
                    pos=mid;
                    break;
                }
                else if(target<list.get(mid)){
                    pos=mid;
                    end=mid-1;
                }
                else{
                   
                    start=mid+1;
                }

            }

            return pos;
    }


    public static List<Integer> kNearestElements(List<Integer> list, int target, int k){

        int pt1=0,pt2=0;

        if(k>list.size()){
            System.out.println("Not enough elements");
        }
        int index=findPos(list, target);

        if(index==0){
            pt1=-1;
            pt2=k+1;
        }
        else if(index==list.size()){
            int ind=index-1;
            pt1=list.size()-1-k;
            pt2=index+1;
        }
        else{

            pt1=index-1;
            pt2=index;
            while(pt2<list.size() && pt1>=0 && k>0){
                if(Math.abs(target-list.get(pt2))>Math.abs(target-list.get(pt1))){
                        // System.out.println(list.get(pt1));
                        pt1--;
                        k--;
                }
                else if(Math.abs(target-list.get(pt2))==Math.abs(target-list.get(pt1))){
                    pt1--;
                    pt2++;
                    k=k-2;
                }
                else{
                    // System.out.println(list.get(pt2));
                        pt2++;
                        k--;
                }
               
            }

            while(pt2<list.size() && k>0){
                // System.out.println(list.get(pt2));
                pt2++;
                k--;
            }

            while(pt1>=0 && k>0){
                // System.out.println(list.get(pt1));
                pt1--;
                k--;
            }
        }
        return list.subList(pt1+1, pt2-1);
    }



    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
         list.add(7);
        // list.add(25);

    System.out.println( kNearestElements(list, 8, 2));
    }
}
