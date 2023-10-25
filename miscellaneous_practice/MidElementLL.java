package miscellaneous_practice;

public class MidElementLL {
    // fast and slow pointer
    public static int midElement(Node head) {
        int res=-1;
        Node fastPt=head;
        Node slowPt=head;
         if(head!=null && head.next==null){
            return head.value;
        }
        while(fastPt!=null && fastPt.next!=null){
        
            fastPt=fastPt.next.next;
            if(fastPt!=null){
                    slowPt=slowPt.next;
                    res=slowPt.value;
   
            }
    
        }


        return res;
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
        int[] array={5};
        Node head=createLinkedList(array);
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
        System.out.println("-------------------------");
        System.out.println(midElement(head));
       
    }

}
