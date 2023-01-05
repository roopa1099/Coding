package com.coding.doublelinkedlist;


/**
 * 5 Jan
 * Dequeue implementation using double LL
 */
public class DequeueLL{

    static TestNode head=null;
    static TestNode tail=null;
    public static void insertFront(TestNode node) {
        if(head==null){
            head=node;
            tail=head;
        }
        else{
            node.next=head;
            head.prev=node;
            head=node;
        }
    }

    public static void insertBack(TestNode node) {

        if(head==null){
            head=node;
            tail=head;
        }
        else{
            tail.next=node;
            node.prev=tail;
            tail=node;
        } 
    }

    public static void popFront() {
        head=head.next;
        head.prev=null;
    }

    public static void popBack() {
        tail=tail.prev;
        tail.next=null;
    }

    public static void peepFront(TestNode node) {
        System.out.println("Peep front");
        System.out.println(head.value);
    }

    public static void peepBack(TestNode node) {
        System.out.println("Peep back");
        System.out.println(tail.value);
        
    }

    public static void printAll() {

        System.out.println("Printing all...");
        TestNode curr=head;
        while(curr!=null){
            System.out.println(curr.value);
            curr=curr.next;
        }
        
    }

    public static void main(String[] args) {
        TestNode cNode=new TestNode(4);
        insertFront(cNode);
        cNode=new TestNode(6);
        insertFront(cNode);
        cNode=new TestNode(5);
        insertBack(cNode);
        cNode=new TestNode(25);
        insertBack(cNode);
        printAll();
        popFront();
        printAll();
        popBack();
        printAll();;
        peepBack(cNode);
        peepFront(cNode);

    }
}