package miscellaneous_practice;

/**
 * CheckForPallindrome
 */
public class CheckForPallindrome {

    private static Node reversNode(Node nodeHead) {
        Node nodeNewHead=null;
        Node temp=nodeHead;
        while(temp!=null){
            Node newTemp=new Node(temp.value);
            if(nodeNewHead==null){
                nodeNewHead=temp;
            }
            else{
                newTemp.next=nodeNewHead;
                nodeNewHead=newTemp;
            }
            temp=temp.next;
        }
        return nodeNewHead;
    }

    public static boolean isPalindorme(Node head) {
        Node slowPotNode=head, fastPtNode=head;
        //Find mid
        while(fastPtNode!=null){
            fastPtNode=fastPtNode.next.next;
            if(fastPtNode!=null){
                slowPotNode=slowPotNode.next;
            }
        }

        Node midNode=slowPotNode;
        //Reverse after mid
        Node revNode=reversNode(midNode.next);
        Node headNode=head;

        // compare
        while(revNode!=null){
            if(revNode.value!=headNode.value){
                return false;
            }
            revNode=revNode.next;
            headNode=headNode.next;
        }


        return true;
    }

    public static void main(String[] args) {
        
    }
}