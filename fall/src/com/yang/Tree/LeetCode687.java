package com.yang.Tree;

/**
 * 最长同值路径
 */
public class LeetCode687 {
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
        TreeNode root = new TreeNode(4,
                new TreeNode(1,
                        new TreeNode(1),
                        new TreeNode(1)),
                new TreeNode(5,
                        null,
                        new TreeNode(5)));
        solution(root);
        System.out.println(res);
    }

    static int res = 0;
    public static int solution(TreeNode root){
        if(root == null) return 0;
        int left = solution(root.left);
        int right = solution(root.right);
        int ltmp = 0, rtmp = 0;
        if(root.left != null && root.left.val == root.val){
            ltmp = left + 1;
        }
        if(root.right != null && root.right.val == root.val){
            rtmp = right + 1;
        }
        res = Math.max(res, ltmp + rtmp);
        return Math.max(ltmp, rtmp);
    }
}
