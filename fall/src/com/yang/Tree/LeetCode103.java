package com.yang.Tree;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 */
public class LeetCode103 {
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
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        solution(root);
    }
    public static void solution(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()){
            Deque<Integer> tmp = new LinkedList<>();
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if(flag){
                    tmp.offerLast(node.val);
                } else {
                    tmp.offerFirst(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(new ArrayList<>(tmp));
            flag = !flag;
        }
        System.out.println(res);
    }
}
