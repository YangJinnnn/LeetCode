package com.yang.Tree;

/**
 * 二叉树的最大深度
 */
public class LeetCode104 {
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
                        new TreeNode(7)));
        System.out.println(solution(root));
    }

    public static int solution(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(solution(root.left), solution(root.right))+1;
    }
}
