package com.yang.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num = 16;
        System.out.println(solution(num));
    }
    public static int solution(int num){
        int res = 0;
        while (num>0){
            num = num & (num -1);
            res++;
        }
        return res;
    }
}
