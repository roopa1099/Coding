package com.coding.pointer;


/**
 * Given a linked list containing 0's, 1's, and 2's, sort the linked list
 */
public class Sort0sAnd1s {

    // 1>0>2>0>1>2
    public static TestNode sort(TestNode head) {
        
        TestNode currNode=head;
        if(head==null){
            return null;
        }

        while(currNode!=null && currNode.next!=null){
            currNode=currNode.next;
        }

        TestNode lastElement=currNode;
        
        while(head.value==2){
            TestNode temp=head;
            head=head.next;
            temp.next=lastElement.next;
            lastElement.next=temp;
        }

        TestNode firstElement=head;
        currNode=firstElement;


        while(currNode.next!=null && currNode.next!=lastElement.next){

            if(currNode.next!=null && currNode.next.value==0){
                if(currNode.next!=lastElement){
                TestNode temp=currNode.next;
                currNode.next=temp.next;
                temp.next=firstElement;
                head=temp;
                firstElement=temp;  
                }
                else{
                    // astelemnt will change if last elemnt was zero
                    TestNode temp=currNode.next;
                    currNode.next=temp.next;
                    temp.next=firstElement;
                    head=temp;
                    firstElement=temp; 
                    lastElement=currNode;
                }
            }

            else if(currNode.next!=null && currNode.next.value==2){
                TestNode temp=currNode.next;
                currNode.next=temp.next;
                temp.next=lastElement.next;
                lastElement.next=temp;
            }

            else{     
                     currNode=currNode.next;
            }
        }


        return head;
    }
    public static void main(String[] args) {
        int[] array={1,2,1,1,0,2,2,1,2,1};
        TestNode head=new TestNode(2);
        TestNode cNode=head;
        for(int i=0;i<array.length;i++){
            TestNode temp=new TestNode(array[i]);
            cNode.next=temp;
            cNode=cNode.next;
        }


        head=sort(head);
        cNode=head;
        while(cNode!=null){
            System.out.println(cNode.value);
            cNode=cNode.next;
        }
    }
    
}
