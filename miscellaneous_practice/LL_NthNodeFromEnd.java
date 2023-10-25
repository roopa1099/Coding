package miscellaneous_practice;

/**
 * Logic????
 * Fast pointer slow poiter
 */
public class LL_NthNodeFromEnd {

    public static void nthNodeFromEnd(Node head, int k) {
        Node temp=head;
        
        int count=0;
        while(count<=k){
            temp=temp.next;
            count++;
        }

        Node fasterNode=temp;
        Node slowerNode=head;

        while(fasterNode!=null){
            fasterNode=fasterNode.next;
            slowerNode=slowerNode.next;
        }

        slowerNode.next=slowerNode.next.next;

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
        int[] array={5,2,3,7,9,4,8};
        Node head=createLinkedList(array);
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
        System.out.println("-------------------------");
        nthNodeFromEnd(head,2);
        while(head!=null){
            System.out.println(head.value);
            head=head.next;
        }
    }
}
