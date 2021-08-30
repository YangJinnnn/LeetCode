package com.yang.project;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;

public class Main2_WY {
    public static void main(String[] args) {
        System.out.println(solution(3));

    }

    public static String solution(int num){
        if(num == 1){
            return "a";
        }
        char L = (char)(num + 'a' - 1);
        return solution(num-1) + L + invert(solution(num-1));
    }

    public static String invert(String s){
        char[] c = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            c[i] = (char)('z' - c[i] + 'a');
            builder.append(c[i]);
        }

        return builder.reverse().toString();
    }
}
