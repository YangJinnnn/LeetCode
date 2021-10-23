package com.yang.project;

public class Main2 {
    public static void main(String[] args) {
        int n = 12321;
        System.out.println(solution(n));
    }
    public static boolean solution(int n){
        int tmp = n;
        int res = 0;
        while (tmp > 0){
            int tail = tmp%10;
            res = res*10 + tail;
            tmp /= 10;
        }
        return res == n;
    }
}
