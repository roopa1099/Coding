package miscellaneous_practice;

public class MaxPathSum {

    public static int maxSum(TreeNode node, int maxPathSum) {
        
        if(node==null){
            return 0;
        }

        int leftMaxSum=maxSum(node.left,maxPathSum);
        int rightMaxSum=maxSum(node.right,maxPathSum);

        // sum is negative, it can never add up to max sum
        if(leftMaxSum<0){
            leftMaxSum=0;
        }

        if(rightMaxSum<0){
            rightMaxSum=0;
        }

        maxPathSum=Math.max(maxPathSum, leftMaxSum+rightMaxSum+node.data);

        // possible max sum in a "left or right path"
        return node.data+Math.max(leftMaxSum, rightMaxSum);
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

       System.out.println(maxSum(root,0)); 
    }
}
