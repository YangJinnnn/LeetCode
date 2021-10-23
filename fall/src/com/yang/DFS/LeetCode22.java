package com.yang.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 括号生成
 */
public class LeetCode22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solution(n);
        System.out.println(res);
    }
    static List<String> res = new ArrayList<>();
    public static void solution(int n){
        dfs("", n, 0, 0);
    }
    public static void dfs(String tmp, int n, int open, int close){
        if(tmp.length() == 2*n){
            res.add(tmp);
            return;
        }
        if(open < n){
            tmp += '(';
            dfs(tmp, n, open+1, close);
            tmp = tmp.substring(0, tmp.length()-1);
        }
        if(close < open){
            tmp += ')';
            dfs(tmp, n, open, close+1);
            tmp = tmp.substring(0, tmp.length()-1);
        }
    }
}
