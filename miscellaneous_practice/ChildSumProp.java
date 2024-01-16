package miscellaneous_practice;

/**
 * Problem Statement: Children Sum Property in a Binary Tree. Write a program
 * that converts any binary tree to one that follows the children sum property.
 * 
 * The children sum property is defined as, For every node of the tree, the
 * value of a node is equal to the sum of values of its children(left child and
 * right child).
 * 
 * Note:
 * 
 * The node values can be increased by 1 any number of times but decrement of
 * any node value is not allowed.
 * A value for a NULL node can be assumed as 0.
 * You are not allowed to change the structure of the given binary tree.
 */
public class ChildSumProp {
    public static void checkChildSumProp(TreeNode rNode) {

        if (rNode == null) {
            return;
        }

        int child = 0;
        child = child + rNode.left.data;
        child = child + rNode.right.data;

        if (child > rNode.data) {
            // can go up
            rNode.data = child;
        } else {
            if (rNode.left != null) {
                rNode.left.data = rNode.data;
            }
            if (rNode.right != null) {
                rNode.right.data = rNode.data;
            }
        }

        checkChildSumProp(rNode.left);
        checkChildSumProp(rNode.right);

        int total = 0;
        if (rNode.left != null) {
            total += rNode.left.data;
        }
        if (rNode.right != null) {
            total += rNode.right.data;
        }

        if (rNode.left != null || rNode.right != null) {
            rNode.data = total;
        }

    }
}
