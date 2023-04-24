package com.coding.tree;


/**
 * find the maximum sum path from a leaf to root.
 */
public class MaxSumFromLeafToRoot {

    public static int maxSum(TreeNode root) {

        if(root==null){
            return 0;
        }
        
        int sum=Math.max(maxSum(root.leftChild),maxSum(root.rightChild))+root.data;

        return sum;
    }
    
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10);
        tree.leftChild = new TreeNode(-2);
        tree.rightChild = new TreeNode(7);
        tree.leftChild.leftChild = new TreeNode(8);
        tree.leftChild.rightChild = new TreeNode(-4);


        System.out.println(maxSum(tree));
    }
}