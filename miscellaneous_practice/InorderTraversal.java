package miscellaneous_practice;


class TreeNode{
    int data;
    TreeNode left=null;
    TreeNode right=null;

    public TreeNode(int value){
        data=value;
    }
}

public class InorderTraversal {
    // left, root, right
    public static void inorderTraversal(TreeNode root) {
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }
    
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);

        inorderTraversal(root);
    }
}
