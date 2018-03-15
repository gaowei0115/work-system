package com.mmc.work.thread;

import java.util.LinkedList;
import java.util.Random;

/**
 * @packageName：com.mmc.work.thread
 * @desrciption: 生产消费模型 -- 使用多线程，wait，notifyAll机制
 * @author: gaowei
 * @date： 2018-03-15 10:55
 * @history: (version) author date desc
 */
public class ProductCustomerModel {


    public static void main(String[] args) {
        LinkedList<String> queues = new LinkedList<String>();
        int maxSize = 10;
        ProductThread productThread = new ProductThread(queues, maxSize);
        CustomerThread customerThread = new CustomerThread(queues, maxSize);
        CustomerThread customerThread1 = new CustomerThread(queues, maxSize);
        CustomerThread customerThread2 = new CustomerThread(queues, maxSize);

        new Thread(productThread).start();

        new Thread(customerThread).start();
        new Thread(customerThread1).start();
        new Thread(customerThread2).start();
    }

    private static class CustomerThread implements Runnable {

        private final LinkedList<String> queues;
        private final int maxSize;


        public CustomerThread(LinkedList<String> queues, int maxSize) {
            this.queues = queues;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queues) {
                    try {

//                        Thread.sleep(500);

                        if (queues.isEmpty()) {
                            // 队列处于空，生产者等待
                            System.out.println(Thread.currentThread().getName() + " >> 处于empty状态，消费者处于等待...");
                            queues.wait();
                        } else {
                            //
                            queues.notifyAll();
                            String emp = queues.poll();
                            System.out.println(Thread.currentThread().getName() + " >> customer data : " + emp);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    private static class ProductThread implements Runnable {

        private final  LinkedList<String> queues;
        private final int maxSize;

        public ProductThread(LinkedList<String> queues, int maxSize) {
            this.queues = queues;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queues) {
                    try {
//                        Thread.sleep(500);

                        if (maxSize == queues.size()) {
                            // 队列处于满状态，生产者等待
                            System.out.println(Thread.currentThread().getName() + " >> 处于full状态，生产者处于等待...");
                            queues.wait();
                        } else {
                            //
                            queues.notifyAll();
                            queues.push("pp" + (new Random(1000).nextInt()));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
