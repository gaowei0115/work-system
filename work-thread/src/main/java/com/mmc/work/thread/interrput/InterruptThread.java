package com.mmc.work.thread.interrput;

import java.util.concurrent.TimeUnit;

/**
 * @packageName：com.mmc.work.thread.interrput
 * @desrciption:
 * @author: GW
 * @date： 2019-02-20 13:44
 * @history: (version) author date desc
 */
public class InterruptThread {

    public static void main(String[] args) {
        Runnable work = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " >> running");
        };
        System.out.println(Thread.currentThread().getName() + " >> runing");
        Thread t = new Thread(work);
        t.start();
        System.out.println("testing thread is interrupted " + t.isInterrupted());
        System.out.println("interrupt before " + t.isAlive());
        t.interrupt();
        System.out.println("interrupt after " + t.isAlive());
    }
}
