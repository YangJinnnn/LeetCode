package com.yang.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 最大整除子集
 */
public class LeetCode368 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int cnt = 0;
        while (cnt < n){
            nums[cnt++] = in.nextInt();
        }
        System.out.println(solution(nums));
    }

    public static List<Integer> solution(int[] nums){
        List<Integer> list = new ArrayList<>();
        int[] dp = new int[nums.length];
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > maxSize){
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }
        for (int i = nums.length-1; i >= 0 ; i--) {
            if(maxSize == dp[i] && maxVal % nums[i] == 0){
                list.add(nums[i]);
                maxVal = nums[i];
                maxSize --;
            }
        }
        return list;
    }
}
