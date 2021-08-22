package com.yang.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class LeetCode34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        int count = 0;
        while (count < N){
            arr[count++] = in.nextInt();
        }
        int target = in.nextInt();
        System.out.println(Arrays.toString(solution(arr, target)));
    }
    public static int[] solution(int[] arr, int target){
        int left = binarySearch(arr, target, true);
        int right = binarySearch(arr, target, false) - 1;
        if(left <= right && right < arr.length && arr[left] == target && arr[right] == target){
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }
    public static int binarySearch(int[] arr, int target, boolean lower){
        int low = 0, high = arr.length - 1, ans = arr.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] > target || (lower && arr[mid] >= target)){
                high = mid - 1;
                ans = mid;
            }else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
