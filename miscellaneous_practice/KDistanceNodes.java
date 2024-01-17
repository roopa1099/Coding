package miscellaneous_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KDistanceNodes {

    private static void markParent(TreeNode rNode, Map<TreeNode, TreeNode> pMap) {
        if (rNode == null || (rNode.left == null && rNode.right == null)) {
            return;
        }

        if (rNode.left != null) {
            pMap.put(rNode.left, rNode);
        }
        if (rNode.right != null) {
            pMap.put(rNode.right, rNode);
        }

        markParent(rNode.left, pMap);
        markParent(rNode.right, pMap);
    }

    public static List<Integer> kDistanceNodes(TreeNode root, int distance, TreeNode target) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);
        // parent

        Map<TreeNode, Boolean> visitedMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        visitedMap.put(root, true);
        // add first node

        int curr_level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curr_level == distance) {
                break;
            }
            curr_level++;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();

                // check bottom and up if visisted

                if (currNode.left != null && visitedMap.get(currNode.left) == null) {
                    queue.add(currNode.left);
                    visitedMap.put(currNode.left, true);
                }
                if (currNode.right != null && visitedMap.get(currNode.right) == null) {
                    queue.add(currNode.right);
                    visitedMap.put(currNode.right, true);

                }
                if (parent.get(currNode) != null && visitedMap.get(parent.get(currNode)) == null) {
                    queue.add(parent.get(currNode));
                    visitedMap.put(parent.get(currNode), true);

                }
            }

            // moment curr_level-==distance it will break;
            while (!queue.isEmpty()) {
                res.add(queue.poll().data);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        root.right.right.left.right = new TreeNode(8);
        kDistanceNodes(root, 2, root.right);
    }
}
