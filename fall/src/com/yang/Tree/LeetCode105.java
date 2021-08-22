package com.yang.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 从前序与中序遍历构造二叉树
 */
public class LeetCode105 {
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
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] preorder = new int[n];
        int cnt = 0;
        while (cnt < n){
            preorder[cnt++] = in.nextInt();
        }
        cnt = 0;
        int[] inorder = new int[n];
        while (cnt < n){
            inorder[cnt++] = in.nextInt();
        }
        TreeNode res = solution(preorder, inorder);
        while (res != null){
            System.out.println(res.val);
            res = res.right;
        }
    }

    public static TreeNode solution(int[] preorder, int[] inorder){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    public static TreeNode helper(int[] preorder, int pre_s, int pre_e,
                                  int[] inorder, int in_s, int in_e,
                                  HashMap<Integer, Integer> map){
        if(pre_s == pre_e){
            return null;
        }
        int val = preorder[pre_s];
        TreeNode root = new TreeNode(val);
        int index = map.get(val);
        int gap = index - in_s;
        root.left = helper(preorder, pre_s+1, pre_s+gap+1, inorder, in_s, index, map);
        root.right = helper(preorder, pre_s+gap+1, pre_e, inorder, index+1, in_e, map);
        return root;
    }
}
