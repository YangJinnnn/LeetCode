package com.yang.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 颜色分类
 */
public class LeetCode75 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        int count = 0;
        while (count < N){
            arr[count++] = in.nextInt();
        }
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void solution(int[] arr){
        int p0 = 0, p1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
                int temp = arr[i];
                arr[i] = arr[p1];
                arr[p1] = temp;
                p1++;
            }
            else if(arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[p0];
                arr[p0] = temp;
                if (p0 < p1){
                    temp = arr[i];
                    arr[i] = arr[p1];
                    arr[p1] = temp;
                }
                p0++;
                p1++;
            }
        }
    }
}
