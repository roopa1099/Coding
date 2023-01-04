package com.coding.pointer;

/**
 * Queue using linked list
 */
public class QueueLL {

    static TestNode head=null;
    static TestNode curr=head;

    public static void push(TestNode node){
        
        if(head==null){
            head=node;
            curr=head;
        }
        else{
            TestNode temp=node;
            curr.next=temp;
            curr=curr.next;

        }
    }

    public static void pop() {
        TestNode temp=head;
        System.out.println(temp.value+" is poped");
        head=head.next;
    }

    public static void peep() {
        System.out.println("Peep..");
        System.out.println(head.value);
    }


    public static void printAll() {
        TestNode node=head;
        System.out.println("Printing all....");
        while(node!=null){
            System.out.println(node.value);
            node=node.next;
        }
    }
    
    public static void main(String[] args) {
        TestNode node=new TestNode(3);
        push(node);
        node=new TestNode(8);
        push(node);
        node=new TestNode(6);
        push(node);
        node=new TestNode(7);
        push(node);
        printAll();
        pop();
        printAll();
        peep();
        pop();
        peep();
        node=new TestNode(156);
        push(node);
        printAll();
    }
}
