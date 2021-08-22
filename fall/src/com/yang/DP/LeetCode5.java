package com.yang.DP;

import java.util.Scanner;

/**
 * 最长回文子串
 */
public class LeetCode5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(solution(s));
    }

    public static String solution(String s){
        int n = s.length();
        char[] c = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int begin = 0;
        int maxLen = 1;
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n; i++) {
                int j = i+L-1;
                if(j>=n){
                    break;
                }
                if(c[i] != c[j])
                    dp[i][j] = false;
                else {
                    if(L == 2){
                        dp[i][j] = true;
                    }
                    else
                        dp[i][j] = dp[i+1][j-1];
                }
                if(dp[i][j] && L > maxLen){
                    maxLen = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
