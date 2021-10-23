package com.yang.LinkedList;

import java.util.Scanner;

public class LeetCode25 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {this.val = val;}
        ListNode(int val ,ListNode next) {this.val = val; this.next = next;}
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
        int k = in.nextInt();
        ListNode node = solution(hair.next, k);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    public static ListNode solution(ListNode head, int k){
        ListNode hair = new ListNode(-1, head);
        ListNode pre = hair;
        while (head != null){
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if(tail == null){
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = helper(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }
    public static ListNode[] helper(ListNode head, ListNode tail){
        ListNode pre = tail.next;
        ListNode p = head;
        while (pre != tail){
            ListNode nex = p.next;
            p.next = pre;
            pre = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
