package com.yang.DP;

import java.util.Scanner;

/**
 * 打家劫舍
 */
public class LeetCode198 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int count = 0;
        while (count<n){
            arr[count++] = in.nextInt();
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }
        return dp[arr.length-1];
    }
}
