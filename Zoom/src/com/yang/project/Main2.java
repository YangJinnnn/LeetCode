package com.yang.project;

public class Main2 {
    public static void main(String[] args) {
        int num = 58;
        System.out.println(solution(num));
    }
    public static String solution(int num){
        String[] luoma = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] shuzi = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String res = "";
        int index = 0;
        while (index < 13){
            while (num >= shuzi[index]){
                res += luoma[index];
                num -= shuzi[index];
            }
            index++;
        }
        return res;
    }
}
