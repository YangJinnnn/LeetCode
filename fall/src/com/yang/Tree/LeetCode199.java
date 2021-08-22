package com.yang.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 */
public class LeetCode199 {
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

    static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7, 
                                new TreeNode(2), 
                                new TreeNode(1))),
                new TreeNode(9));
        solution(root);
    }
    
    public static void solution(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                if(size == 0){
                    res.add(node.val);
                }
            }
        }
        System.out.println(res);
    }
}
