package miscellaneous_practice;

public class SymmetricalTree {

    public static Boolean isTreeSymmetrical(TreeNode node) {
        return isSymmetric(node.left, node.right);
    }

    private static Boolean isSymmetric(TreeNode lnode, TreeNode rnode) {

        if (lnode == null || rnode == null) {
            // no more child
            return lnode == rnode;
        }

        if (lnode.data != rnode.data) {
            return false;
        }

        return (isSymmetric(lnode.left, rnode.right) && isSymmetric(lnode.right, rnode.left));
    }

    public static void main(String[] args) {

    }
}
