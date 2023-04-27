package com.coding.tree;

/**
 * Given a binary tree, the task is to check for every node, its value is equal to the sum of values of its immediate left and right child. For NULL values, consider the value to be 0.
 */
public class ChildSumEqualsRoot {
    
    public static boolean isSumEqualToRoot(TreeNode root) {

        if(root.leftChild==null && root.rightChild==null){
            return true;
        }

        if(root.leftChild==null){

            if(root.data==root.rightChild.data){
                 return true;
            }
            else{
                return false;
            }
        }

        if(root.rightChild==null){

            if(root.data==root.leftChild.data){
                 return true;
            }
            else{
                return false;
            }
        }

        if(root.leftChild.data+root.rightChild.data==root.data){
            return isSumEqualToRoot(root.leftChild) && isSumEqualToRoot(root.rightChild); 
        }
        else{
            return false;
        }


    }
    public static void main(String[] args) {
        
        TreeNode root1 = new TreeNode(11);
        root1.leftChild = new TreeNode(7);
        root1.rightChild = new TreeNode(4);
        root1.leftChild.leftChild = new TreeNode(3);
        root1.leftChild.rightChild = new TreeNode(5);
        root1.rightChild.leftChild = new TreeNode(2);
        root1.rightChild.rightChild = new TreeNode(2);

        System.out.println(isSumEqualToRoot(root1));;
    }
}
