package com.yang.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 螺旋矩阵
 */
public class LeetCode54 {
    static final List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = in.nextInt();            }
        }
        solution(matrix);
        System.out.println(res);
    }
    public static void solution(int[][] matrix){
        int M = matrix.length;
        int N = matrix[0].length;
        boolean[][] flag = new boolean[M+2][N+2];
        for (int i = 0; i < M+2; i++) {
            flag[i][0] = true;
            flag[i][N+1] = true;
        }
        for (int i = 0; i < N+2; i++) {
            flag[0][i] = true;
            flag[M+1][i] = true;
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int r = 0, c = 0;
        int trans = 0;
        while (res.size()!=M*N){
            if(!flag[r + 1][c + 1]){
                res.add(matrix[r][c]);
                flag[r+1][c+1] = true;
                r += dy[trans];
                c += dx[trans];
            }
            else {
                r -= dy[trans];
                c -= dx[trans];
                trans = (trans+1)%4;
                r += dy[trans];
                c += dx[trans];
            }
        }
//        for (int i = 0; i <= M; i++) {
//            for (int j = 0; j <= N; j++) {
//                if(flag[i][j]==false){
//                    res.
//                }
//            }
//        }
    }
}
