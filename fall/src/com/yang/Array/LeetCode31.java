package com.yang.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 下一个排列
 */
public class LeetCode31 {
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
        int index = arr.length - 1;
        for (int i = arr.length - 2;i >= 0; i--){
            if(arr[i] < arr[i+1]){
                index = i;
                break;
            }
        }
        int index_swap = arr.length-1;
        for (int i = arr.length-1; i > index; i--) {
            if(arr[i] > arr[index]){
                index_swap = i;
                break;
            }
        }
        swap(arr, index, index_swap);
        reverse(arr, index+1, arr.length-1);
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverse(int[] arr, int i, int j){
        while (i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
