package com.yang.project;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int m = in.nextInt();
        System.out.println(solution(S, m));
    }
    public static int solution(String S, int m){
        int[] dis = new int[S.length()-1];
        int cnt = S.length();
        for (int i = 0; i < S.length() - 1; i++) {
            int d = Math.abs(S.charAt(i) - S.charAt(i+1))%26;
            dis[i] = Math.min(d, 26-d);
            cnt += Math.min(d, 26-d);
        }
        int tmp = 0;
        for (int i = 0; i < m; i++) {
            tmp += dis[i];
        }
        int max = tmp;
        for (int i = m; i < dis.length-1; i++) {
            tmp += dis[i] - dis[i-m];
            max = Math.max(tmp, max);
        }
        return cnt + Math.min(m - max, 0);
    }
}
