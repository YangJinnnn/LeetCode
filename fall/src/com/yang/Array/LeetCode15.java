package com.yang.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 三数之和
 */
public class LeetCode15 {
    private static final List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        int count = 0;
        while (count < N){
            arr[count++] = in.nextInt();
        }
        Arrays.sort(arr);
        solution(arr);
        System.out.println(res);
    }
    public static void solution(int[] arr){
//        int first = 0;
//        int third = arr.length - 1;
        for (int first = 0; first < arr.length; first++) {
            if (first > 0 && arr[first] == arr[first-1])
                continue;
            int third = arr.length-1;
            int target = -arr[first];
            for (int second = first+1; second < arr.length; second++) {
                if(second > first+1 && arr[second] == arr[second -1 ])
                    continue;
                while (second < third && arr[second] + arr[third] >target)
                    third--;
                if(second == third)
                    break;
                if(arr[second] + arr[third] == target){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(arr[first]);
                    temp.add(arr[second]);
                    temp.add(arr[third]);
                    res.add(new ArrayList<>(temp));
                }
            }
        }
    }
}
