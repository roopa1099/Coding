import java.util.Stack;

// Reverse a Stack without using recursion and extra space. Even the functional Stack is not allowed.
public class RevesrseStack {

    public static void stackRev(Stack stack, int element) {
        if(stack.isEmpty()){
            stack.push(element);
            return;
        }

        int topele=(int)stack.pop();
        stackRev(stack,element);
        stack.push(topele);
        
    }
    
    public static void reverseStack(Stack stack) {
        
       if(stack.isEmpty()){
        return;
       }
                int element=(int)stack.pop();
                reverseStack(stack);
                stackRev(stack, element);
            

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(5);
        s.push(4);
        s.push(5);
        s.push(4);
        System.out.println(s);
        reverseStack(s);
        System.out.println(s);
    }
}
