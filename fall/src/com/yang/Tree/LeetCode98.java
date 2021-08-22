package com.yang.Tree;

/**
 * 验证二叉搜索树
 */
public class LeetCode98 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode(6)));
        System.out.println(solution(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }
    public static boolean solution(TreeNode root, long lower, long upper){
        if(root == null)
            return true;
        if(root.val <= lower || root.val >= upper)
            return false;
        return solution(root.left, lower, root.val) && solution(root.right, root.val, upper);
    }
}
