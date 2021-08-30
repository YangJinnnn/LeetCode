package com.yang.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main_HW {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        List<List<Integer>> wall = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = in.nextLine().split(" ");
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < split.length; j++) {
                tmp.add(Integer.parseInt(split[j]));
            }
            wall.add(tmp);
        }
        System.out.println(wall);
        System.out.println(solution(wall));
    }
    public static int solution(List<List<Integer>> wall){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (List<Integer> tmp : wall) {
            Integer integer = 0;
            for (int j = 0; j < tmp.size() - 1; j++) {
                integer += tmp.get(j);
                Integer count = hashMap.getOrDefault(integer, 0);
                hashMap.put(integer, count + 1);
            }
        }
        int max = 0;
        for(Integer i:hashMap.values()){
            max = Math.max(max, i);
        }
        if(hashMap.size()==0){
            return wall.size();
        }else {
            return wall.size()-max;
        }

    }
}
//6
//1 2 2 1
//3 1 2
//1 3 2
//2 4
//3 1 2
//1 3 1 1
