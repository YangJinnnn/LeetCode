package com.yang.Array;

import java.util.Scanner;

/**
 * 跳跃游戏
 */
public class LeetCode55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        int count = 0;
        while (count < N){
            arr[count++] = in.nextInt();
        }
        System.out.println(solution(arr));
    }
    public static boolean solution(int[] arr){
        int index = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, i + arr[i]);
            if(i == index){
                index = max;
            }
        }
        return index >= arr.length - 1;
    }
}
