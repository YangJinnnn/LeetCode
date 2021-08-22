package com.yang.Array;

import java.util.Scanner;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class LeetCode11 {
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
        int i = 0, j = arr.length-1;
        int res = 0;
        while (i<=j){
            int area = (j - i) * Math.min(arr[i], arr[j]);
            if(arr[i]>arr[j])
                j--;
            else
                i++;
            res = Math.max(res, area);
        }
        return res;
    }
}
