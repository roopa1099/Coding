package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;

public class RootToNode {

    public static Boolean rootToNode(TreeNode node, int value, List<Integer> list) {
        if (node == null) {
            return false;
        }

        list.add(node.data);
        if (node.data == value) {
            return true;
        }

        if (rootToNode(node.left, value, list) || rootToNode(node.right, value, list)) {
            return true;
        }

        list.remove(list.size() - 1);
        return false;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<Integer> arrayList = new ArrayList<>();
        rootToNode(root, 8, arrayList);
        System.out.println(arrayList);
    }
}
