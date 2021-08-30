package com.yang;

import java.util.Scanner;

/**
 * @author YangJin
 * @date 2021/3/24 20:45
 */
public class shellSort {

    public static void sort(int[] array){
        int n = array.length;
        for(int gap = n/2; gap>=1; gap /= 2)
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for(j=i; j >= gap && array[j-gap] > temp; j -= gap){
                    array[j] = array[j-gap];
                }
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


//CREATE TABLE 'account'(
//        'id' INT(3) NOT NULL AUTO INCREAMENT,
//        'name' VARCHAR (30) NOT NULL,
//        'money' DECIMAL(9, 2) NOT NULL,
//        PRIMARY KEY('id')
//        )ENGINE=INNODB DEFAULT CHARSET=UTF8
