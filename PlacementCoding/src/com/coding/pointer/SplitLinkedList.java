package com.coding.pointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 31 Dec
 * 
 * Given a linked list of integers, split it into two lists 
 * containing alternating elements from the original list.
 */
public class SplitLinkedList {

    public static List<TestNode> splitLinkedList(TestNode head) {

        List<TestNode> result=new ArrayList<>();
        int index=0;
        TestNode currNode=head;
        TestNode headOne=null;
        TestNode headTwo=null;
        TestNode currNodeOne=headOne;
        TestNode currNodeTwo=headTwo;

        // 1,2,3,4,5
        while(currNode!=null){
            if(index%2==0){
                if(headOne==null){
                    headOne=currNode;
                    currNodeOne=headOne;
                }
                else{
                    currNodeOne.next=currNode;
                    currNodeOne=currNodeOne.next;
                }         
            }
            else{

                if(headTwo==null){
                    headTwo=currNode;
                    currNodeTwo=headTwo;
                }
                else{
                    currNodeTwo.next=currNode;
                    currNodeTwo=currNodeTwo.next;
                }  
            }
            index++;
            currNode=currNode.next;
        }

        currNodeOne.next=null;
        currNodeTwo.next=null;

        result.add(headOne);
        result.add(headTwo);

        return  result;

    }

    public static void main(String[] args) {
        int[] array={2, 3, 4, 5};
        TestNode head=new TestNode(1);
        TestNode curNode=head;
        for(int i=0;i<array.length;i++){
            TestNode temp=new TestNode(array[i]);
            curNode.next=temp;
            curNode=curNode.next;
        }
        List<TestNode> res=splitLinkedList(head);
       TestNode headOne=res.get(0);
       TestNode headTwo=res.get(1);

       curNode=headOne;
       while(curNode!=null){
           System.out.println(curNode.value);
           curNode=curNode.next;
       }
        System.out.println("-----------------------");

       curNode=headTwo;
       while(curNode!=null){
           System.out.println(curNode.value);
           curNode=curNode.next;
       }
    }
    
}
