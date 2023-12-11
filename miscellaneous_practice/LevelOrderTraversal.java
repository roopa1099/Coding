package miscellaneous_practice;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void levelOrder(TreeNode node) {

        if(node==null){
            return;
        }

        if(node.left==null && node.right==null){
            System.out.println(node.data);
            return;
        }

        Queue queue=new LinkedList<>();

        queue.add(node);
        queue.add(null);

        while(queue.size()!=0){
            TreeNode nodePop=(TreeNode) queue.remove();
            if(nodePop==null){
                if(queue.size()>0){
                    queue.add(null);
                }
               
                System.out.println();
            }
            else{
            if(nodePop.left!=null){
                queue.add(nodePop.left);
            }
           
            if(nodePop.right!=null){
                queue.add(nodePop.right);
            }

            System.out.print(nodePop.data+" ");
            }
           
        }
        
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);

        levelOrder(root);
    }
}
