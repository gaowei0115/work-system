package com.mmc.work.thread;

/**
 * @packageName：com.mmc.work.thread
 * @desrciption: 本地线程变量
 * @author: gaowei
 * @date： 2018-03-15 14:37
 * @history: (version) author date desc
 */
public class ThreadLocalTask {




    static class ThreadLocalThread implements Runnable {

        private final String localParam;

        private final ThreadLocal<String> localThread = new ThreadLocal<>();

        public ThreadLocalThread(String localParam) {
            this.localParam = localParam;
            localThread.set(localParam);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " >>> " + localThread.get());
        }
    }
}
