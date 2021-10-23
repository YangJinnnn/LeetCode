package com.yang.project;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = in.nextLine();
        }
        long[] pow = new long[20];
        pow[0] = 1;
        for (int i = 1; i <= 18; i++) {
            pow[i] = pow[i-1] * 10;
        }
        for (int i = 0; i < strings.length; i++) {
            long x = Long.parseLong(strings[i]);
            System.out.println(solution(x, pow));
        }
    }
    public static long solution(long x,long[] pow){
        int len = 1;
        long xx = x;
        while (xx>0){
            ++len;
            xx/=10;
        }
        boolean flag = false;
        long res = 0L;
        for (int i = len; i >= 0 ; i--) {
            for (int j = 3; j >= (!flag ?0:1); j--) {
                long tmp = x - pow[i] * j;
                if(tmp > 0 || (tmp == 0 && i==0)){
                    flag = (j != (!flag ?0:1));
                    x = tmp;
                    res += pow[i] * j;
                    break;
                }
            }
        }
        return res;
    }
}
