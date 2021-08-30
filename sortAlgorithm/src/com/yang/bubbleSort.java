package com.yang;

import java.util.Scanner;

/**
 * @author YangJin
 * @date 2021/3/24 20:44
 *
 * 持续比较相邻元素。如果前一个比后一个大，则交换，直到没有任何一对数字可以比较
 * 从前往后开始，每一轮找出一个最大值放在右边
 * 冒泡排序最好的时间复杂度为O(n)。冒泡排序的最坏时间复杂度为O(n^2)。因此冒泡排序总的平均时间复杂度为O(n^2)。
 * 冒泡排序是稳定算法
 */

public class bubbleSort{

    public static void sort(int[] array){

        int n = array.length;

        for (int i = n-1; i >= 0; i--) {
            boolean flag = false; //设置是否发生交换的标志
            for (int j = 0; j < i; j++) { //每一轮都找到一个最大的数放在右边
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flag = true;  //发生了交换
                }
            }
            if(!flag) break; //这一轮循环没有发生交换，说明排序已经完成，退出循环
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        int count = 0;
        while (count < n){
            array[count] = in.nextInt();
            count ++;
        }
        sort(array);
        for(int value: array){
            System.out.println(value);
        }

    }
}
