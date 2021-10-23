package com.yang.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(solution(nums[i]));
        }
    }
    public static String solution(int num){
        StringBuilder A = new StringBuilder();
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            A.append(helper(Integer.parseInt(s.substring(i, i + 1))));
        }
        int loc = A.length()-1;
        while (A.charAt(loc) != '1'){
            loc--;
        }
        String B = A.replace(loc+1, A.length(), "").reverse().toString();
        String C = "";
        C += B.charAt(0);
        for (int i = 1; i < B.length(); i++) {
            if(B.charAt(i) != B.charAt(i-1)){
                C += B.charAt(i);
            }
        }
        return C;
    }

    public static StringBuilder helper(int num){
        StringBuilder res = new StringBuilder();
        if(num == 0){
            res.append(0);
            return res;
        }
        while (num > 0){
            res.append(num % 2);
            num/=2;
        }
        res.reverse();
        return res;
    }
}
