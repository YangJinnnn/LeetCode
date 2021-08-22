package com.yang.LinkedList;

import java.util.Scanner;

/**
 * 删除链表的倒数第N个结点
 */
public class LeetCode19 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ListNode hair1 = new ListNode(-1);
        ListNode p = hair1;
        while (N-->0){
            p.next = new ListNode(in.nextInt());
            p = p.next;
        }
        int n = in.nextInt();
        ListNode res = solution(hair1.next, n);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode solution(ListNode head, int n){
        ListNode pre = new ListNode(-1, head);
        ListNode p = pre;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        while (q!=null){
            q = q.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return p.next;
    }
}
