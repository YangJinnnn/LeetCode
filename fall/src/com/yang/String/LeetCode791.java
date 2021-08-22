package com.yang.String;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 自定义字符串排序
 */
public class LeetCode791 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        String T = in.next();
        System.out.println(solution(S, T));
    }

    public static String solution(String S, String T){
        int[] cnt = new int[S.length()];
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            cnt[i] = strCount(T, S.substring(i, i+1));
            count += strCount(T, S.substring(i, i+1));
        }
        char[] t = T.toCharArray();
        int start = 0;
        int end = t.length-1;
        while (start < count && end >= count){
            while (!S.contains(T.substring(end-1, end))){
                end--;
            }
            while (S.contains(T.substring(start, start+1))){
                start++;
            }
            t[end--] = t[start++];
        }
        int loc = 0;
        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i] -- > 0){
                t[loc++] = S.charAt(i);
            }
        }
        return Arrays.toString(t);
    }

    public static int strCount(String str, String findByStr){
        String[] split = str.split("");
        return (int) Arrays.stream(split).filter(s -> s.equals(findByStr)).count();
    }
}
