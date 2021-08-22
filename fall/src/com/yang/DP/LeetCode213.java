package com.yang.DP;

import java.util.Scanner;

/**
 * 打家劫舍Ⅱ
 */
public class LeetCode213 {
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

    private static int solution(int[] arr) {
        int[] dp1 = new int[arr.length-1];
        int[] dp2 = new int[arr.length-1];

        dp1[0] = arr[0];
        dp1[1] = Math.max(arr[0], arr[1]);
        dp2[0] = arr[1];
        dp2[1] = Math.max(arr[1], arr[2]);
        for (int i = 2; i < arr.length-1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + arr[i]);
        }
        for (int i = 3; i < arr.length; i++) {
            dp2[i-1] = Math.max(dp2[i-2], dp2[i-3] + arr[i]);
        }
        return Math.max(dp1[arr.length-2], dp2[arr.length-2]);
    }
}
