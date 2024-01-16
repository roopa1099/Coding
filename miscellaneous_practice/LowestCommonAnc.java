package miscellaneous_practice;

public class LowestCommonAnc {
    public static TreeNode lowestCommonAnces(TreeNode rootNode, int val1, int val2) {
        if (rootNode == null || rootNode.data == val1 || rootNode.data == val2) {
            return rootNode;
        }

        TreeNode lefNode = lowestCommonAnces(rootNode.left, val1, val2);
        TreeNode rigNode = lowestCommonAnces(rootNode.right, val1, val2);

        if (lefNode == null) {
            return rigNode;
        } else if (rigNode == null) {
            return lefNode;
        } else {
            return rootNode;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(lowestCommonAnces(root, 4, 6).data);

    }
}
