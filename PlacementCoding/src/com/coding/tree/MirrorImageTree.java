package com.coding.tree;

/**
 * Generate mirror image of BST tree
 */
public class MirrorImageTree {
    
    public  static void mirrorImage(TreeNode root) {

        if(root==null){
            return;
        }

        mirrorImage(root.leftChild);
        mirrorImage(root.rightChild);
        TreeNode temp=root.leftChild;
        root.leftChild=root.rightChild;
        root.rightChild=temp;
        
    }

    public static void printInorder(TreeNode node) {

        if (node == null) {
            return;
        }
        printInorder(node.leftChild);
        System.out.println(node.data);
        printInorder(node.rightChild);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);
        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);
        printInorder(root);
        System.out.println("----------------------");
        mirrorImage(root);
        printInorder(root);
    }
}
