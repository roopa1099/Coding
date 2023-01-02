package com.coding.pointer;


/**
 * 2 Jan
 * Given two linked lists, where the tail of the second list points to a node in the first list, 
 * find the node where both lists intersect.
 */
public class IntersectionOfLinkedList {

    private static int length(TestNode head) {
        
        int count=0;
        if(head==null)
            return 0;

        TestNode cNode=head;
        while(cNode!=null){
            count++;
            cNode=cNode.next;
        }

        return count;
    }

    public static TestNode intersection(TestNode head1, TestNode head2) {
        
        int firstCount=length(head1);
        int secondCount=length(head2);
        TestNode firstHead=head1;
        TestNode secHead=head2;
        int diff=Math.abs(firstCount-secondCount);
        if(firstCount<secondCount){
            TestNode temp=secHead;
            secHead=firstHead;
            firstHead=temp;
        }

        // make both linkedlist of sme length, then traverse one by one
        for(int k=0;k<diff;k++){
            firstHead=firstHead.next;
        }

        TestNode currNode1=firstHead;
        TestNode currNode2=secHead;
        TestNode result=null;
        while(currNode1!=null && currNode2!=null){

            if(currNode1==currNode2){
                result=currNode1;
                break;
            }
            currNode1=currNode1.next;
            currNode2=currNode2.next;
        }

        return result;
        
    }
    public static void main(String[] args) {
        int[] arr1={2,3,4,5};
        int[] arr2={3,4,6,9,7};
        TestNode head1=new TestNode(3);
        TestNode head2=new TestNode(4);
        TestNode cNode1=head1;
        TestNode cNode2=head2;
        for(int i=0;i<arr1.length;i++){
            TestNode temp=new TestNode(arr1[i]);
            cNode1.next=temp;
            cNode1=cNode1.next;
        }

        for(int i=0;i<arr2.length;i++){
            TestNode temp=new TestNode(arr2[i]);
            cNode2.next=temp;
            cNode2=cNode2.next;
        }

        TestNode head3=new TestNode(4);
        TestNode cNode3=head3;
        int[] arr3={2,6,8};
        for(int i=0;i<arr3.length;i++){
            TestNode temp=new TestNode(arr3[i]);
            cNode3.next=temp;
            cNode3=cNode3.next;
        }

        cNode1.next=head3;
        cNode2.next=head3;

        TestNode res=intersection(head1, head2);
        System.out.println(res.value);
    }
}
