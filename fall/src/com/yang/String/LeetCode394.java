package com.yang.String;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串解码
 */
public class LeetCode394 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(solution(s));
    }

    static int ptr = 0;
    public static String solution(String s){
        LinkedList<String> stk = new LinkedList<>();
        while (ptr < s.length()){
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)){
                stk.addLast(getDigits(s));
            }else if (Character.isLetter(cur) || cur == '['){
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            }else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())){
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                stk.removeLast();
                int num = Integer.parseInt(stk.removeLast());
                while (num-- > 0){
                    stk.add(getString(sub));
                }
            }
        }
        return getString(stk);
    }

    public static String getDigits(String s){
        StringBuilder digit = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))){
            digit.append(s.charAt(ptr++));
        }
        return digit.toString();
    }

    public static String getString(LinkedList<String> list){
        StringBuilder res = new StringBuilder();
        for (String s : list){
            res.append(s);
        }
        return res.toString();
    }
}
