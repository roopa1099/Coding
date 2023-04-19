package com.coding.tree;

import com.coding.tree.TreeNode;;

public class SubtreeOfAnotherTree {

     static int index=-1;
    public static TreeNode buildTree(int[] array){
        index++;


        if(index<array.length || array[index]==-1){
            return null;
        }
        TreeNode node=new TreeNode(array[index]);
        node.leftChild=buildTree(array);
        node.rightChild=buildTree(array);
        return node;
    }

    public static boolean isIdentical(TreeNode node, TreeNode subTree){
        if(node==null && subTree==null){
            return false;
        }

        if(node==null || subTree==null){
            return true;
        }

        
        if(node.data==subTree.data){
            return isIdentical(node.leftChild, subTree.leftChild) || isIdentical(node.rightChild, subTree.rightChild);
        }

        return false;
    }

    public static boolean isSubtree(TreeNode node, TreeNode subTree){

        if(subTree==null){
            return true;
        }

        if(node==null){
            return false;
        }

        if(node.data==subTree.data){
            if(isIdentical(node, subTree)){
                return true;
            };
        }
        return isSubtree(node.leftChild, subTree) || isSubtree(node.rightChild, subTree) ;

    }

    public static void main(String[] args) {
        int[] array1={3,4,1,-1,-1,2,-1,-1,5};
        int[] array2={4,2,-1,-1,2};
        TreeNode root=buildTree(array1);
        TreeNode subTree=buildTree(array2);
        System.out.println( isSubtree(root, subTree));
    }
}
