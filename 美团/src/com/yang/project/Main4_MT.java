package com.yang.project;

import java.util.Arrays;
import java.util.Scanner;

public class Main4_MT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Long[] arr = new Long[n];
        int cnt = 0;
        while (cnt < n){
            arr[cnt++] = in.nextLong();
        }
        int m = in.nextInt();
        int[] opt = new int[m];
        int[] L = new int[m];
        int[] R = new int[m];
        cnt = 0;
        while (cnt < m){
            opt[cnt] = in.nextInt();
            L[cnt] = in.nextInt();
            R[cnt] = in.nextInt();
            cnt++;
        }
        for (int i = 0; i < opt.length; i++) {
            if(opt[i] == 1){
                System.out.println(solution1(arr, L[i], R[i]));
            }else if(opt[i] == 2){
                System.out.println(solution2(arr, L[i], R[i]));
            }else {
                System.out.println(solution3(arr, L[i], R[i]));
            }
        }
    }
    public static int solution1(Long[] arr, int L, int R){
        int ans = 0;
        for (int i = L-1; i < R; i++) {
            ans += arr[i];
        }
        return ans;
    }
    public static Long solution2(Long[] arr, int L, int R){
        long res = 0L;
        Long tmp = 0L;
        for (int j = L-1; j < R; j++) {
            tmp += arr[j];
        }
        for (int i = L-1; i < R; i++) {
            res += (tmp - arr[i])*(tmp - arr[i]);
        }
        return res;
    }
    public static Long solution3(Long[] arr, int L, int R){
        Long max = arr[L-1];
        for (int i = L; i < R; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
