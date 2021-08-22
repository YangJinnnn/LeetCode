package com.yang.String;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 翻转字符串里的单词
 */
public class LeetCode151 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        String s = in.next();
        System.out.println(solution(s));
    }

    public static String solution(String s){
        char[] c = s.toCharArray();
        int cnt = 0;
        reverse(c, 0, c.length - 1);
        for (int i = 0; i < c.length; i++) {
            if(c[i] == ' '){
                reverse(c, cnt, i-1);
                cnt = i+1;
            }
            if (i == c.length -1){
                reverse(c, cnt, i);
            }
        }
        StringBuilder res = new StringBuilder();
        int i = 0,j = c.length-1;
        while (i<=j&&c[i] == ' '){
            i++;
        }
        while (i<=j&&c[j] == ' '){
            j--;
        }
        while (i <= j) {

            if (c[i] != ' ') {
                res.append(c[i]);
            } else if (res.charAt(res.length() - 1) != ' ') {
                res.append(c[i]);
            }

            ++i;
        }
//        res.append(c[i]);
        return res.toString();
    }

    public static char[] reverse(char[] c, int i, int j){
        while (i<j){
            char tmp = c[i];
            c[i++] = c[j];
            c[j--] = tmp;
        }
        return c;
    }
}
