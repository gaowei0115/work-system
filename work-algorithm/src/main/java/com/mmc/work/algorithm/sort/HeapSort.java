package com.mmc.work.algorithm.sort;

import com.mmc.work.algorithm.common.PrintArraysUtils;
import com.mmc.work.algorithm.heap.HeapData;

import java.util.Arrays;

/**
 * @packageName：com.mmc.work.algorithm.sort
 * @desrciption: 堆排序
 * @author: GW
 * @date： 2019-02-21 17:39
 * @history: (version) author date desc
 */
public class HeapSort {


    /**
     * 使用堆数据存储结构特性，排序
     * @param arrays
     * @return
     */
    public static Comparable[] heapSort(Comparable[] arrays) {
        HeapData heapData = new HeapData(arrays.length);
        Arrays.stream(arrays).forEach(t -> {
            heapData.add(t);
        });

        Comparable[] result = new Comparable[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            result[i] = heapData.delete();
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{67, 34, 56, 90, 100, 32, 5, 19, 80};

        System.out.println("heap sort before : ");
        PrintArraysUtils.printComparableArrays(arrays);
        Comparable[] re = heapSort(arrays);

        System.out.println("heap sort after : ");
        PrintArraysUtils.printComparableArrays(re);
    }
}
