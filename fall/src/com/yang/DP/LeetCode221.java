package com.yang.DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最大正方形
 */
public class LeetCode221 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        in.nextLine();
        char[][] matrix = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = in.next().charAt(0);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(solution(matrix));
    }

    public static int solution(char[][] matrix){
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        int max = 0;
        for (int i = 0; i < r; i++) {
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int i = 0; i < c; i++) {
            if(matrix[0][i] == '1'){
                dp[0][i] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    if(dp[i][j] > max)
                        max = dp[i][j];
                }
            }
        }
        return max*max;
    }
}
