package com.yang.String;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 重新排列日志文件
 */
public class LeetCode937 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String[] logs = new String[N];
        int cnt = 0;
        while (cnt < N){
            logs[cnt++] = in.next();
        }
        System.out.println(Arrays.toString(solution(logs)));
    }

    public static String[] solution(String[] logs){
        Arrays.sort(logs, (logs1, logs2)->{
            String[] split1 = logs1.split(" ", 2);
            String[] split2 = logs2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if(!isDigit1 && !isDigit2){
                int cmp = split1[1].compareTo(split2[1]);
                if(cmp!=0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1?(isDigit2?0:1):-1;
        });
        return logs;
    }
}
