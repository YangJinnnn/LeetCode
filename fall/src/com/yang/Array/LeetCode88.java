package com.yang.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 合并两个有序数组
 */
public class LeetCode88 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] num1 = new int[m];
        int count = 0;
        while (count < m){
            num1[count++] = in.nextInt();
        }
        int n = in.nextInt();
        int[] num2 = new int[n];
        count = 0;
        while (count < n){
            num2[count++] = in.nextInt();
        }
        System.out.println(Arrays.toString(solution(num1, num2)));
    }
    public static int[] solution(int[] num1, int[] num2){
        int[] merge = new int[num1.length + num2.length];
        int cnt = 0;
        int p1 = 0, p2 = 0;
        while (p1 < num1.length || p2 < num2.length){
            if ( p1 == num1.length)
                merge[cnt++] = num2[p2++];
            else if( p2 == num2.length)
                merge[cnt++] = num1[p1++];
            else if(num1[p1] > num2[p2])
                merge[cnt++] = num2[p2++];
            else
                merge[cnt++] = num1[p1++];
        }
        return merge;
    }
}
