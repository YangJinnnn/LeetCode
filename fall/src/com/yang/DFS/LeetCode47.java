package com.yang.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 全排列Ⅱ
 */
public class LeetCode47 {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        int cnt = 0;
        while (cnt < N){
            arr[cnt++] = in.nextInt();
        }
        Arrays.sort(arr);
        solution(arr);
        System.out.println(res);
    }

    public static void solution(int[] arr){
        boolean[] visited = new boolean[arr.length];
        List<Integer> temp = new ArrayList<>();
        dfs(arr, visited, temp);
    }

    public static void dfs(int[] arr, boolean[] visited, List<Integer> temp){
        if(temp.size() == arr.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(i>0 && arr[i] == arr[i-1] && !visited[i-1] || visited[i]){
                continue;
            }
            visited[i] = true;
            temp.add(arr[i]);
            dfs(arr, visited, temp);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
}
