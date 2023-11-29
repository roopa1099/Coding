package miscellaneous_practice;

public class SumOfElements_LL {

    public static Node sum(Node head1, Node head2) {
        int sum=0, carry=0;
        Node newHead=null;
        Node temp=null;
        while(head1!=null || head2!=null){
            if(head1!=null){
                sum=sum+head1.value;
                head1=head1.next;
            }

             if(head2!=null){
                sum=sum+head2.value;
                head2=head2.next;
            }

            sum=sum+carry;
            carry=sum/10;
            Node newSum=new Node(sum%10);
            if(temp==null){
                temp=newSum;
            }
            else{
            temp.next=newSum;
            temp=newHead;
            }
            
            if(newHead==null){
                newHead=temp;
            }
        }

        sum=sum+carry;
        return newHead;
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
        int[] array={3,4,2};
        Node head1=createLinkedList(array);
        int[] array2={2,5,9,3};
        Node head2=createLinkedList(array2);
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

        Node res=sum(head1,head2);
        while(res!=null){
            System.out.println(res.value);
            res=res.next;
        }
    }}
