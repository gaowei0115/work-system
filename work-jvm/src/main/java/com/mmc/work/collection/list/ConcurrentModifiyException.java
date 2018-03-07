package com.mmc.work.collection.list;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.*;

/**
 * @packageName：com.mmc.work.collection.list
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-05 13:23
 * @history: (version) author date desc
 */
public class ConcurrentModifiyException {

    public static void main(String[] args) {
        ArrayList<String> arrays = new ArrayList<String>();
        arrays.add("concurrent01");
        arrays.add("concurrent02");
        arrays.add("concurrent03");
        arrays.add("concurrent04");
        arrays.add("concurrent05");
        arrays.add("concurrent06");
        arrays.add("concurrent07");
        arrays.add("concurrent08");
        arrays.add("concurrent09");
        arrays.add("concurrent10");

        final Iterator<String> iterator = arrays.iterator();
        int i = 0;
//        while (iterator.hasNext()) {
//            String temp = iterator.next();
//            i++;
//            if (i == 4) {
//                iterator.remove();
//            }
//        }


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
