package com.yang.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串的排列
 */
public class LeetCode567 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        System.out.println(solution(s1, s2));
    }

    /** 滑动窗口 */
    public static boolean solution(String s1, String s2){
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if(Arrays.equals(cnt1, cnt2)){
            return true;
        }
        for (int i = s2.length(); i < s1.length(); i++) {
            ++cnt1[s1.charAt(i) - 'a'];
            --cnt1[s1.charAt((i - s2.length())) - 'a'];
            if (Arrays.equals(cnt1, cnt2)){
                return true;
            }
        }
        return false;
    }

    /** DFS */
//    static List<String> ans = new ArrayList<>();
//    public static boolean solution(String s1, String s2){
//        String sub = "";
//        boolean[] visit = new boolean[s2.length()];
//        dfs(s2, sub, visit);
//        for (int i = 0; i < ans.size(); i++) {
//            if(s1.contains(ans.get(i))){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static void dfs(String s, String sub, boolean[] visit){
//        if (sub.length() == s.length()){
//            ans.add(sub);
//            return;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if(!visit[i]){
//                visit[i] = true;
//                sub += s.charAt(i);
//                dfs(s, sub, visit);
//                sub = sub.substring(0, sub.length()-1);
//                visit[i] = false;
//            }
//        }
//    }
}
