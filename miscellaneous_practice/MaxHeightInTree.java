package miscellaneous_practice;

public class MaxHeightInTree {

    public static int maxHeight(TreeNode node) {
        
        if(node==null){
            return 0;
        }

        int lh=maxHeight(node.left);
        int rh=maxHeight(node.right);
        return Math.max(lh, rh)+1;
    }

    private static int heightTree(TreeNode node) {
        if(node==null){
            return 0;
        }
        int lh=heightTree(node.left);
        int rh=heightTree(node.right);

        if(lh==-1 || rh==-1){
            return -1;
        }

        if(Math.abs(lh-rh)>1){
            return -1;
        }

        return Math.max(lh, rh)+1;
    }

    public static Boolean isBalanced(TreeNode node) {

        // for every node lh-rh should be <= 1 to be balanced
        if(heightTree(node)>-1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);
        root.right.right.left=new TreeNode(7);
         root.right.right.left.right=new TreeNode(8);

       System.out.println(maxHeight(root));

        System.out.println(isBalanced(root));
    }
    
}
