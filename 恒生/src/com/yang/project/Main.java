package com.yang.project;

public class Main {
    public static void main(String[] args) {
        int a = 12;
        int b = 7;
        while (b!=0){
            int carry = (a&b)<<1;
            a ^= b;
            b = carry;
        }
        System.out.println(a);
    }
}
