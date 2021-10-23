package com.yang.project;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String str = "<<<>>>";
        System.out.println(solution(str));
    }
    public static boolean solution(String str){
        if(str.length()%2==1){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put('>', '<');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if(map.containsKey(tmp)){
                if(stack.isEmpty() || stack.peek()!=map.get(tmp)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(tmp);
            }
        }
        return stack.isEmpty();
    }
}
