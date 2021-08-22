package com.yang.Tree;

import java.util.*;

/**
 * 二叉树的最近公共祖先
 */
public class LeetCode236 {
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
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4))),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)));
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode res = solution2(root, p, q);
        System.out.println(res.val);

    }
    static HashMap<Integer, TreeNode> parent = new HashMap<>();
    static Set<Integer> set = new HashSet<>();
    public static TreeNode solution2(TreeNode root, TreeNode p, TreeNode q){
        dfs(root);
        while (p!=null){
            set.add(p.val);
            p = parent.get(p.val);
        }
        while (q!=null){
            if(set.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
    public static void dfs(TreeNode root){
        if(root.left != null){
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if(root.right != null){
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
//    static List<TreeNode> pList = new ArrayList<>();
//    static List<TreeNode> qList = new ArrayList<>();
//    public static TreeNode solution(TreeNode root){
//        List<TreeNode> temp = new ArrayList<>();
//        temp.add(root);
//        dfs(root, temp, 5, 4);
//        for (int i = 0; i < pList.size(); i++) {
//            if (pList.get(i) != qList.get(i)){
//                return pList.get(i-1);
//            }
//            if(i==pList.size()-1){
//                return pList.get(i);
//            }
//        }
//        return null;
//    }
//
//    public static void dfs(TreeNode root, List<TreeNode> temp, int p, int q){
//        if (root.val == p){
//            pList = new ArrayList<>(temp);
//        }
//        if (root.val == q){
//            qList = new ArrayList<>(temp);
//            return;
//        }
//        if(root.left!=null){
//            temp.add(root.left);
//            dfs(root.left, temp, p, q);
//        }
//        if(root.right != null){
//            temp.remove(temp.size()-1);
//            temp.add(root.right);
//            dfs(root.right, temp, p, q);
//        }
//    }
}
