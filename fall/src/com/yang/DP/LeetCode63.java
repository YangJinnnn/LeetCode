package com.yang.DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 不同路径Ⅱ
 */
public class LeetCode63 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(grid));
        System.out.println(solution(grid));
    }

    public static int solution(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if(grid[i][0] == 1)
                continue;
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if(grid[0][i] == 1)
                continue;
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(grid[i][j] == 1)
                    continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m-1][n-1];
    }
}
