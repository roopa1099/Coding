package com.coding.doublelinkedlist;

public class DoubleLinkedList {
    
    public static TestNode insert(TestNode taiNode,TestNode newCurr) {
        
        TestNode current=taiNode;
            TestNode temp=newCurr;
            current.next=temp;
            temp.prev=current;
            current=temp;
            taiNode=current;

            return taiNode;
        
    }

    public static void print(TestNode head) {
        TestNode curr=head;

        while(curr!=null){
            System.out.println(curr.value);
            curr=curr.next;
        }

    }


    public static TestNode deleteNode(TestNode head, int pos, boolean isHead) {
        if(isHead){
            TestNode curr=head;
            int index=1;
            while(index<pos && curr!=null){
                curr=curr.next;
                index++;
            }
            if(curr==null)
            {
                return null;
            }
            TestNode previous=curr.prev;
            TestNode next=curr.next;
            previous.next=next;
            next.prev=previous;
        }
        else{
            TestNode cNode=head;
            int index=1;
            
            while(index<pos){
                cNode=cNode.prev;
                index++;
            }

            if(cNode==null){
                return null;
            }

            TestNode previous=cNode.prev;
            TestNode next=cNode.next;

            previous.next=next;
            next.prev=previous;
        }
            return head;
        
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
        tailNode=curr;
        TestNode newNode=new TestNode(1234);
        tailNode=insert(tailNode, newNode);
        print(head);

        deleteNode(head, 9, true);
        print(head);

        deleteNode(tailNode, 2, false);
        print(head);
    }
}


class TestNode{

    int value;
    TestNode next;
    TestNode prev;

    public TestNode(int value){
        this.value=value;
        next=null;
        prev=null;
    }
}
