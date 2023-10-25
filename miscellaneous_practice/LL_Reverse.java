package miscellaneous_practice;

/**
 * Reverse linked list
 */

/**
 * InnerLL_Reverse
 */
class Node {
int value;
Node next;

public Node(int val){
    this.value=val;
    next=null;
}
    
}
public class LL_Reverse {

    public static Node reverseLinkedList(Node head) {
        Node temp=null;
        Node headNew=null;
        while(head!=null){
            temp=new Node(head.value);
            temp.next=headNew;
            headNew=temp;
            head=head.next;
        }
        return headNew;
    }

    public static Node createLinkedList(int[] array) {
        Node temp=null;
        Node headNew=null;
        temp=headNew;
        for(int i=0;i<array.length;i++){
            Node tempNode=new Node(array[i]);
            if(headNew==null){
                headNew=tempNode;
                temp=headNew;
            }
            else{
              temp.next=tempNode;
              temp=tempNode;
            }
        
     
        }
        return headNew;
    }

    public static void main(String[] args) {
        int[] array={5,2,3,7,9,4};
        Node head=createLinkedList(array);
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
        System.out.println("-------------------------");
        head=reverseLinkedList(head);
        while(head!=null){
            System.out.println(head.value);
            head=head.next;
        }
    }
}