package com.yang.project;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        System.out.println(solution(a, b, c));
    }
    public static long solution(long a, long b, long c){
        double a2 = Math.sqrt(a);
        double a3 = Math.pow(a, 1.0 / 3.0);
        double b2 = Math.sqrt(b);
        double b3 = Math.pow(b, 1.0 / 3.0);
        long res = 0;
        for (long x = a2%1==0?(long)a2:((long)a2+1); x < (b2%1==0?b2+1:b2); x++) {
            for (long y = a3%1==0?(long)a3:((long)a3+1); y < (b3%1==0?b3+1:b3); y++) {
                if(Math.abs(Math.pow(x, 2) - Math.pow(y, 3)) <= c){
                    res++;
                }
            }
        }
        return res;
    }
}
