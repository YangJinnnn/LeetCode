package com.yang.DP;

import java.util.Scanner;

/**
 * 完全平方数
 */
public class LeetCode279 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solution(n));
    }
    public static int solution(int n){
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int min = 1000000;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j*j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
