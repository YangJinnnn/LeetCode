package com.yang.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode78 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        solution(nums);
        System.out.println(res);
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static void solution(int[] nums){
        List<Integer> t = new ArrayList<>();
        dfs(nums, 0, t);
    }
    public static void dfs(int[] nums, int cur, List<Integer> t){
        if(cur == nums.length){
            res.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(nums, cur+1, t);
        t.remove(t.size()-1);
        dfs(nums, cur+1, t);
    }
}
