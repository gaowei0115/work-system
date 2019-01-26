package com.mmc.work.java8.part01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @packageName：com.mmc.work.java8.part01
 * @desrciption:
 * @author: GW
 * @date： 2019-01-26 16:56
 * @history: (version) author date desc
 */
public class ThradRunLambda {

    public static void executor() {
        Runnable r1 = () -> System.out.println("run......");
        Thread t = new Thread(r1);
        t.start();
    }

    public static void processor(Runnable runnable) {
        Thread t = new Thread(runnable);
        t.start();
    }

    public static String processFile(BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        executor();

        processor(() -> System.out.println("runinng >> "));

    }
}
