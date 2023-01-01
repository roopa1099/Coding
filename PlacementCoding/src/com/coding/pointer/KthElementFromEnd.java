package com.coding.pointer;
// 1 Jan
// Given a linked list and a positive integer k, find the k'th node from the end of the list. Single traversal
public class KthElementFromEnd {
    
    public static int kthNode(TestNode head,int k) {

        //  use 2 pointer one from beg and other from k elemnts a head of beg
        TestNode firsrNode=head;
        TestNode kthFromBeg=firsrNode;

        int count=k;
        while(count>0 && kthFromBeg!=null){
            kthFromBeg=kthFromBeg.next;
            count--;
        }

        if(kthFromBeg==null){
            return -1;
        }

        while(kthFromBeg!=null){
            firsrNode=firsrNode.next;
            kthFromBeg=kthFromBeg.next;
        }

        return firsrNode.value;

        
    }
    public static void main(String[] args) {
        int[] array= {2,2,4,5,5};
        TestNode node=new TestNode(2);
        TestNode currNode=node;
        for(int i=1;i<array.length;i++){
            TestNode temp=new TestNode(array[i]);
            currNode.next=temp;
            currNode=temp;
        }


       
            System.out.println(kthNode(node,1));
        
    }
}
