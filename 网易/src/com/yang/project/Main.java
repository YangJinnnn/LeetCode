package com.yang.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        String str = in.next();
        String[] split = str.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        int M = in.nextInt();
        System.out.println(solution(arr, M));
    }

    public static int solution(int[] arr, int M){
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] <= M){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
