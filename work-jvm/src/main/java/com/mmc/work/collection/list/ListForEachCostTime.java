package com.mmc.work.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @packageName：com.mmc.work.collection.list
 * @desrciption: list集合几种遍历方式耗时
 * @author: gaowei
 * @date： 2018-03-14 17:20
 * @history: (version) author date desc
 */
public class ListForEachCostTime {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.add("list" + i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("add element cost time : " + (endTime - startTime) + " ms");


        System.out.println("---------for each");
        startTime = System.currentTimeMillis();
        String data = null;
        for (String l : list) {
//            System.out.print(l + ", ");
            data = l;
        }
        endTime = System.currentTimeMillis();
        System.out.println("list for each cost time : " + (endTime - startTime) + " ms");

        System.out.println("---------iterator ");
        startTime = System.currentTimeMillis();
        Iterator<String> it = list.iterator();
        for (; it.hasNext();) {
            data = it.next();
//            System.out.print(it.next() + ",");
        }
        endTime = System.currentTimeMillis();
        System.out.println("iterator cost time : " + (endTime - startTime) + " ms");

        System.out.println("--------- for index 0 -> length");
        startTime = System.currentTimeMillis();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            data = list.get(i);
//            System.out.print(list.get(i) + ",");
        }
        endTime = System.currentTimeMillis();
        System.out.println("for index 0 -> length cost time : " + (endTime - startTime) + " ms");

    }
}
