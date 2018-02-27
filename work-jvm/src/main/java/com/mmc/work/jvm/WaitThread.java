package com.mmc.work.jvm;

/**
 * @packageName：com.mmc.work.jvm
 * @desrciption:
 * @author: gaowei
 * @date： 2018-02-27 17:46
 * @history: (version) author date desc
 */
public class WaitThread {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        WaitThread t = new WaitThread();

        MyWaitThread t1 = t.new MyWaitThread();
        MyWaitThread t2 = t.new MyWaitThread();

        new Thread(t1).start();
        new Thread(t2).start();
    }

    class MyWaitThread implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " >> start");
                    lock.wait(10000);
                } catch (Exception e) {

                }
                System.out.println(Thread.currentThread().getName() + " >> end");
            }
        }
    }
}
