package com.yang.project;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(arr));
        int[][] res = solution(arr, k);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] solution(int[][] arr, int k){
        int n = arr.length;
        int nk = n*k;
        int[][] res = new int[nk][nk];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int tmp = arr[i][j];
                for (int l = i*k; l < i*k+k; l++) {
                    for (int m = j*k; m < j*k+k; m++) {
                        res[l][m] = tmp;
                    }
                }
            }
        }
        return res;
    }
}
