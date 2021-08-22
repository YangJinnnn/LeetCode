package com.yang.Array;


import java.util.Scanner;

/**
 * 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class LeetCode189 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        int count = 0;
        while (count < N){
            arr[count++] = in.nextInt();
        }
//        for(int a: arr){
//            System.out.println(a);
//        }
        int k = in.nextInt();
        int[] res = solution3(arr, k);
        for (int r :
                res) {
            System.out.println(r);
        }

    }
    public static int[] solution(int[] arr, int k){
        int[] copyarr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyarr[(i+k)%arr.length] = arr[i];
        }
        return copyarr;
    }
    public static int[] solution2(int[] arr, int k){
        int n = arr.length;
        k = k%n;
        int count = gcd(k, n);
        for (int start = 0; start < count; start++) {
            int current = start;
            int prev = arr[current];
            do {
                int next = (current + k) % n;
                int temp = arr[next];
                arr[next] = prev;
                prev = temp;
                current = next;
            }while (start != current);
        }
        return arr;
    }
    public static int gcd(int x, int y){
        return y>0?gcd(y, x%y):x;
    }

    public static int[] solution3(int[] arr, int k){
        int i = 0, j = arr.length-1;
        while (i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
        i = 0; j = k-1;
        while (i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
        i = k; j = arr.length-1;
        while (i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
        return arr;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
