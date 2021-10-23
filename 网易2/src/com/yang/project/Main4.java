package com.yang.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        in.nextLine();
        char[][] G = new char[n][n];
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            String tmp = in.nextLine();
            for (int j = 0; j < n; j++) {
                G[i][j] = tmp.charAt(j);
                if(tmp.charAt(j) == '*'){
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    list.add(new ArrayList<>(l));
                }
            }
        }
        System.out.println(Arrays.deepToString(G));
    }
    static List<Integer> ans = new ArrayList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void solution(char[][] G, int a, int b){
        int n = G.length;
        int[][] dp = new int[n][n];
        if(G[0][0] == '.'){
            if(G[0][1] == '.'){
                dp[0][1] = 0;
            }else if(G[0][1] == '#'){
                dp[0][1] = a;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
    }
}
