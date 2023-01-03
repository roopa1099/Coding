package com.coding.pointer;

/**
 * 
 * 3 Jan
 * IMPORTANT****
 * Given a linked list of integers, which may contain a cycle, remove the cycle if present.
 */


public class LinkedListWithLoop {

    private static TestNode removeLink(TestNode head, TestNode slowPointer){
   
    // find number of elements in loop
    int k=1;
    TestNode curr=slowPointer;
    while(curr.next!=slowPointer){
        k++;
        curr=curr.next;
    }

    curr=head;
    // elemnts not part of loop if n-k, find kth elemnts of ll from begining;

    for(int i=0;i<k;i++){
        curr=curr.next;
    }

    // elemnts left after kth elemnt is n-k, and elemnt before k+1th elemnt is n-k, so finding last elemnt of loop
    TestNode start=head;
    TestNode kNode=curr;

    while(start!=kNode){
        curr=curr.next;
        start=start.next;
    }

    curr.next=null;

    return head;


    }
    
    public static TestNode checkIfLoop(TestNode head) {

        TestNode fastPointer=head;
        TestNode slowPointer=head;
        TestNode res=null;
        // if loop does not exist, will reach null
        // else at a point slowPOinter will match fastPonter
        while(fastPointer!=null && fastPointer.next!=null){
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
            if(fastPointer==slowPointer)
                res=removeLink(head, slowPointer);
        }
        
        return res;
    }
    public static void main(String[] args) {

        int[] arr1={2,4,6};
        int[] arr2={6,7};

        TestNode head1=new TestNode(4);
        TestNode currNode=head1;
        for(int i=0;i<arr1.length;i++){
            TestNode node=new TestNode(arr1[i]);
            currNode.next=node;
            currNode=currNode.next;
        }


        TestNode head2=new TestNode(3);
        TestNode currNode2=head2;
        for(int i=0;i<arr2.length;i++){
            TestNode node=new TestNode(arr2[i]);
            currNode2.next=node;
            currNode2=currNode2.next;
        }
        
        currNode2.next=head2;

        currNode.next=head2;

        TestNode res=checkIfLoop(head1);
        while(res!=null){
            System.out.println(res.value);
            res=res.next;
        }
    }
}
