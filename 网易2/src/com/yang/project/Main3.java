package com.yang.project;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long s = in.nextLong();
        System.out.println(solution(s));
    }
    public static int solution(long s){
        int res = 0;
        long s2 = s;
        while (s != 0){
            s = s & (s-1);
            res++;
        }
        int cnt = 0;
        long i;
        for (i = 1; i < s2; i*=2) {
        }
        long s3 = i-s2;
        while (s3 != 0){
            s3 = s3&(s3-1);
            cnt++;
        }
        return Math.min(res, cnt+1);
    }
}
