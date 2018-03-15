package com.mmc.work.thread;

import java.util.concurrent.TimeUnit;

/**
 * @packageName：com.mmc.work.thread
 * @desrciption: Object wait作用
 * @author: gaowei
 * @date： 2018-03-15 10:06
 * @history: (version) author date desc
 */
public class WaitThread {

    /**
     * wait() 是Object中api
     * 设置当前线程等待，让出CPU执行权限，释放线程持有锁
     */

    public static void main(String[] args) {

        Object lock = new Object();
        Runnable task = new WaitRunnable(lock);

        Thread t1 = new Thread(task);

        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        new WaitThread().notifyAll();

    }

    private static class WaitRunnable implements Runnable {

        private final Object lock;

        public WaitRunnable(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " >>> start");
                try {
                    long waitTime = 10000L;
                    System.out.println(Thread.currentThread().getName() + " >>> wait " + waitTime + " ms");
                    wait();
                } catch (Exception e) {
                    System.out.println(">>> " +  e.getMessage());
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " >>> end");
            }
        }
    }
}
