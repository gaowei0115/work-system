package com.mmc.work.thread;

import java.util.concurrent.TimeUnit;

/**
 * @packageName：com.mmc.work.thread
 * @desrciption: Thread sleep作用
 * @author: gaowei
 * @date： 2018-03-15 9:54
 * @history: (version) author date desc
 */
public class SleepThread {

    /**
     * sleep(long millis)属于Thread中api 是native方法
     * 设置当前线程休眠多长时间，不释放当前线程占用的CPU执行权限，不释放持有锁。
     */

    public static void main(String[] args) {

        final Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " >>> start");
                    try {
                        System.out.println("thread1 sleep 10000 ms");
                        Thread.sleep(10000);
                    } catch (Exception e) {

                    }
                    System.out.println(Thread.currentThread().getName() + " >>> end");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " >>> start");
                    try {
                        System.out.println("thread2 sleep 1000 ms");
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (Exception e) {

                    }
                    System.out.println(Thread.currentThread().getName() + " >>> end");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
