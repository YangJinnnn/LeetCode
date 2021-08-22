package com.yang.Tree;

/**
 * 二叉树的直径
 */
public class LeetCode543 {
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
    static int ans = 1;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20));

        solution(root);
        System.out.println(ans);
    }

    public static int solution(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = solution(root.left);
        int right = solution(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
