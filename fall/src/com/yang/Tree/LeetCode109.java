package com.yang.Tree;

import java.util.Scanner;

/**
 * 有序链表转换二叉搜索数
 */
public class LeetCode109 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }

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
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ListNode hair = new ListNode(-1);
        ListNode p = hair;
        while (n-->0){
            p.next = new ListNode(in.nextInt());
            p = p.next;
        }
        TreeNode root = solution(hair.next);
        while (root!=null){
            System.out.println(root.val);
            root = root.left;
        }
    }
    public static TreeNode solution(ListNode head){
        return helper(head, head, null);
    }
    public static TreeNode helper(ListNode head, ListNode left, ListNode right){
        if(left == right)
            return null;
        ListNode mid = findMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(head, left, mid);
        root.right = helper(head, mid.next, right);
        return root;
    }
    public static ListNode findMid(ListNode left, ListNode right){
        ListNode slow = left;
        ListNode fast = slow;
        while (fast!=right && fast.next!=right){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
