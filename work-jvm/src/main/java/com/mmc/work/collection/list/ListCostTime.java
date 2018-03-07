package com.mmc.work.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @packageName：com.mmc.work.collection.list
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-05 11:12
 * @history: (version) author date desc
 */
public class ListCostTime {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        long start = System.currentTimeMillis();
        int n = 1000000;
        for (int i = 0; i < n; i++) {
            list.add("list" + i);
        }
        long end = System.currentTimeMillis();

        System.out.println("list cost time : " + (end - start) + " ms");

        start = System.currentTimeMillis();
        Vector<String> vector = new Vector<String>();
        for (int i = 0; i < n; i++) {
            vector.add("vector" + i);
        }
        end = System.currentTimeMillis();

        System.out.println("vector cost time : " + (end - start) + " ms");
    }
}
