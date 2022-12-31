package com.coding.pointer;


/**
 * 31 Dec
 * Given a linked list sorted in increasing order, write a 
 * function that removes duplicate nodes from it by traversing the list only once.
 */
public class RemoveDuplicate {
    
    public static TestNode removeDuplicate(TestNode head) {
        

        TestNode currNode=head;

        if(head.next==null)
            return head;

        while(currNode!=null && currNode.next!=null){
            TestNode nextNode=currNode.next;
            if(currNode.value==nextNode.value){
                TestNode newNext=nextNode.next;
                currNode.next=newNext;
            }
                currNode=currNode.next;
        }

        return head;
    }
    public static void main(String[] args) {
        int[] array= {2,2,4,5,5,6,7,8,8};
        TestNode node=new TestNode(2);
        TestNode currNode=node;
        for(int i=1;i<array.length;i++){
            TestNode temp=new TestNode(array[i]);
            currNode.next=temp;
            currNode=temp;
        }


        node=removeDuplicate(node);
        currNode=node;
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
