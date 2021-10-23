package com.yang.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        int a = 11;
        int b = 111;
        int res = 0;
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
            for (int j = 0; j <= Math.ceil(num[i]/a); j++) {
                if((num[i] - j*a) % b == 0){
                    res++;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
