package com.coding.doublelinkedlist;


/*
    5 Jan
 * Sort the double linked list
 */
public class SortList {
    
    public static TestNode insertNode(TestNode head, TestNode node) {

       
        if(head==null){
            head=node;
            return head;
        }

        if(head.value>node.value){
            node.next=head;
            head.prev=node;
            head=node;
            return head;
        }
        if(head.next==null && head.value>node.value){
            TestNode temp=node;
            temp.next=head;
            head.prev=temp;
            head=temp;
            return head;
        }

        TestNode curr=head;
        while(curr.next!=null && curr.value<node.value){
            curr=curr.next;
        }


        if(curr.next==null && curr.value<=node.value){
            curr.next=node;
            node.prev=curr;
            return head;
        }

        TestNode nextNode=curr;
        TestNode previousNode=curr.prev;
        previousNode.next=node;
        node.prev=previousNode;
        node.next=nextNode;
        nextNode.prev=node;

        return head;
    }

    public static TestNode sortLinkNode(TestNode head) {
        TestNode curr=head;
        // TestNode newHead=new TestNode(head.value);
        TestNode newHead=null;
        while(curr!=null){
            TestNode node=new TestNode(curr.value);
            newHead=insertNode(newHead, node);
            curr=curr.next;
        }
        
        return newHead;
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

       head=sortLinkNode(head);
       print(head);
    }

}
