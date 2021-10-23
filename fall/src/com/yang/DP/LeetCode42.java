package com.yang.DP;

import java.util.Scanner;

public class LeetCode42 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = in.nextInt();
        }
        System.out.println(solution(height));
    }
    public static int solution(int[] height){
        int n = height.length;
        int[] dp_l = new int[n];
        dp_l[0] = height[0];
        for (int i = 1; i < n; i++) {
            dp_l[i] = Math.max(dp_l[i-1], height[i]);
        }
        int[] dp_r = new int[n];
        dp_r[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            dp_r[i] = Math.max(dp_r[i+1], height[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(dp_l[i], dp_r[i]) - height[i];
        }
        return res;
    }
}
