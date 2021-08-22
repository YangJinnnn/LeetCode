package com.yang.project;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String[] split = in.nextLine().split(",");
            int[] arr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            System.out.println(solution(arr));
        }
    }
    public static int solution(int[] arr){
        int res = 0;
        int peak = arr[0], valley = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > peak){
                peak = arr[i];
            }else {
                valley = arr[i];
            }
            res = Math.max(res, peak - valley);
        }
        return res;
    }
}
