package com.yang.project;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-->0){
            int N = in.nextInt();
            int M = in.nextInt();
            int[] H = new int[N];
            for (int i = 0; i < N; i++) {
                H[i] = in.nextInt();
            }
            System.out.println(solution(H, M));
        }
    }
    public static int solution(int[] H, int M){
        int l = M-1, r = M-1;
        int flag1 = 0, flag2 = 0;
        int res = 0;
        while (!(flag1==1&&flag2==1)){
            if(H[l] > H[M-1] || l==0){
                flag1 = 1;
            }else {
                l--;
            }
            if(H[r] > H[M-1] || r==H.length-1){
                flag2 = 1;
            }else {
                r++;
            }
        }
        int cnt = 0;
        for (int i = 0; i < l && i<M-1; i++) {
            if(H[i] == H[i+1]){
                continue;
            }
            res += H[i] > H[i+1] ? cnt == 1? 1:0:0;
            cnt = H[i] > H[i+1] ? -1 : 1;
        }
        if(cnt == 1){
            res++;
        }
        cnt = 0;
        for (int i = H.length-1; i > r && i > M-1; i--) {
            if(H[i] == H[i-1]){
                continue;
            }
            res += H[i] > H[i-1] ? cnt == 1? 1:0:0;
            cnt = H[i] > H[i-1] ? -1 : 1;
        }
        if(cnt == 1){
            res++;
        }
        return res;
    }
}
