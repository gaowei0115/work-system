package com.mmc.work.jvm;

/**
 * @packageName：com.mmc.work.jvm
 * @desrciption:
 * @author: gaowei
 * @date： 2018-02-27 17:39
 * @history: (version) author date desc
 */
public class SleepThread {

    private static Object lock = new Object();

    public static void main(String[] args) {
        SleepThread t = new SleepThread();
        MyThread t1 = t.new MyThread();
        MyThread t2 = t.new MyThread();
        new Thread(t1).start();
        new Thread(t2).start();

    }

    class MyThread implements Runnable{

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " runnig");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
