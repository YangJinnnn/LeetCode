package com.yang.LinkedList;

import java.util.Scanner;

/**
 * 分隔链表
 */
public class LeetCode86 {
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
        int x = in.nextInt();
        ListNode res = solution(hair.next, x);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode solution(ListNode head, int x){
        ListNode smallHair = new ListNode(-1);
        ListNode small = smallHair;
        ListNode largeHair = new ListNode(-1);
        ListNode large = largeHair;
        while (head != null){
            if(head.val < x){
                small.next = new ListNode(head.val);
                small = small.next;
            }
            else {
                large.next = new ListNode(head.val);
                large = large.next;
            }
            head = head.next;
        }
        small.next = largeHair.next;
        return smallHair.next;
    }
}
