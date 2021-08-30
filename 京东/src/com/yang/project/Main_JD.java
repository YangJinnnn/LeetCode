package com.yang.project;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] arr = new int[N][2];
        int cnt = 0;
        while (cnt<N){
            arr[cnt][0] = in.nextInt();
            arr[cnt][1] = in.nextInt();
            cnt++;
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.println(solution(arr));
    }
    public static int solution(int[][] arr){
        int cnt = 0;
        HashMap<Integer, Integer> Add = new HashMap<>();
        HashMap<Integer, Integer> Sub = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int add = arr[i][1] + arr[i][0];
            int sub = arr[i][1] - arr[i][0];
            int cnt_add = Add.getOrDefault(add, 0);
            Add.put(add, cnt_add+1);
            int cnt_sub = Sub.getOrDefault(sub, 0);
            Sub.put(sub, cnt_sub+1);
        }
        for(Integer i:Add.values()){
            if(i==1){
                continue;
            }
            cnt += (i-1)*i/2;
        }
        for(Integer i:Sub.values()){
            if(i==1){
                continue;
            }
            cnt += (i-1)*i/2;
        }
        return cnt;
    }
}
