package com.yang.project;

public class Main {
    public static class A{
        private Integer x;
        public A(Integer x){
            this.x = x;
        }
        public void cala(int a){
            System.out.println(a++);
        }
    }

    public static void main(String[] args) {
        Integer a = 128;
        int b = 128;
        System.out.println(a==b);
    }
}
