package com.yang.Tree;

/**
 * 平衡二叉树
 */
public class LeetCode110 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7, new TreeNode(2), new TreeNode(1))));
        System.out.println(solution(root));
    }

    public static boolean solution(TreeNode root){
        if(root == null){
            return true;
        }
        if(Math.abs(height(root.left) - height(root.right)) > 1)
            return false;
        return solution(root.left) && solution(root.right);
    }

    public static int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(height(node.left), height(node.right))+1;
    }
}
