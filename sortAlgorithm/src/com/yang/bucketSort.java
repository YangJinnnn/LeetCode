package com.yang;

import javax.naming.PartialResultException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author YangJin
 * @date 2021/3/24 20:44
 */
public class bucketSort {
    public static void sort(int[] array){
        int n = array.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);
        }

        int bucketNum = (max - min) / n + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            int num = (array[i] - min) / n;
            bucketArr.get(num).add(array[i]);
        }

        for (int i = 0; i <bucketNum; i++) {
            Collections.sort(bucketArr.get(i));
        }

        int k = 0;
        for (int i = 0; i < bucketNum; i++) {
            for (int j = 0; j < bucketArr.get(i).size(); j++){
                array[k++] = bucketArr.get(i).get(j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        int count = 0;
        while (count < n)
            array[count++] = in.nextInt();
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
