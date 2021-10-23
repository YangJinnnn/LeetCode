package com.yang.project;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
            if(num[i] > max) {
                max = num[i];
            }
        }
        long[] dp = solution(max);
        for (int i = 0; i < n; i++) {
            if(dp[num[i]] > 0){
                res++;
            }
        }
        System.out.println(res);
    }
    static int res = 0;
    public static long[] solution(int num){
        int[] one = {11, 111, 1111, 11111, 111111, 1111111, 11111111, 111111111};
        long[] dp = new long[num+1];
        dp[0] = 1;
        for(int o:one){
            for (int i = o; i <= num; i++) {
                dp[i] += dp[i-o];
            }
        }
        return dp;
    }
}
//    public static void solution(int[] num, Set<Integer> set){
//        int[] one = new int[8];
//        one[0] = 11;
//        for (int i = 1; i < 8; i++) {
//            one[i] = one[i-1]*10+1;
//        }
//        int p0=1, p1=1, p2=1, p3=1, p4=1, p5=1, p6=1, p7=1;
//        int[] dp = new int[100000000];
//        dp[1] = 0;
//        for (int i = 2; i < 100000000; i++) {
//            int num0 = dp[p0]+one[0];
//            int num1 = dp[p1]+one[1];
//            int num2 = dp[p2]+one[2];
//            int num3 = dp[p3]+one[3];
//            int num4 = dp[p4]+one[4];
//            int num5 = dp[p5]+one[5];
//            int num6 = dp[p6]+one[6];
//            int num7 = dp[p7]+one[7];
//            dp[i] = Math.min(Math.min(Math.min(num0, num1), Math.min(num2, num3)), Math.min(Math.min(num4, num5), Math.min(num6, num7)));
//            if(dp[i] == num0){
//                p0++;
//            }if(dp[i] == num1){
//                p1++;
//            }if(dp[i] == num2){
//                p2++;
//            }if(dp[i] == num3){
//                p3++;
//            }if(dp[i] == num4){
//                p4++;
//            }if(dp[i] == num5){
//                p5++;
//            }if(dp[i] == num6){
//                p6++;
//            }if(dp[i] == num7){
//                p7++;
//            }
//            if(set.contains(dp[i])){
//                res++;
//            }
//        }
//    }