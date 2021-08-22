package com.yang.LinkedList;

import java.util.Scanner;

/**
 * 反转链表Ⅱ
 */
public class LeetCode92 {
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
        int left = in.nextInt();
        int right = in.nextInt();
        ListNode res = solution(hair1.next, left, right);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode solution(ListNode head, int left, int right){
        int count = 1;
        ListNode hair = new ListNode(-1, head);
        ListNode pre = hair;
        ListNode p = head;
        while (count<right){
            if(count>=left){
                ListNode nex = p.next;
                p.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
            }
            else {
                pre = pre.next;
                p = p.next;
            }
            count++;
        }
        return hair.next;
    }
}
