package com.yang.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(solution(n));
    }
    public static int solution(long n){
        long x = n;
        int res = 0;
        while (x>0){
            long tail = x%10;
            x/=10;
            if(tail==0){
                continue;
            }
            if(n%tail==0){
                res++;
            }
        }
        return res;
    }
}
