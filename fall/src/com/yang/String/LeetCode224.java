package com.yang.String;

import java.util.Scanner;
import java.util.Stack;

public class LeetCode224 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(solution(s));
    }
    public static long solution(String s){
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        stack.push(sign);
        int cnt = 0;
        long res = 0;
        while (cnt < s.length()){
            if(s.charAt(cnt) == '('){
                stack.push(sign);
                cnt++;
            }else if(s.charAt(cnt) == ')'){
                stack.pop();
                cnt++;
            }else if(s.charAt(cnt) == '+'){
                sign = stack.peek();
                cnt++;
            }else if(s.charAt(cnt) == '-'){
                sign = -stack.peek();
                cnt++;
            }else {
                long tmp = 0;
                while (cnt<s.length() && Character.isDigit(s.charAt(cnt))){
                    tmp = tmp*10 + s.charAt(cnt) - '0';
                    cnt++;
                }
                res += sign * tmp;
            }
        }
        return res;
    }
}
