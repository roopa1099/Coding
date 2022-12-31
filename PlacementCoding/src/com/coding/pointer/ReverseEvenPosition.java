package com.coding.pointer;

/**
 * 31 Dec
 * Rearrange a given linked list such that every even node will be moved to the end of the list in reverse order.
 */
public class ReverseEvenPosition {

    public static TestNode reverseOrder(TestNode head) {

        int index=0;
        TestNode evenHead=null;
        TestNode currNodeOld=head;

        //  linked list of even position elements in reverse order
        while(currNodeOld!=null){
            if(index%2!=0){
                TestNode temp=new TestNode(currNodeOld.value);
                temp.next=evenHead;
                evenHead=temp;
            }
            index++;
            currNodeOld=currNodeOld.next;
        }
     
    //   remove even elemnts from original linked list
        index=0;
        currNodeOld=head;
        
        while(currNodeOld!=null && currNodeOld.next!=null){
            if(index%2==0){
                TestNode nextEvenNode=currNodeOld.next;
                currNodeOld.next=nextEvenNode.next; 
            }
            if(currNodeOld.next!=null)
                 currNodeOld=currNodeOld.next; 
        }
        currNodeOld.next=evenHead;

        return head;
    }
    public static void main(String[] args) {
        int[] array={2,3};
        TestNode head=new TestNode(1);
        TestNode currNode=head;
        for(int i=0;i<array.length;i++){
            TestNode temp=new TestNode(array[i]);
            currNode.next=temp;
            currNode=currNode.next;
        }

        head=reverseOrder(head);
        currNode=head;
        while(currNode!=null){
            System.out.println(currNode.value);
            currNode=currNode.next;
        }
    }
    
}
