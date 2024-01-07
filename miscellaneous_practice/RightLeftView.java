package miscellaneous_practice;

import java.util.LinkedList;
import java.util.Queue;

public class RightLeftView {

    public static void rightView(TreeNode rNode, Queue queue, int level) {

        if (rNode == null) {
            return;
        }

        // since we r traversing level from right, every time we enter the right side fr
        // a level for first time this is satisfied
        if (queue.size() == level) {
            queue.add(rNode.data);
        }

        if (rNode.right != null) {
            rightView(rNode.right, queue, level + 1);
        }
        if (rNode.left != null) {
            rightView(rNode.left, queue, level + 1);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        rightView(root, queue, 0);
        System.out.println(queue);

    }
}
