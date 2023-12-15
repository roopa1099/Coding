package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StackStruct{
    TreeNode node;
    int number;

    public StackStruct(TreeNode node, int num){
        this.node=node;
        this.number=num;
    }
}
public class PreInPostTraversal {
    public static void traversal(TreeNode node) {
        Stack<StackStruct> stack=new Stack<>();
        List<Integer> preorder=new ArrayList<>();
        List<Integer> inorder=new ArrayList<>();
        List<Integer> postorder=new ArrayList<>();

        StackStruct struct=new StackStruct(node, 1);
        stack.add(struct);
        while(!stack.isEmpty()){

            struct=stack.pop();

            //preorder
            if(struct.number==1){
                preorder.add(struct.node.data);
                struct.number++;
                stack.add(struct);

                if(struct.node.left!=null){
                    StackStruct newStruct=new StackStruct(struct.node.left, 1);
                    stack.add(newStruct);
                }
            }
            //inorder
              else if(struct.number==2){
                inorder.add(struct.node.data);
                struct.number++;
                stack.add(struct);

                if(struct.node.right!=null){
                    StackStruct newStruct=new StackStruct(struct.node.right, 1);
                    stack.add(newStruct);
                }
            }
            else{
                //postorder
                postorder.add(struct.node.data);
            }
        }
        System.out.println("Preorder "+preorder);
        System.out.println("Inorder "+inorder);
        System.out.println("Postorder "+postorder);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);
        traversal(root);
    }
}
