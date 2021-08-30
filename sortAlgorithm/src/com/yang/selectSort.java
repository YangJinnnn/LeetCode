package com.yang;

import java.util.Scanner;

/**
 * @author YangJin
 * @date 2021/3/24 20:45
 *   从待排数组中找出最小元素，存放在前面，直到全部待排序的元素排完。
 *   选择排序是不稳定的排序方法，时间复杂度为0(N^2)
 */
public class selectSort {

    public static void sort(int[] array){
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int min = array[i];
            int index = i;
            for(int j = i+1; j < n; j++){
                if(min > array[j]){
                    min = array[j];
                    index = j;
                }
            }
            swap(array, i, index);
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        int count = 0;
        while (count < n){
            array[count++] = in.nextInt();
        }
        sort(array);
        for(int value: array)
            System.out.println(value);

    }

}
