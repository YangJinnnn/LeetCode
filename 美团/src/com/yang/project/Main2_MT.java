package com.yang.project;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main2_MT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder s = new StringBuilder(in.next());
        int n = in.nextInt();
        int cnt = 0;
        int[] opts = new int[n];
        String[] str = new String[n];
        while (cnt <n){
            int opt = in.nextInt();
            String sub = in.next();
            opts[cnt] = opt;
            str[cnt] = sub;
            cnt ++;
        }
        for (int i = 0; i < opts.length; i++) {
            if (opts[i] == 1){
                s.append(str[i]);
            }else {
                System.out.println(solution(Integer.parseInt(str[i])-1, s.toString()));
            }
        }

    }
    public static int solution(int pos, String s){
        int i;
        for (i = pos+1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(pos)){
                break;
            }
        }
        int j;
        for (j = pos-1; j >= 0; j--) {
            if(s.charAt(j) == s.charAt(pos)){
                break;
            }
        }
        if(i>=s.length() && j<0){
            return -1;
        }
        else if(i>=s.length()){
            return pos - j;
        }
        else if(j<0){
            return i-pos;
        }
        else{
            int right = i - pos;
            int left = pos - j;
            return Math.min(right, left);
        }

    }
}
