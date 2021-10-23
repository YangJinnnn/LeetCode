package com.yang.Array;

import java.util.Scanner;

/**
 * 搜索旋转排序数组
 */
public class LeetCode33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        int count = 0;
        while (count < N){
            arr[count++] = in.nextInt();
        }
        int target = in.nextInt();
        System.out.println(solution(arr, target));
    }
    public static int solution(int[] arr, int target){
        int index = -1;
        int low = 0, high = arr.length-1;
        while (low<=high){
            int mid = (low + high) / 2;
            if(arr[mid] == target){
                index = mid;
                break;
            }
            if(arr[0] <= arr[mid]){
                if(arr[0] <= target && target < arr[mid]){
                    high = mid - 1;
                }else
                    low = mid + 1;
            }else {
                if (arr[mid] < target && target <= arr[arr.length -1]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return index;
    }
}
