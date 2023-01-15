package com.coding.recursion;


/**
 * Prin alternate nodes in linked list using recursion
 */
public class RcAltNodesInLL {
    
    public static void printAltNodes(TestNode currNode, int count) {

        if(currNode==null){
            return;
        }

        if(count%2==0){
            System.out.println(currNode.number);
        }
        currNode=currNode.next;
        printAltNodes(currNode, ++count);
    }
    public static void main(String[] args) {
        TestNode head=new TestNode(2);
        head.next=new TestNode(3);
        head.next.next=new TestNode(4);
        head.next.next.next=new TestNode(5);
        head.next.next.next.next=new TestNode(6);
        head.next.next.next.next.next=new TestNode(7);
        head.next.next.next.next.next.next=new TestNode(8);
        TestNode curr=head;
        printAltNodes(curr, 0);
    }
}
