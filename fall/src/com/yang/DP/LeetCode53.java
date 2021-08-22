package com.yang.DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最大子序和
 */
public class LeetCode53 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        int count = 0;
        while (count < N){
            arr[count++] = in.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        int max = arr[0];
        int pre = 0;
        for (int i = 1; i < arr.length; i++) {
            pre = Math.max(arr[i], pre + arr[i]);
            max = Math.max(max, pre);
        }
        return max;
    }
}
