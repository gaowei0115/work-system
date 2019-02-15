package com.mmc.work.algorithm.sort;

import com.mmc.work.algorithm.common.ArraysFactory;
import com.mmc.work.algorithm.common.PrintArraysUtils;

/**
 * @packageName：com.mmc.work.algorithm.select
 * @desrciption:
 * @author: GW
 * @date： 2019-02-15 15:42
 * @history: (version) author date desc
 */
public class SelectSort {

    /**
     * 选择排序
     *  双层循环
     *  根据外层循环值与内层循环值比对查找合适下标位置
     * 核心思想：
     *  选取一个值，在内层循环中查找满足比较条件的下标存放位置，在外层循环内交换位置
     *
     *
     *
     *
     */

    public static void main(String[] args) {
        int[] arrays = ArraysFactory.createIntArrays(10000);

        System.out.println("select sort before data : ");
        PrintArraysUtils.printIntArray(arrays);

        System.out.println("select sort after data : ");
        selectSort(arrays);
        PrintArraysUtils.printIntArray(arrays);
    }



    /**
     * 选择排序核心实现
     * @param arrays
     */
    public static void selectSort(int[] arrays) {
        long start = System.currentTimeMillis();

        int i = 0;
        int j = 0;
        int selIndex = 0;
        for (; i < arrays.length - 1; i++) {
            int temp = arrays[i];
            selIndex = i;
            for (j = i + 1; j < arrays.length; j++) {
                if (arrays[selIndex] > arrays[j]) {
                    selIndex = j;
                }
            }

            /**
             * 选择出来交换下标
             */

            arrays[i] = arrays[selIndex];
            arrays[selIndex] = temp;
        }

        long end = System.currentTimeMillis();
        System.out.println("【select sort cost time " + (end - start) + "ms】");
    }
}
