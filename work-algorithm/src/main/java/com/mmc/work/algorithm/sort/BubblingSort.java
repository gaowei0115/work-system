package com.mmc.work.algorithm.sort;

import com.mmc.work.algorithm.common.ArraysFactory;
import com.mmc.work.algorithm.common.PrintArraysUtils;

/**
 * @packageName：com.mmc.work.algorithm.sort
 * @desrciption:
 * @author: GW
 * @date： 2019-02-15 16:12
 * @history: (version) author date desc
 */
public class BubblingSort {


    /**
     *
     * 冒泡排序
     *
     * 核心思想
     *  每次比较交换出一个元素放到最后位置或者前面位置（冒出）
     *  外层循环控制循环次数
     *  内层循环控制比较交换冒出满足条件的值
     *
     *
     */

    public static void main(String[] args) {
        int[] arrays = ArraysFactory.createIntArrays(10000);

        System.out.println("bubbling sort before data : ");
        PrintArraysUtils.printIntArray(arrays);

        System.out.println("bubbling sort after data : ");
        bubblingSort(arrays);
        PrintArraysUtils.printIntArray(arrays);
    }

    /**
     * 冒泡排序
     * @param arrays
     */
    public static void bubblingSort(int[] arrays) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j = arrays.length - 1; j > 0 ; j--) {
                int temp = arrays[j];
                if (arrays[j - 1] < arrays[j]) {
                    arrays[j] = arrays[j - 1];
                    arrays[j - 1] = temp;
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("【bubbling sort cost time " + (end - start) + "ms】");
    }
}
