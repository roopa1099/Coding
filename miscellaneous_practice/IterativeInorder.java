package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorder {

    public static List<Integer> inorder(TreeNode node) {
        List<Integer> result=new ArrayList<Integer>();
        Stack stack=new Stack<TreeNode>();
        while (true) {
            //left root right;
            
            if(node!=null){
             stack.push(node);
             node=node.left;   
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node=(TreeNode)stack.pop();
                result.add(node.data);
                node=node.right;
            }
        }        
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);

        System.out.println(inorder(root));
    }
}
