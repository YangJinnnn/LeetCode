package com.yang.LinkedList;

import java.util.Scanner;

/**
 * 重排链表
 */
public class LeetCode143 {
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
        ListNode hair = new ListNode(-1);
        ListNode p = hair;
        while (N-->0){
            p.next = new ListNode(in.nextInt());
            p = p.next;
        }
        ListNode res = solution(hair.next);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode solution(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;
        l2 = reverse(l2);
        return merge(l1, l2);
    }

    public static ListNode reverse(ListNode mid){
        ListNode pre = null;
        while (mid != null){
            ListNode nex = mid.next;
            mid.next = pre;
            pre = mid;
            mid = nex;
        }
        return pre;
    }

    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode head = l1;
        ListNode p1;
        ListNode p2;
        while (l1 !=null && l2 !=null){
            p1 = l1.next;
            p2 = l2.next;

            l1.next = l2;
            l1 = p1;

            l2.next = l1;
            l2 = p2;
        }
        return head;
    }
}
