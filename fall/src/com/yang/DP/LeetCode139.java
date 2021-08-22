package com.yang.DP;

import java.util.*;

/**
 * 单词拆分
 */
public class LeetCode139 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.next();
        List<String> wordDict = new ArrayList<>();
        while (n-->0){
            wordDict.add(in.next());
        }
        System.out.println(wordDict);
        System.out.println(solution(s, wordDict));
    }

    public static boolean solution(String s, List<String> wordDict){
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
