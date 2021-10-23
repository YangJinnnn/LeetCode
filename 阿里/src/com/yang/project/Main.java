package com.yang.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String A = in.nextLine();
        String B = in.nextLine();
        System.out.println(solution(n, A, B));
    }
    public static int solution(int n, String A, String B){
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int res = 0;
        boolean[] flag = new boolean[n];
        boolean pre = false;
        for (int i = 0; i < n; i++) {
            flag[i] = a[i] != b[i];
            if(flag[i] && flag[i]!=pre){
                res++;
            }
            pre = flag[i];
        }
        return res;
    }
}
