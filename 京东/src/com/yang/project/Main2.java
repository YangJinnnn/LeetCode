package com.yang.project;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String s = in.next();
        System.out.println(s);
        int[] res = solution(s);
        for (int i = 0; i < N; i++) {
            System.out.print(res[i]);
            System.out.print(" ");
        }
    }
    public static int[] solution(String sub){
        int[] dp = new int[sub.length()];
        int cnt0 = 0,cnt1 = 0;
        for (int i = 0; i < sub.length(); i++) {
            for (int j = 2; j < i; j++) {

            }
            if(sub.charAt(i) == '0'){
                cnt0++;
                if(cnt1==0){
                    dp[i] = cnt0;
                }else {
                    if(cnt0%cnt1==0){
                        dp[i] = cnt1;
                    }
                    else if(cnt1%cnt0==0){
                        dp[i] = cnt0;
                    }
                    else
                        dp[i] = 1;
                }
            }
            else {
                cnt1++;
                if(cnt0 == 0){
                    dp[i] = cnt1;
                }
                else {
                    if(cnt0%cnt1==0){
                        dp[i] = cnt1;
                    }
                    else if(cnt1%cnt0==0){
                        dp[i] = cnt0;
                    }
                    else
                        dp[i] = 1;
                }
            }
        }
        return dp;
    }
}
