package com.coding.pointer;

/**
 * 
 * 1 Jan
 * Write a function that takes two lists, each of which is sorted in increasing order, and merges 
 * the two into a single list in increasing order, and returns it.
 */
public class MergeTwoSortedLL {

    public static TestNode sort(TestNode head1, TestNode head2){
        TestNode currNode1=head1;
        TestNode currNode2=head2;
        TestNode mergeHead=null;
        TestNode currNodeMerge=null;

        while(currNode1!=null && currNode2!=null){
            if(currNode1.value<currNode2.value){
                if(mergeHead==null){
                    mergeHead=currNode1;
                    currNodeMerge=mergeHead;
                }
                else{
                    currNodeMerge.next=currNode1;
                    currNodeMerge=currNodeMerge.next;
                }
                currNode1=currNode1.next;
            }

            else{
                if(mergeHead==null){
                    mergeHead=currNode2;
                    currNodeMerge=mergeHead;
                }
                else{
                    currNodeMerge.next=currNode2;
                    currNodeMerge=currNodeMerge.next;
                }
                currNode2=currNode2.next;
            }
        }

        while(currNode1!=null){
            currNodeMerge.next=currNode1;
            currNodeMerge=currNodeMerge.next;
            currNode1=currNode1.next;
        }

        
        while(currNode2!=null){
            currNodeMerge.next=currNode2;
            currNodeMerge=currNodeMerge.next;
            currNode2=currNode2.next;
        }


            currNodeMerge.next=null;
            return mergeHead;
    }

    public static void main(String[] args) {
        
        int[] keys1={1,4,7,8,10};
        int[] keys2={2,3,6,9};
 
        TestNode head1 = null;
        TestNode currNode=head1;
        for (int i = 0;i<keys1.length;i++) {
            if(head1==null){
                head1=new TestNode(keys1[i]);
                currNode=head1;
            }
            else{
                currNode.next=new TestNode(keys1[i]);
                currNode=currNode.next;
            }
      
        }
 
        TestNode head2 = null;
        currNode=head2;
        for (int i = 0;i<keys2.length;i++) {
            if(head2==null){
                head2=new TestNode(keys2[i]);
                currNode=head2;
            }
            else{
                currNode.next=new TestNode(keys2[i]);
                currNode=currNode.next;
            }
        }

        TestNode resHead = sort(head1, head2);
        currNode=resHead;
        while(currNode!=null){
            System.out.println(currNode.value);
            currNode=currNode.next;
        }
    }
    
}
