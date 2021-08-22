package com.yang.DP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 无重叠区间
 */
public class LeetCode435 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                intervals[i][j] = in.nextInt();
            }
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        System.out.println(Arrays.deepToString(intervals));
        System.out.println(solution(intervals));
    }

    public static int solution(int[][] intervals){
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if(intervals[i][0] >= intervals[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        return intervals.length - Arrays.stream(dp).max().getAsInt();
    }
}
