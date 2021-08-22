package com.yang.String;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 压缩字符串
 */
public class LeetCode443 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        char[] chars = new char[N];
        int cnt = 0;
        while (cnt<N){
            chars[cnt++] = in.next().charAt(0);
        }
        System.out.println(solution(chars));
    }

    public static int solution(char[] chars){
        Arrays.sort(chars);
        int read = 0;
        int write = 0;
        int anchor = 0;
        for (read = 0; read < chars.length; read++) {
            if (read == chars.length-1 || chars[read+1] != chars[read]){
                chars[write++] = chars[read];
                if (read > anchor){
                    char[] array = String.valueOf(read - anchor + 1).toCharArray();
                    for (int i = 0; i < array.length; i++) {
                        chars[write++] = array[i];
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
}
