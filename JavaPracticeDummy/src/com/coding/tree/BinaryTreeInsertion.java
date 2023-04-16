package com.coding.tree;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int data){
        this.data=data;
        this.leftChild=null;
        this.rightChild=null;
    }
}
public class BinaryTreeInsertion {

     static int index=-1;
    public  static TreeNode createTree(int[] array) {
        index++;
        if (array[index] == -1) {
            return null;
        }

        TreeNode temp = new TreeNode(array[index]);
        temp.leftChild = createTree(array);
        temp.rightChild = createTree(array);
        return temp;
    }

    public static void printPreOrder(TreeNode node){
        if(node==null) return;

        System.out.println(node.data);
        printPreOrder(node.leftChild);
        printPreOrder(node.rightChild);
    }

    public static void printPostOrder(TreeNode node){
        if(node==null) return;


        printPreOrder(node.leftChild);
        printPreOrder(node.rightChild);
        System.out.println(node.data);
    }

    public static void printLevelOrder(TreeNode node){
        //        O(n)
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        q.add(null);
        while(!q.isEmpty()){
            if(q.peek()==null){
                System.out.println();
                q.remove();
                if(!q.isEmpty())
                     q.add(null);
                else{
                    return;
                }
            }
            else{
                System.out.print(q.peek().data+" ");
                TreeNode currNode=q.peek();
                q.remove();
                if(currNode.leftChild!=null)
                    q.add(currNode.leftChild);

                if(currNode.rightChild!=null)
                    q.add(currNode.rightChild);
            }

        }

    }

    public static int countNodes(TreeNode node) {
//        O(n)
        if(node==null) return 0;

        int leftCountNodes=countNodes(node.leftChild);
        int rightCountNodes=countNodes(node.rightChild);
        return leftCountNodes+rightCountNodes+1;
    }

    public static int sumOfNodes(TreeNode node) {
//        O(n)
        if(node==null) return 0;

        int leftCountNodes=sumOfNodes(node.leftChild);
        int rightCountNodes=sumOfNodes(node.rightChild);
        return leftCountNodes+rightCountNodes+node.data;
    }

    public static int heightOfNodes(TreeNode node) {
//        O(n)
        if(node==null) return 0;

        int leftCountNodes=heightOfNodes(node.leftChild);
        int rightCountNodes=heightOfNodes(node.rightChild);
        return Math.max(leftCountNodes,rightCountNodes)+1;
    }

    static class TreeInfo{
        int height;
        int diameter;

        public TreeInfo(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static TreeInfo diameterOfTree(TreeNode node) {
//        max of left tree diam, right tree diam, (leftMaxHeight+RightMaxHeight+1)
//        since we calculate height and diam at same time it is O(n) time
// 3 things => either max number of nodes are in left, or max number of is in right, or max includes root(in this case height comes in play)
        if(node==null)
            return new TreeInfo(0,0);
        TreeInfo leftTreeInfo =diameterOfTree(node.leftChild);
        TreeInfo rightTreeInfo =diameterOfTree(node.rightChild);

        int height=Math.max(leftTreeInfo.height,rightTreeInfo.height)+1;
        int diam1=leftTreeInfo.diameter;
        int diam2=rightTreeInfo.diameter;
        int diam3=leftTreeInfo.height+rightTreeInfo.height+1;
        int diameter=Math.max(Math.max(diam1,diam2),diam3);
        return new TreeInfo(height,diameter);
    }

    public static void main(String[] args) {
        int[] array={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        TreeNode root=null;
        root=createTree(array);
        printPreOrder(root);
        System.out.println("--------------------------------");

        printPostOrder(root);
        System.out.println("--------------------------------");
        printLevelOrder(root);

        System.out.println("--------------------------------");
        System.out.println(countNodes(root));

        System.out.println("--------------------------------");
        System.out.println(sumOfNodes(root));

        System.out.println("--------------------------------");
        System.out.println(heightOfNodes(root));


        System.out.println("--------------------------------");
        System.out.println(diameterOfTree(root).diameter);
    }
}
