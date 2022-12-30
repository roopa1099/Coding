package com.coding.pointer;

/**
 * 30 Dec
 * Write a pop() function that is the inverse of push(). The pop()
 *  function takes a non-empty list, deletes the head node, and returns the head node’s data.
 */
public class PopLL {

    public static TestNode popHead(TestNode head) {
        TestNode popedValue = head;
        if (popedValue == null)
            return null;

        System.out.println("The popped node is " + head.value);
        head = head.next;
        return head;
    }

    public static void main(String[] args) {
        TestNode head=new TestNode(1);
        TestNode temp=head;
        for(int i=2;i<=5;i++){
             temp.next=new TestNode(i);
             temp=temp.next;
        }

        // returns current head
        head=popHead(head);
        System.out.println(head.value);

        head=popHead(head);
        System.out.println(head.value);

        head=popHead(head);
        System.out.println(head.value);
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
