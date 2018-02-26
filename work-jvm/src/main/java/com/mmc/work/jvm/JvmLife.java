package com.mmc.work.jvm;

/**
 * @packageName：com.mmc.work.jvm
 * @desrciption: JVM声明周期
 * @author: gaowei
 * @date： 2018-02-26 15:38
 * @history: (version) author date desc
 */
public class JvmLife {

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(i * 10000);
                        System.out.println("sleep : " + i * 10 + " s");
                    } catch (Exception e) {

                    }
                }
            }
        });
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}
