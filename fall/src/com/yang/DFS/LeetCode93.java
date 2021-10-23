package com.yang.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode93 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        solution(s);
        System.out.println(res);
    }
    static List<String> res = new ArrayList<>();
    static int[] segments = new int[4];
    public static void solution(String s){
        dfs(s, 0, 0);
    }
    public static void dfs(String s, int start, int segId){
        if(segId == 4){
            if(start == s.length()){
                String ans = "";
                for (int i = 0; i < 4; i++) {
                    ans += segments[i];
                    if(i!=3){
                        ans += ".";
                    }
                }
                res.add(ans);
            }
            return;
        }
        if(start == s.length()){
            return;
        }
        if(s.charAt(start) == '0'){
            segments[segId] = 0;
            dfs(s, start+1, segId+1);
        }
        int t = 0;
        for (int i = start; i < s.length(); i++) {
            t = t*10 + s.charAt(i) - '0';
            if(t>0 && t<256){
                segments[segId] = t;
                dfs(s, i+1, segId+1);
            }else {
                break;
            }
        }
    }
}
