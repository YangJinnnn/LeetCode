package com.yang.LinkedList;

import java.util.Scanner;

/**
 * 奇偶链表
 */
public class LeetCode328 {
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
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode solution(ListNode head){
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while (even!=null){
            odd.next = even.next;
            if(even.next != null){
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            else
                even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
