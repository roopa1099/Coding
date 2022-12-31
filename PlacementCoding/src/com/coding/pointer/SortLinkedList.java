package com.coding.pointer;

/**
 * 31 Dec
 * Given a linked list, write a function to rearrange its nodes to be sorted in increasing order.
 */
public class SortLinkedList {
    
    private static TestNode insertNode(TestNode newNode, TestNode newHeadode){


        if(newNode.value<newHeadode.value){
            newNode.next=newHeadode;
            newHeadode=newNode;  
            return newHeadode;       
        }

       
        TestNode currNode=newHeadode;
        while(currNode.next!=null && currNode.next.value<=newNode.value){
            currNode=currNode.next;
        }

        newNode.next=currNode.next;
        currNode.next=newNode;

        return newHeadode;
    }

    public static TestNode sortLinkedList(TestNode head){

      
        TestNode newHeadNode=new TestNode(head.value);
        TestNode currNode=head.next;


        while(currNode!=null){
            TestNode temp=new TestNode(currNode.value);
             newHeadNode=insertNode(temp, newHeadNode);
             currNode=currNode.next;
        }

        return newHeadNode;
    }

    public static void main(String[] args) {
       
        TestNode head=new TestNode(6);
        TestNode currNodeSet=head;


        int[] keys = {3, 4, 8, 2, 9};

        for(int i=0;i<keys.length;i++){
            TestNode temp=new TestNode(keys[i]);
            currNodeSet.next=temp;
            currNodeSet=temp;
        }
        
        TestNode newNode=sortLinkedList(head);
        TestNode currNode=newNode;
        while(currNode!=null){
            System.out.println(currNode.value);
            currNode=currNode.next;
        }
        
    }
}


class TestNode {
    int value;
    TestNode next;

    public TestNode() {
        this.value = 0;
        next = null;
    }
    public TestNode(int value) {
        this.value = value;
        next = null;
    }
}