package com.coding.doublelinkedlist;

/**
 * 4 Jan
 * Reverse a doubly linked list using iteration.
 */
public class ReverseLL {
//  alternate, swap the values using two pointer

    public static TestNode reverse(TestNode head) {
        TestNode currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        TestNode currReverse=null;
        TestNode reverseHead=null;
        currReverse=reverseHead;
        while(currNode!=null){

            if(reverseHead==null){
                reverseHead=currNode;
                currNode=currNode.prev;
                currReverse=reverseHead;
            }
            else{
            TestNode tempNode=new TestNode(currNode.value);
            currReverse.next=tempNode;
            tempNode.prev=currReverse;
            currReverse=tempNode;
            currNode=currNode.prev;
            }
        }

        return reverseHead;
    }


    public static void print(TestNode head) {
        TestNode curr=head;

        while(curr!=null){
            System.out.println(curr.value);
            curr=curr.next;
        }

    }

    public static void main(String[] args) {
        TestNode head=new TestNode(7);
        TestNode tailNode=null;
       int[] array={9,5,3,4};
       TestNode curr=head;

       for(int i=0;i<array.length;i++){
           TestNode temp=new TestNode(array[i]);
           curr.next=temp;
           temp.prev=curr;
           curr=temp;
       }

       TestNode reverNode=reverse(head);
       print(reverNode);
    }
}
