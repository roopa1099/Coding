package com.coding.pointer;

/**
 * 30 Dec
 * Write a function that takes a singly linked list and returns a complete copy of that list.
 */
public class CopyLL {
    
    public static TestNode copyLinkedList(TestNode head) {
        TestNode head_new=null;
        TestNode curr_node_new=null;
        TestNode curr_node_old;

        curr_node_old=head;
      
        while(curr_node_old!=null){
            TestNode temp=new TestNode(curr_node_old.value);
            if(head_new==null){
                head_new=temp;
                curr_node_new=temp;
            }
            else{
                curr_node_new.next=temp;
                curr_node_new=curr_node_new.next;
            }
            curr_node_old=curr_node_old.next;       
        }  
        
        return head_new;
    }
    public static void main(String[] args) {
       TestNode head=new TestNode(1);
       TestNode temp=head;
       for(int i=2;i<=5;i++){
            temp.next=new TestNode(i);
            temp=temp.next;
       }
        
       TestNode newhead=copyLinkedList(head);

       while(newhead!=null){
        System.out.println(newhead.value);
        newhead=newhead.next;
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
