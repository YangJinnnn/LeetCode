package com.yang.LinkedList;

import java.util.Scanner;

/**
 * 删除排序链表中的重复元素Ⅱ
 */
public class LeetCode82 {
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
        ListNode hair = new ListNode(-1, head);
        ListNode pre = hair;
        while (head!=null){
            if(head.next!=null && head.val == head.next.val){
                while (head.next!=null && head.val == head.next.val){
                    head = head.next;
                }
                head = head.next;
                pre.next = head;
            }
            else {
                pre = pre.next;
                head = head.next;
            }
        }
        return hair.next;
    }
}
