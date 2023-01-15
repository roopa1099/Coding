package com.coding.recursion;

/**
 * Print mid of linked list using recursion
 */
public class RecMidOfLL {

    public static int  totalLength(TestNode curr, int totalcount) {
        
        if(curr.next==null){
            totalcount++;
            return totalcount;
        }
        TestNode nextcurr=curr.next;
        totalcount=totalLength(nextcurr, totalcount);
        totalcount++;
        return totalcount; 
    }

    public static int findMid(TestNode curr, int totalcount, int currentCount) {
     
        if(totalcount==0){
            totalcount=totalLength(curr, totalcount);
        }
        
        currentCount++;
        if(totalcount%2==0 && currentCount==totalcount/2){
                return curr.number;
        }
        else if(totalcount%2!=0 && currentCount==totalcount/2+1){
            return curr.number;
        }
     

        TestNode nextcurr=curr.next;
        int mid=findMid(nextcurr, totalcount, currentCount);
        return mid;      
    }

    public static void main(String[] args) {
        TestNode head=new TestNode(2);
        head.next=new TestNode(3);
        head.next.next=new TestNode(4);
        head.next.next.next=new TestNode(5);
        head.next.next.next.next=new TestNode(6);
        head.next.next.next.next.next=new TestNode(7);
        head.next.next.next.next.next.next=new TestNode(8);
        TestNode curr=head;
        int mid=findMid(curr, 0, 0);
        System.out.print(mid);
    }
}

class TestNode{
    int number;
    TestNode next;

    public TestNode(int value){
        number=value;
        next=null;
    }
}
