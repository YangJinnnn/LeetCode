package com.yang;

import java.util.Random;
import java.util.Scanner;

/**
 * @author YangJin
 * @date 2021/3/24 20:45
 *  快速排序
 *      平均时间复杂度为0(NlogN),最坏时间复杂度0(n^2),不稳定
 */
public class quickSort {

    public static void sort(int[] array, int low, int high){
        if(low < high){
            int privot = partition(array, low, high);
            sort(array, 0, privot);
            sort(array, privot+1, high);
        }
    }

    public static int partition(int[] array, int low, int high){
        Random random = new Random();
        int index = random.nextInt(high-low+1);
        swap(array, index, low);
        int temp = array[low];
        while (low < high){
            while (low < high && array[high] >= temp)
                high--;
            array[low] = array[high];
            while (low < high && array[low] <= temp)
                low++;
            array[high] = array[low];
        }
        array[low] = temp;
        return low;
    }

    public static void swap(int[] array, int i,int j){
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
            array[count] = in.nextInt();
            count++;
        }
        sort(array, 0, n-1);
        for(int value: array)
            System.out.println(value);

    }

}
