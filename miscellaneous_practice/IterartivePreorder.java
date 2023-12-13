package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * t(n)=N
 * IterartivePreorder
 */
public class IterartivePreorder {

    public static List<Integer> preorder(TreeNode node) {
        List<Integer> result=new ArrayList<Integer>();
        Stack stack=new Stack<TreeNode>();
        stack.push(node);
        while(!stack.empty()){
            //root, left right
            TreeNode valueNode=(TreeNode)stack.pop();
            if(valueNode.right!=null){
                //LIFO so push right first then left
                stack.push(valueNode.right);
            }

            if(valueNode.left!=null){
                stack.push(valueNode.left);
            }
            //root
            result.add(valueNode.data);
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

        System.out.println(preorder(root));
    }
}