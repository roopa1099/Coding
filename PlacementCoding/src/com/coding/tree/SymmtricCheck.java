package com.coding.tree;

/**
 * Is tree symmetric=>value on left and right child should be same
 */
public class SymmtricCheck {

    public static boolean isNodeSymmetric(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null) {
            return false;
        }

        if (node2 == null) {
            return false;
        }

        if (node1.data == node2.data) {
            return isNodeSymmetric(node1.leftChild, node2.leftChild)
                    && isNodeSymmetric(node1.rightChild, node2.rightChild);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.leftChild = new TreeNode(4);
        root1.rightChild = new TreeNode(4);
        root1.leftChild.leftChild = new TreeNode(8);
        root1.leftChild.rightChild = new TreeNode(5);
        root1.rightChild.leftChild = new TreeNode(8);
        root1.rightChild.rightChild = new TreeNode(5);
        System.out.println(isNodeSymmetric(root1.leftChild, root1.rightChild));
    }
}
