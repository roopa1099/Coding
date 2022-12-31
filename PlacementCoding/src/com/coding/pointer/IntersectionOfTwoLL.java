package com.coding.pointer;


/**
 * 
 * 31 Dec
 * Given two lists sorted in increasing order, return a new list representing their intersection. 
 */
public class IntersectionOfTwoLL {
    
    public static TestNode intersectionLL(TestNode head1, TestNode head2) {
        
        TestNode headIntersection=null;
        TestNode curr_intersection=null;
        TestNode currOne=head1;
        TestNode currTwo=head2;

        while(currOne!=null && currTwo!=null){

            if(currOne.value==currTwo.value){
                if(headIntersection==null){
                    headIntersection=currOne;
                    curr_intersection=headIntersection;
                }
                else{
                    curr_intersection.next=currOne;
                    curr_intersection=curr_intersection.next;
                }
                currOne=currOne.next;
                currTwo=currTwo.next;
            }
            else if(currOne.value<currTwo.value){
                currOne=currOne.next;
            }
            else{
                currTwo=currTwo.next;
            }
        }

        if (curr_intersection!=null)
             curr_intersection.next=null;
       
        return headIntersection;
    }
    public static void main(String[] args) {
        int[] keys1={1,4,6,7,10};
        int[] keys2={2,4,6,8};
 
        TestNode head1 = null;
        TestNode currNode=head1;
        for (int i = 0;i<keys1.length;i++) {
            if(head1==null){
                head1=new TestNode(keys1[i]);
                currNode=head1;
            }
            else{
                currNode.next=new TestNode(keys1[i]);
                currNode=currNode.next;
            }
      
        }
 
        TestNode head2 = null;
        currNode=head2;
        for (int i = 0;i<keys2.length;i++) {
            if(head2==null){
                head2=new TestNode(keys2[i]);
                currNode=head2;
            }
            else{
                currNode.next=new TestNode(keys2[i]);
                currNode=currNode.next;
            }
        }

        TestNode resHead = intersectionLL(head1, head2);
        currNode=resHead;
        while(currNode!=null){
            System.out.println(currNode.value);
            currNode=currNode.next;
        }
    }
}
