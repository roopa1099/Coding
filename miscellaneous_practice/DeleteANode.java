package miscellaneous_practice;

public class DeleteANode {

    public static void delete(Node nodeDelete) {
        nodeDelete.value=nodeDelete.next.value;
        nodeDelete.next=nodeDelete.next.next;
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
        Node temp=head1;
        int count=1;
        Node delete=null;
        while(temp!=null){
            if(count==3){
                delete=temp;
            }
            System.out.println(temp.value);
            temp=temp.next;
            count++;
        }

        System.out.println("-------------------------");
        System.out.println("-------------------------");

        delete(delete);
        while(head1!=null){
            System.out.println(head1.value);
            head1=head1.next;
        }
    }
}
