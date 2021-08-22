package com.yang.project;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] spilt = str.split(" ");
        int[] age = new int[spilt.length];
        for (int i = 0; i < spilt.length; i++) {
            age[i] = Integer.parseInt(spilt[i]);
        }
        System.out.println(solution(age));
    }

    public static int solution(int[] age){
        int[] paper = new int[age.length];
        int cnt = 0;
        int min = age[0];
        int flag = 0;
        for (int i = 0; i < age.length; i++) {
            if(age[i] < min){
                min = age[i];
                flag = i;
            }
        }
        paper[flag] = 1;
        for (int i = 1; i < paper.length; i++) {
            if(age[(flag+i)%paper.length] > age[(flag+i-1)%paper.length]){
                paper[(flag+i)%paper.length] = paper[(flag+i-1)%paper.length] + 1;
            }else {

                if(i+1<paper.length&&age[(flag+i)%paper.length]>age[(flag+i+1)%paper.length]){
                    paper[(flag+i)%paper.length] = paper[(flag+i-1)%paper.length] + 1;
                }
                else {
                    paper[(flag+i)%paper.length] = 1;
                }
            }
        }
        for (int i = 0; i < paper.length; i++) {
            cnt += paper[i];
        }
        return cnt;
    }
}
