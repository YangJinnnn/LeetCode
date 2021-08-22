package com.yang.LinkedList;

import java.util.Scanner;

/**
 * 两数相加
 */
public class LeetCode2 {
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
        int M = in.nextInt();
        ListNode hair2 = new ListNode(-1);
        ListNode q = hair2;
        while (M-->0){
            q.next = new ListNode(in.nextInt());
            q = q.next;
        }
        ListNode res = solution(hair1.next, hair2.next);
//        ListNode res = hair1.next;
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode solution(ListNode l1, ListNode l2){
        int carry = 0;
        ListNode hair = new ListNode(-1);
        ListNode p = hair;
        while (carry != 0 || l1!=null || l2 != null){
            int num1 = l1==null?0:l1.val;
            int num2 = l2==null?0:l2.val;
            p.next = new ListNode((num1+num2+carry)%10);
            p = p.next;
            carry = (num1+num2+carry)/10;
            l1 = l1==null?l1:l1.next;
            l2 = l2==null?l2:l2.next;
        }
        return hair.next;
    }
}
