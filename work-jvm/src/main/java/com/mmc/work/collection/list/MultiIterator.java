package com.mmc.work.collection.list;

import java.util.concurrent.*;

/**
 * @packageName：com.mmc.work.collection.list
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-05 13:43
 * @history: (version) author date desc
 */
public class MultiIterator {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(10, 100, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), Executors.defaultThreadFactory());

    }
}
