package com.yang.String;

import java.util.*;

/**
 * 字母异位词分组
 */
public class LeetCode49 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String[] strs = new String[N];
        int cnt = 0;
        while (cnt<N){
            strs[cnt++] = in.next();
        }
        System.out.println(solution(strs));
    }

    public static List<List<String>> solution(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            List<String> list = map.getOrDefault(Arrays.toString(c), new ArrayList<>());
            list.add(str);
            map.put(Arrays.toString(c), list);
        }
        return new ArrayList<>(map.values());
    }
}
