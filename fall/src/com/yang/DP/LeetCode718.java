package com.yang.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 最长重复子数组
 */
public class LeetCode718 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] A = new int[n];
//        for (int i = 0; i < n; i++) {
//            A[i] = in.nextInt();
//        }
//        n = in.nextInt();
//        int[] B = new int[n];
//        for (int i = 0; i < n; i++) {
//            B[i] = in.nextInt();
//        }
//        System.out.println(Arrays.toString(A));
//        System.out.println(Arrays.toString(B));
//        System.out.println(solution(A, B));
        List list = new ArrayList();
        list.add(1);
        list.add("dawdawd");
        for(Object value : list){
            System.out.println(value);
        }
    }
    public static int solution(int[] A, int[] B){
        int a = A.length;
        int b = B.length;
        int res = 0;
        int[][] dp = new int[a+1][b+1];
        for (int i = 1; i < a+1; i++) {
            for (int j = 1; j < b+1; j++) {
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
