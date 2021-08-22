package com.yang.Array;

import java.util.Scanner;

/**
 * 跳跃游戏Ⅱ
 */
public class LeetCode45 {
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
    public static int solution(int[] arr){
        int index = 0;
        int max = arr[0];
        int step = 0;
        for (int i = 0; i < arr.length-1; i++) {
            max = Math.max(max, i + arr[i]);
            if(i == index){
                index =  max;
                step++;
            }
        }
        return step;
    }
}
