package com.mmc.work.algorithm.sort;

import com.mmc.work.algorithm.common.ArraysFactory;
import com.mmc.work.algorithm.common.PrintArraysUtils;

/**
 * @packageName：com.mmc.work.algorithm.sort
 * @desrciption: 插入排序
 * @author: GW
 * @date： 2019-02-15 16:26
 * @history: (version) author date desc
 */
public class InsertSort {

    /**
     * 插入排序
     * 核心思想
     *  保证前半部分有序，后续值往前半部分查找合适位置插入
     *  外层控制循环次数
     *  内层比较插入操作
     *
     */

    public static void main(String[] args) {
        int[] arrays = ArraysFactory.createIntArrays(10000);

        System.out.println("insert sort before data : ");
        PrintArraysUtils.printIntArray(arrays);

        System.out.println("insert sort after data : ");
        insertSort(arrays);
        PrintArraysUtils.printIntArray(arrays);
    }

    public static void insertSort(int[] arrays) {
        long start = System.currentTimeMillis();

        for (int i = 1; i < arrays.length - 1; i++) {
            for (int j = i; j > 0; j--) {
                int temp;
                if (arrays[j] < arrays[j - 1]) {
                    temp = arrays[j];
                    arrays[j] = arrays[j - 1];
                    arrays[j - 1] = temp;
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("【insert sort cost time " + (end - start) + "ms】");
    }
}
