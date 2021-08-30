package com.yang;

import java.util.Scanner;

/**
 * @author YangJin
 * @date 2021/3/24 20:44
 * 堆排序
 * 升序排序，建立大根堆，降序排序，建立小根堆
 * 堆排序是不稳定的，时间复杂度为0(NlogN)
 */
public class heapSort {

    public static void sort(int[] array){
        // 找到第一个非叶子节点开始，从下往上调整堆，获得最大顶堆
        int n = array.length;
        for (int i = n/2 - 1; i >= 0; i--) {
            adjustHeap(array, i, n);
        }
        for (int i = n-1; i >= 0; i--) {
            // 交换顶点值和最后一个节点的值，获得当前的最小值
            swap(array, 0, i);
            // 剩下的元素再进行调整为最大顶堆
            adjustHeap(array, 0, i);
        }
    }

    public static void swap(int[] array, int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void adjustHeap(int[] array, int i, int length){
        int temp = array[i];
        for (int j = 2*i+1; j < length; j=2*j+1) {
            if(j+1 < length && array[j+1]>array[j])
                j++;
            if(array[j] > temp) {
                array[i] = array[j];
                i = j;
            }else
                break;
        }
        array[i] = temp;// 将temp放在这一次构造的顶堆的最终位置
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        int[] array = new int[n];
        while (count < n){
            array[count] = in.nextInt();
            count++;
        }
        sort(array);
        for(int value: array)
            System.out.println(value);
    }
}
