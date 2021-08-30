package com.yang;

import java.util.Scanner;

/**
 * @author YangJin
 * @date 2021/3/24 20:44
 */
public class insertSort {

    public static void sort(int[] array){

        int n = array.length;
        for (int i = 1; i < n; i++) {

            int temp=array[i];//将当前位置的数给tmp
            int j;
            for(j = i; j > 0 && array[j-1] > temp;j--){
                /*
                往右移，腾出左边的位置,
                array[j-1]>tmp:大于号是升序排列，小于号是降序排列
                */
                array[j] = array[j-1];
            }

            //将当前位置的数插入到合适的位置
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        int[] array = new int[n];
        while (count < n)
            array[count++] = in.nextInt();
        sort(array);
        for(int value: array)
            System.out.println(value);
    }

}
