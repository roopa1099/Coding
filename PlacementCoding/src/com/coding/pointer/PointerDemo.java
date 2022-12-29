package com.coding.pointer;

public class PointerDemo {
    TestNode node;
    TestNode head;


    public void addNode(int value) {
     
        TestNode temp=new TestNode(value);
        if(head==null){
            head=temp;
          
        }
        if(node!=null){
            node.next=temp;
           
        }
        node=temp;
    }

    public  void printNode() {
        node=head;
        while(node!=null){
            System.out.println(node.value);
            node=node.next;
        }
    }

    public void deleteKey(int key) {
        node=head;
        if(node!=null && node.value==key){
            head=node.next;
            return;
        }
        while(node!=null && node.next!=null && node.next.value!=key){
            node=node.next;
        }

        if(node.next==null){
            System.out.println("Cannot delete");
            return;
        }

        TestNode deleteNode=node.next;
     
        TestNode updatedNewNode=deleteNode.next;
        node.next=updatedNewNode;
    }

    public static void main(String[] args) {
        PointerDemo obj=new PointerDemo();
        for(int i=0;i<5;i++){
            obj.addNode(i);
        }
        obj.printNode();
        System.out.println();
        obj.deleteKey(2);
        obj.printNode();
        System.out.println();
        obj.deleteKey(7);
        obj.printNode();

        System.out.println();
        obj.deleteKey(4);
        obj.printNode();

        System.out.println();
        obj.deleteKey(0);
        obj.printNode();
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
