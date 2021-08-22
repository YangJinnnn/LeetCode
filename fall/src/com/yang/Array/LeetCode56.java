package com.yang.Array;

import java.util.*;

/**
 * 合并区间
 */
public class LeetCode56 {
    static final List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] intervals = new int[N][2];
        for (int i = 0; i < N; i++) {
            intervals[i][0] = in.nextInt();
            intervals[i][1] = in.nextInt();
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        solution(intervals);
        System.out.println(Arrays.toString(res.toArray()));
    }
    public static void solution(int[][] intervals){
        res.add(new ArrayList<Integer>(){{add(intervals[0][0]);add(intervals[0][1]);}});
        for (int i = 1; i < intervals.length; i++) {
            List<Integer> last = res.get(res.size()-1);
            if(intervals[i][0] < last.get(1)){
                last.remove(1);
                last.add(intervals[i][1]);
            }
            else {
                int finalI = i;
                res.add(new ArrayList<Integer>(){{add(intervals[finalI][0]);add(intervals[finalI][1]);}});
            }
        }
    }
}
