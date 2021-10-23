package com.yang.project;

import java.util.Scanner;

public class Main3_HW {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        System.out.println(solution(a, b));
    }
    public static String solution(String a, String b){
        StringBuilder a1 = new StringBuilder(a);
        StringBuilder b1 = new StringBuilder(b);
        a1.reverse();
        b1.reverse();
        int carry = 0;
        int n = a1.length();
        int m = b1.length();
        int i = 0, j = 0;
        StringBuilder res = new StringBuilder();
        while (i < n || j < m || carry != 0){
            int num1 = i<n?a1.charAt(i)-'0':0;
            int num2 = j<m?b1.charAt(j)-'0':0;
            res.append((num1 + num2 + carry) % 10);
            carry = (num1 + num2 +carry) / 10;
            i++;
            j++;
        }
        return res.reverse().toString();
    }
}
