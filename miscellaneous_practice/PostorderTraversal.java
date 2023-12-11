package miscellaneous_practice;

public class PostorderTraversal {
    public static void postOrderTraverse(TreeNode node) {
        // left, right, post
        if(node==null){
            return;
        }
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.println(node.data);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);

        postOrderTraverse(root);
    }
}
