package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostorder {
  //  t(n)= 2Ngoing and coming back
    //using 1 stack
    public static List<Integer> postorder(TreeNode node) {

        //left right root
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack();
        TreeNode currNode=node;
          TreeNode temp;
        if(currNode!=null){
            //check and insert first node
            stack.add(currNode);
            currNode=currNode.left;
        }
        while(!stack.isEmpty()){
            if(currNode!=null){
                stack.add(currNode);
                currNode=currNode.left;
            }
            else{
                //top is currently root so check right now
              temp=((TreeNode)stack.peek()).right;
              if(temp==null){
                temp=(TreeNode)stack.pop();
                result.add(temp.data);
                // now after popping if the poped node was right of top then next we will push root if it was left then
                // you again have to check for right node so you come back to loop again to check right exists or not
                while(!stack.isEmpty() && temp==((TreeNode)stack.peek()).right){
                    //since it was right nect will be root 
                    temp=(TreeNode)stack.pop();
                    result.add(temp.data);
                }

              }
              else{
                currNode=temp;
              }
            }
        }
        return result;
    }

    //using two stack
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);

        System.out.println(postorder(root));
    }

}
