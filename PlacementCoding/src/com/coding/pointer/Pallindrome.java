package com.coding.pointer;


/**
 * 2nd Jan
 * Given a linked list, check if it is a palindrome or not.
 */
public class Pallindrome {

    public static boolean checkPallindorme(LinkNode head) {

        LinkNode currNode=head;
        LinkNode reverseHead=null;

        if(head==null)
            return false;

        while(currNode!=null){
            LinkNode temp=new LinkNode(currNode.value);
            if(reverseHead==null){
                reverseHead=temp;
            }
            else{
                temp.next=reverseHead;
                reverseHead=temp;
            }
            currNode=currNode.next;
        }

           currNode=head;
           LinkNode newCurrNode=reverseHead;
           
           while(currNode!=null && newCurrNode!=null){
                if(currNode.value!=newCurrNode.value)
                    return false;

                currNode=currNode.next;
                newCurrNode=newCurrNode.next;
           }

           return true;
    }

    public static void main(String[] args) {
        char[] word={'a','d','d','a','m'};
        LinkNode head=new LinkNode('m');
        LinkNode curr=head;
        for(char chr:word){
            LinkNode temp=new LinkNode(chr);
            curr.next=temp;
            curr=temp;
        }


        System.out.println(checkPallindorme(head));
    }
}

class LinkNode{
    
    char value;
    LinkNode next;

    public LinkNode(){
        next = null;
    }
    public LinkNode(char chr){
        this.value=chr;
        this.next=null;
    }
}

    

