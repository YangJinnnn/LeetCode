package com.yang.LinkedList;

import java.util.Scanner;

/**
 * 旋转链表
 */
public class LeetCode61 {
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
        int k = in.nextInt();
        ListNode res = solution(hair1.next, k);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode solution(ListNode head, int k){
            ListNode p = head;
            int cnt = 1;
            while (p.next != null){
                p = p.next;
                cnt++;
            }
            int stop = cnt - k%cnt;
            p.next = head;
            while (stop-->0){
                p = p.next;
            }
            ListNode res = p.next;
            p.next = null;
            return res;
    }
}
