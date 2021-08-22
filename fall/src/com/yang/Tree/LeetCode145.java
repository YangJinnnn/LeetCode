package com.yang.Tree;

import java.util.*;

/**
 * 二叉树的后序遍历
 */
public class LeetCode145 {
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
    private static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(4,
                        new TreeNode(5),
                        new TreeNode(7)));
        solution(root);
    }
    public static void solution(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root!=null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre){
                res.add(root.val);
                pre = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
        }
        System.out.println(res);
    }
}
