package com.yang.project;

import java.util.Arrays;
import java.util.HashMap;

public class Main3 {
    public static void main(String[] args) {
        String[] modNames = {"A", "B", "C", "D", "E", "F"};
        String[][] modDepends = {{"C", "F"}, {"C", "D"}, {"E"}, {"E"}, {}, {}};
        System.out.println(Arrays.toString(solution(modNames, modDepends)));
    }
    public static String[] solution(String[] modNames, String[][] modDepends){
        int n = modNames.length;
        String[] res = new String[n];
        int cnt = 0;
        int[][] map = new int[n][n];
        int[] V_cnt = new int[n];
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(modNames[i], i);
        }
        for (int i = 0; i < n; i++) {
            String[] tmp = modDepends[i];
            for (int j = 0; j < tmp.length; j++) {
                map[i][hashMap.get(tmp[j])]  = 1;
                V_cnt[i] += 1;
            }
        }
        System.out.println(Arrays.deepToString(map));
        System.out.println(Arrays.toString(V_cnt));
        do {
            int i;
            for (i = 0; i < n; i++) {
                if (V_cnt[i] == 0) {
                    res[cnt++] = modNames[i];
                    V_cnt[i] = -1;
                    break;
                }
            }
            for (int j = 0; j < n; j++) {
                if (map[j][i] == 1) {
                    V_cnt[j]--;
                }
            }
        } while (cnt != n);
        return res;
    }
}
