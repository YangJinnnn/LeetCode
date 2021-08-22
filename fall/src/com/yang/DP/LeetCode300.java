package com.yang.DP;

import java.util.Scanner;

/**
 * 最长递增子序列
 */
public class LeetCode300 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        int count = 0;
        while (count<N){
            arr[count++] = in.nextInt();
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
