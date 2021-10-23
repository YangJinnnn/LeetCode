package com.yang.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word1 = in.nextLine();
        String word2 = in.nextLine();
        System.out.println(solution(word1, word2));
    }
    public static String solution(String word1, String word2){
        int p1 = 0, p2 = 0;
        while (p1<word1.length()){
            if(word1.charAt(p1) == word2.charAt(p2)){
                p1++;
                p2++;
                if(p2 == word2.length()){
                    return "yes";
                }
            }else {
                p1++;
            }
        }
        return "no";
    }
}
