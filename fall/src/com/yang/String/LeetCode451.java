package com.yang.String;

import java.util.*;

/**
 * 根据字符出现频率排序
 */
public class LeetCode451 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s =in.next();
        System.out.println(solution(s));
    }

    public static String solution(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cnt = map.getOrDefault(c, 0);
            map.put(c, cnt+1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            int cnt = map.get(c);
            while (cnt-- > 0){
                res.append(c);
            }
        }
        return res.toString();
    }
}
