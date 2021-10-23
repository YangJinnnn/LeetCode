package com.yang.project;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-->0){
            int N = in.nextInt();
            int M1 = in.nextInt();
            int M2 = in.nextInt();
            int[][] G = new int[2*N][2*N];
            Arrays.fill(G, 10000);
            for (int i = 0; i < M1; i++) {
                int v1 = in.nextInt()-1;
                int v2 = in.nextInt()-1;
                G[v1][v2] = 1;
                G[v2][v1] = 1;
            }
            for (int i = 0; i < M2; i++) {
                int v1 = in.nextInt()-1;
                int v2 = in.nextInt()-1;
                G[v1+N][v2+N] = 1;
                G[v2+N][v1+N] = 1;
                G[v1][v1+N] = 0;
                G[v1+N][v1] = 0;
                G[v2+N][v2] = 0;
                G[v2][v2+N] = 0;
            }
            System.out.println(Arrays.deepToString(G));
            System.out.println(1);
        }
    }
//    public static int solution(int[][] G){
//        int res = 0;
//        for (int i = 0; i < G.length; i++) {
//
//        }
//    }
}
