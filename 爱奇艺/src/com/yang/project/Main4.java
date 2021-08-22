package com.yang.project;


import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class Main4 {
    public static void main(String[] args) {
        final Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        new Thread(() -> {
            try {
                zeroEvenOdd.printZero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.printEven(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.printOdd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ZeroEvenOdd {
    private int n;

    private volatile int flag = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void printZero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                if(flag != 0){
                    condition1.await();
                }
                printNumber.accept(0);
                if(i%2==0){
                    flag = 1;
                    condition2.signal();
                }else {
                    flag = 2;
                    condition3.signal();
                }
            }
        }finally {
            lock.unlock();
        }
    }

    public void printEven(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 2; i <= n; i += 2) {
                if(flag != 2){
                    condition3.await();
                }
                printNumber.accept(i);
                flag = 0;
                condition1.signal();
            }
        }finally {
            lock.unlock();
        }
    }

    public void printOdd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 1; i <= n; i += 2) {
                if(flag != 1){
                    condition2.await();
                }
                printNumber.accept(i);
                flag = 0;
                condition1.signal();
            }
        }finally {
            lock.unlock();
        }
    }
}
