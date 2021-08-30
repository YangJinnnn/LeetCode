package com.yang;

import java.util.Scanner;

/**
 * @author YangJin
 * @date 2021/3/24 20:44
 * 归并排序
 * 稳定，时间复杂度为0(NlogN)
 */
public class mergeSort {

    public static void sort(int[] array, int[] temp, int start, int end){
        if(start < end){
            int mid = start + (end - start) / 2;
            sort(array, temp, start, mid);
            sort(array, temp, mid+1, end);
            merge(array, temp, start, mid+1, end);
        }
    }

    public static void merge(int[] array, int[] temp, int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int tempIndex = leftPos;
        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if(array[leftPos] < array[rightPos])
                temp[tempPos++] = array[leftPos++];
            else
                temp[tempPos++] = array[rightPos++];
        }
        while (leftPos <= leftEnd)
            temp[tempPos++] = array[leftPos++];
        while (rightPos <= rightEnd)
            temp[tempPos++] = array[rightPos++];
        for (int i = tempIndex; i <= rightEnd; i++) {
            array[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        int[] temp = new int[n];

        int count = 0;
        while (count < n)
            array[count++] = in.nextInt();
        sort(array, temp, 0, n-1);
        for (int value: array)
            System.out.println(value);

    }

}
