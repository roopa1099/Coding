package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * BoundaryTraversal
 */
public class BoundaryTraversal {

    public static List<Integer> boundaryTraversal(TreeNode node) {

       
        List<Integer> res=new ArrayList<>();
         if(isLeaf(node)){
            res.add(node.data);
            return res;
        }
        addLeftTraversal(node,res);
        addLeafNodeTraversal(node,res);
        addRightReverseTraversal(node,res);
        return res;
    }
    private static void addLeafNodeTraversal(TreeNode node, List<Integer> res) {
       if(isLeaf(node)){
            res.add(node.data);
            return;
       }

       if(node.left!=null) 
            addLeafNodeTraversal(node.left, res);
       if(node.right!=null)
            addLeafNodeTraversal(node.right, res);

    }
    private static void addRightReverseTraversal(TreeNode node, List<Integer> res) {
        List<Integer> temp=new ArrayList<>();
        if(isLeaf(node)){
            return;
        }
        temp.add(node.data);
        if(node.right!=null){
            addRightReverseTraversal(node.right, res); 
        }
        else{
            addRightReverseTraversal(node.left, res);
        }

        for(int i:temp){
            res.add(i);
        }
    }
    private static void addLeftTraversal(TreeNode node, List<Integer> res) {
        if(isLeaf(node)){
            return;
        }
        res.add(node.data);
        if(node.left!=null){
            addLeftTraversal(node.left, res); 
        }
        else{
            addLeftTraversal(node.right, res);
        }
       
    }

    private static boolean isLeaf(TreeNode node){
        return (node.left==null && node.right==null);
    }
    public static void main(String[] args) {

        //anticlockwise
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);
        root.right.right.left=new TreeNode(7);
        root.right.right.left.right=new TreeNode(8);
       System.out.println( boundaryTraversal(root));

        
    }

}