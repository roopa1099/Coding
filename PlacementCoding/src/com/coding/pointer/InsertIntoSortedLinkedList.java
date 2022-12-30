package com.coding.pointer;

/**
 * 30 Dec
 * Given a sorted list in increasing order and a single node, insert the node into the list’s correct sorted position. 
 * The function should take an existing node and rearranges pointers to insert it into the list.
 */
public class InsertIntoSortedLinkedList {
    
    public static TestNode insertNode(TestNode newNode, TestNode head) {
        TestNode currNode=head;

        if(head==null){
            head=newNode;
            return head;
        }

        if(head.value>newNode.value){
                newNode.next=head;
                head=newNode;
                return head;
            }
        

        while(currNode.next!=null  && currNode.next.value<newNode.value){
                currNode=currNode.next;
        }
        newNode.next=currNode.next;
        currNode.next=newNode;

        return head;
        
    }
    public static void main(String[] args) {
        
        TestNode head=new TestNode(10);
        TestNode node=head;
        TestNode trial=new TestNode(5);

        for(int i=20;i<=30;i=i+10){
            TestNode temp=new TestNode(i);
            node.next=temp;
            node=node.next;
        }
        TestNode resultHead=insertNode(trial, head);

        node=resultHead;
        while(node!=null){
            System.out.println(node.value);
            node=node.next;
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
