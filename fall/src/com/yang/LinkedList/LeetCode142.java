package com.yang.LinkedList;

import java.util.Scanner;

/**
 * 环形链表Ⅱ
 */
public class LeetCode142 {
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
        int pos = in.nextInt();
        ListNode index = null;
        while (N-->0){
            p.next = new ListNode(in.nextInt());
            p = p.next;
            if(N == pos)
                index = p;
        }
        p.next = index;
        ListNode res = solution(hair1.next);
        System.out.println(res.val);
    }
    public static ListNode solution(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null){
            slow = slow.next;
            if(fast.next != null)
                fast = fast.next.next;
            else
                return null;
            if(slow == fast){
                ListNode p = head;
                while (p != slow){
                    slow = slow.next;
                    p = p.next;
                }
                return p;
            }
        }
        return null;
    }
}
