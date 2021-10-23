package com.yang.Array;

import java.util.Arrays;
import java.util.Scanner;

public class quickSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        solution(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void solution(int[] arr, int low, int high){
        if(low < high){
            int prviot = helper(arr, low, high);
            solution(arr, low, prviot);
            solution(arr, prviot+1, high);
        }
    }
    public static int helper(int[] arr, int low, int high){
        int tmp = arr[low];
        while (low < high){
            while (low < high && arr[high] > tmp){
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < tmp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }
}
