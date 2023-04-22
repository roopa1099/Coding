package com.coding.tree;

public class TwoIdenticalTree {

    public static boolean isBothIdentical(TreeNode node1, TreeNode node2){

        if(node1==null && node2==null){
            return true;
        }

        if(node1==null || node2==null){
            return false;
        }

    
        if(node1.data==node2.data){
            return isBothIdentical(node1.leftChild, node2.leftChild) && isBothIdentical(node1.rightChild, node2.rightChild);
        }
        
        return false;
        
    }
    
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.leftChild=new TreeNode(4);
        root1.rightChild=new TreeNode(6);
        root1.leftChild.leftChild=null;
        root1.leftChild.rightChild=new TreeNode(5);
        root1.rightChild.leftChild=new TreeNode(7);
        root1.rightChild.rightChild=new TreeNode(6);

        TreeNode root2 = new TreeNode(1);
        root2.leftChild=new TreeNode(4);
        root2.rightChild=new TreeNode(6);
        root2.leftChild.leftChild=null;
        root2.leftChild.rightChild=new TreeNode(5);
        root2.rightChild.leftChild=new TreeNode(7);
        root2.rightChild.rightChild=new TreeNode(6);

        System.out.println(isBothIdentical(root1, root2));
        
    }
}
