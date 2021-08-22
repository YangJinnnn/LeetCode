package com.yang.DP;

import java.util.Scanner;

/**
 * 乘积最大子数组
 */
public class LeetCode152 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int cnt = 0;
        while (cnt<n){
            nums[cnt++] = in.nextInt();
        }
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums){
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = Math.max(Math.max(nums[i], mx*nums[i]), mn*nums[i]);
            min = Math.min(Math.min(nums[i], mx*nums[i]), mn*nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
