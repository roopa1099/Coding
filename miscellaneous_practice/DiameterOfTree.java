package miscellaneous_practice;

public class DiameterOfTree {

    public static int diameter(TreeNode node,int maxPath) {
        if(node==null){
            return 0;
        }

        int lh=diameter(node.left, maxPath);
        int rh=diameter(node.right, maxPath);
        maxPath=Math.max(maxPath, lh+rh);

        //height is returned
        return 1+Math.max(lh,rh);

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

       System.out.println( diameter(root, 0));
    }
}
