package com.yang.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的堂兄弟节点
 */
public class LeetCode993 {
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

    static TreeNode xParent = null;
    static int xDepth = 0;
    static int x = 4;
    static boolean xFound = false;

    static TreeNode yParent = null;
    static int yDepth = 0;
    static int y = 5;
    static boolean yFound = false;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(4)),
                new TreeNode(3,
                        null,
                        new TreeNode(5)));
        System.out.println(solution(root));
    }

    public static boolean solution(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        update(root, null, 0);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    update(node.left, node, depth+1);
                    queue.add(node.left);
                }
                if(node.right != null){
                    update(node.right, node, depth+1);
                    queue.add(node.right);
                }
            }
            depth++;
            if(xFound&&yFound){
                break;
            }
        }
        return xDepth == yDepth && xParent != yParent;
    }

    public static void update(TreeNode node, TreeNode parent, int depth){
        if(node.val == x){
            xParent = parent;
            xDepth = depth;
            xFound = true;
        }
        if(node.val == y){
            yParent = parent;
            yDepth = depth;
            yFound = true;
        }
    }
}
