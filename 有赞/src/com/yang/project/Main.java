package com.yang.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(solution(s));
    }
    public static int solution(String s){
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
            if(i>1&&s.charAt(i-2)!='0'&&((s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0')<=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
