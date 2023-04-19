package com.coding.tree;

public class BinarySearchTree {

    // in ideal situation we consider no duplicate element
    // inrder traversal will give you sorted data(since no duplicate data)
    // value< root=> left child, value>root=> right child
    public static TreeNode insertNode(TreeNode root, int value) {
        // o(n)
        if (root == null) {
            root = new TreeNode(value);
        } else {
            if (value < root.data) {
                root.leftChild = insertNode(root.leftChild, value);
            } else {
                root.rightChild = insertNode(root.rightChild, value);
            }
        }
        return root;
    }

    public static void printInorder(TreeNode node) {

        if (node == null) {
            return;
        }
        printInorder(node.leftChild);
        System.out.println(node.data);
        printInorder(node.rightChild);
    }

    public static boolean isElementExist(TreeNode node, int value) {

        if (node == null) {
            return false;
        }

        if (node.data == value) {
            return true;
        }

        if (node.data < value) {
            return isElementExist(node.rightChild, value);
        } else {
            return isElementExist(node.leftChild, value);
        }

    }

    public static TreeNode deleteNode(TreeNode node, int value) {
        if (value > node.data) {
            node.rightChild = deleteNode(node.rightChild, value);
        } else if (value < node.data) {
            node.leftChild = deleteNode(node.leftChild, value);
        } else {
            // when node is leaf node
            if (node.rightChild == null && node.leftChild == null) {
                return null;
            }

            // only one child
            if (node.leftChild == null) {
                return node.rightChild;
            } else if (node.rightChild == null) {
                return node.leftChild;
            }

            // 2 child
            // find next inroder subsequence, that will replace thi
            // next inorder subsequence will have either 0 or one child at max
            // next inorder subsequence is the one
            TreeNode nextInorderNode = nextInorderSubsequentNode(node.rightChild);
            node.data = nextInorderNode.data;
            // then delete that next inorder node
            node.rightChild= deleteNode(node.rightChild, nextInorderNode.data);
        }

        return node;

    }

    private static TreeNode nextInorderSubsequentNode(TreeNode node) {

        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;

    }

    public static void main(String[] args) {
        int[] array = { 4, 2, 6, 1, 7 };
        TreeNode root = null;
        for (int i = 0; i < array.length; i++) {
            root = insertNode(root, array[i]);
        }
        System.out.println("-----------------");
        printInorder(root);

        System.out.println("-----------------");
        System.out.println(isElementExist(root, 5));

        System.out.println("-----------------");
        deleteNode(root, 6);
        printInorder(root);

        System.out.println("-----------------");
        deleteNode(root, 4);
        printInorder(root);
    }

}
