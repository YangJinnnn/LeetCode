package com.yang.others;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PJN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> list = new ArrayList<>();
        while (N-->0){
            list.add(in.nextInt());
        }
        System.out.println(list);
        System.out.println(solution(list));
    }

    public static int solution(List<Integer> list){
        int number = 0;
        while (true){
            boolean flag = false;
            for (int i = list.size()-1; i > 0; i--) {
                if(list.get(i)>list.get(i-1)){
                    list.remove(i);
                    flag = true;
                }
            }
            if(!flag){
                return number;
            }
            number++;
        }
    }
}
