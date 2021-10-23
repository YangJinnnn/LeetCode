package com.yang.project;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr));
    }
    public static boolean solution(int[] arr){
        int n = arr.length;
        int cnt = 0;
        int left = 65535;
        int right = 0;
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            if(arr[i] == 0){
                cnt++;
            }else {
                left = Math.min(left, tmp);
                right = Math.max(right, tmp);
            }
        }
        return right-left+1+cnt == n;
    }
}
