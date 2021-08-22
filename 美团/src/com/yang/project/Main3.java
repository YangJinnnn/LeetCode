package com.yang.project;

import java.util.Scanner;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(solution(s));
    }
    public static Long solution(String s){
        Stack<Long> ss = new Stack<>();
        ss.push(1L);
        char[] c = s.toCharArray();
        long mod = 10000000007L;
        for (char value : c) {
            if (value == '(') {
                ss.push(1L);
            } else {
                Long tmp = ss.pop();
                Long top = ss.pop();
                top = (top * (tmp + 1)) % mod;
                ss.push(top);
            }
        }
        return ss.pop();
    }
}
