package com.yang.Tree;

/**
 * 上下翻转二叉树
 */
public class LeetCode156 {
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
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));
        TreeNode res = solution(root);
        while (res!=null){
            System.out.println(res.val);
            res = res.right;
        }
    }

    public static TreeNode solution(TreeNode root){
        TreeNode father = null;
        TreeNode right = null;
        while (root != null){
            TreeNode left = root.left;
            root.left = right;
            right = root.right;
            root.right = father;
            father = root;
            root = left;
        }
        return father;
    }
}
