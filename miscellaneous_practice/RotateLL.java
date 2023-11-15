package miscellaneous_practice;

/**
 * RotateLL
 * 
 * Given a linked list rotate it k times
 */
public class RotateLL {

    public static Node rotateLL(Node head, int k) {
        Node temp=head;

        int count=0;
        while(temp.next!=null){
             temp=temp.next;
             count++;
        }
        count++;
        temp.next=head;

        int p=0;
        temp=head;
        while(p!=count-k-1){
            temp=temp.next;
            p++;
        }

       head=temp.next;
       temp.next=null;
       return head;
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
        int[] array={2,3,5,6,10,23};
        Node head1=createLinkedList(array);
        head1= rotateLL(head1, 2);
        System.out.println("-------------------------");
        System.out.println("-------------------------");


        while(head1!=null){
            System.out.println(head1.value);
            head1=head1.next;
        }
    }

}