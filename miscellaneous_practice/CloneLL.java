package miscellaneous_practice;



class NewNode {
int value;
NewNode next;
NewNode random;

public NewNode(int val){
    this.value=val;
    next=null;
    random=null;
}
}
   

/**
 * CloneLL
 */
public class CloneLL {

    public static NewNode cloneLinkedList(NewNode head) {
        // Step 1 add deep copy in between
        NewNode iterator=head;
        while(iterator!=null){
            NewNode node=new NewNode(iterator.value);
            node.next=iterator.next;
            iterator.next=node;
            iterator=iterator.next.next;
        }

        // Step 2 add random for deep copy nodes
        iterator=head;
        while (iterator!=null) {
            iterator.next.random=iterator.random.next;
            iterator=iterator.next.next;
        }

        //step 3 disconnect original lisnked list
        iterator = head;
        NewNode newHead = null;
        NewNode newIterator = null;
        
        while (iterator != null) {
            NewNode copyNode = iterator.next; // Move the initialization inside the loop
        
            if (copyNode != null) {
                NewNode frontNode = copyNode.next;
                
                if (newHead == null) {
                    newHead = copyNode;
                    newIterator = newHead;
                } else {
                    newIterator.next = copyNode;
                    newIterator = newIterator.next;
                }
        
                copyNode.next = frontNode != null ? frontNode.next : null;
                iterator.next = frontNode;
                iterator = iterator.next;
            } else {
                // Handle the case where copyNode is null (last node in the original list)
                iterator = null;
            }
        }
        return newHead;
    }
    private static void displayLinkedList(NewNode head) {
        NewNode current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.random != null) {
                System.out.print(" (random: " + current.random.value + ")");
            }
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        NewNode head = new NewNode(1);
        NewNode node2 = new NewNode(2);
        NewNode node3 = new NewNode(3);

        head.next = node2;
        node2.next = node3;

        // Add random pointers for testing (pointing to a different node)
        head.random = node3;
        node2.random = head;
        node3.random = node2;

        // Display the original linked list
        System.out.println("Original Linked List:");
        displayLinkedList(head);

          // Clone the linked list
          NewNode clonedHead = cloneLinkedList(head);

          // Display the cloned linked list
          System.out.println("\nCloned Linked List:");
          displayLinkedList(clonedHead);
    }
}