package com.yang.DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 丑数Ⅱ
 */
public class LeetCode264 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(Arrays.toString(solution(n)));
    }

    public static int[] solution(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int num2 = dp[p2]*2;
            int num3 = dp[p3]*3;
            int num5 = dp[p5]*5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if(num2 == dp[i])
                p2++;
            if(num3 == dp[i])
                p3++;
            if(num5 == dp[i])
                p5++;
        }
        return dp;
    }
}
