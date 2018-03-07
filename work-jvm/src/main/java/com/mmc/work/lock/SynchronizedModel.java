package com.mmc.work.lock;

import java.util.concurrent.*;

/**
 * @packageName：com.mmc.work.lock
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-05 11:23
 * @history: (version) author date desc
 */
public class SynchronizedModel {


    public static void main(String[] args) {
        SynchronizedModel synchronizedModel = new SynchronizedModel();
        ExecutorService executorService = new ThreadPoolExecutor(10, 100, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), Executors.defaultThreadFactory());
        final WholeObjectLock wholeObjectLock = new WholeObjectLock();
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    wholeObjectLock.print(wholeObjectLock);
                }
            });
        }

        executorService.shutdown();

//        ExecutorService executorService1 = new ThreadPoolExecutor(10, 100, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), Executors.defaultThreadFactory());
//        for (int i = 0; i < 100; i++) {
//            executorService1.submit(new Runnable() {
//                @Override
//                public void run() {
//                    GeneralObjectLock generalObjectLock = new GeneralObjectLock();
//                    generalObjectLock.print(generalObjectLock);
//                }
//            });
//        }
//
//        executorService1.shutdown();
    }
}

/**
 * 全局锁
 */
class WholeObjectLock {
    int i = 0;
    public void print(Object lock) {
        synchronized (lock) {
            i = i + 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " > " + i + " whole lock");
        }
    }
}

class GeneralObjectLock {
    int i = 0;
    public void print(final Object lock) {
        System.out.println(this);
        synchronized (lock) {
            System.out.println(Thread.currentThread() + " > " + i++ + "  general lock");
        }
    }
}
