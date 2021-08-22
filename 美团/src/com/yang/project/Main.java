package com.yang.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr  = new int[n];
        int cnt = 0;
        while (cnt < n){
            arr[cnt++] = in.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        solution(arr);
    }
    static List<List<Integer>> list = new ArrayList<>();
    public static void solution(int[] arr){
        boolean[] visited = new boolean[arr.length];
        List<Integer> temp = new ArrayList<>();
        dfs(arr, visited, temp);
        for (List<Integer> res:list){
            for(Integer r:res){
                System.out.print(r);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void dfs(int[] arr, boolean[] visited, List<Integer> temp){
        if(temp.size() == arr.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(i>0&&arr[i] == arr[i-1] && !visited[i-1] || visited[i]){
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
