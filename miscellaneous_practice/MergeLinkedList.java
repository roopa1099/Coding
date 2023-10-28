package miscellaneous_practice;

/**
 * MergeLinkedList
 * 
 * 
 * Merge two sorted linked list witjhout extra space.
 */
public class MergeLinkedList {

    public static Node mergeLL(Node head1, Node head2) {
        Node l1=null,l2=null,temp=null, head;

        if(head1.value<head2.value){
            l1=head1;
            l2=head2;
            head=head1;
            
        }
        else{
            l1=head2;
            l2=head1;
            head=head2;
        }

        temp=l1;
        l1=l1.next;

        while(l1!=null && l2!=null){
            if(l1.value<l2.value){
                temp.next=l1;
                l1=l1.next;
            }
            else{
               temp.next=l2;
                l2=l2.next;
            }
                temp=temp.next;
        }

        while(l1!=null){
             temp.next=l1;
             l1=l1.next;
             temp=temp.next;
        }

        while(l2!=null){
             temp.next=l2;
             l2=l2.next;
             temp=temp.next;
        }

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
        int[] array2={4,5,7,8,9,12,25,30};
        Node head2=createLinkedList(array2);
        Node temp=head1;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
        System.out.println("-------------------------");
        Node temp2=head2;
        while(temp2!=null){
            System.out.println(temp2.value);
            temp2=temp2.next;
        }

  System.out.println("-------------------------");
    System.out.println("-------------------------");

       Node resNode=mergeLL(head1,head2);
        while(resNode!=null){
            System.out.println(resNode.value);
            resNode=resNode.next;
        }
    }
}