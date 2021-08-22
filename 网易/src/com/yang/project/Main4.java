package com.yang.project;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] input = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                input[i][j] = in.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(input));
        solution(input);
    }
    static int res = 1000000000;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    public static int solution(int[][] input){
        boolean[][] visited = new boolean[input.length][input[0].length];
        if(input[0][0] == 2){
            return -1;
        }
        else {
            dfs(input, visited, 0, 0, 0);
            System.out.println(res);
            return res==0?-1:res;
        }
    }
    public static void dfs(int[][] input, boolean[][] visited, int n, int m, int cost){
        if(n == input.length-1 && m == input[0].length-1){
            res = Math.min(res, cost);
        }
        int N = input.length;
        int M = input[0].length;
        for (int i = 0; i < 4; i++) {
            int x = n+dx[i];
            int y = m+dy[i];
            if(x>=0&&x<N&&y>=0&&y<M&& !visited[x][y]&&input[x][y]!=2){
                visited[x][y] =true;
                cost += input[x][y]==0?2:1;
                dfs(input, visited, x, y, cost);
                visited[x][y] = false;
                cost -= input[x][y]==0?2:1;
            }
        }
    }
}
//4
//        5
//        1 1 1 1 0
//        0 1 0 1 0
//        1 1 2 1 1
//        0 2 0 0 1