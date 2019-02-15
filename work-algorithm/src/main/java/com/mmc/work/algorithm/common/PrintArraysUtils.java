package com.mmc.work.algorithm.common;

import java.util.Arrays;

/**
 * @packageName：com.mmc.work.algorithm.common
 * @desrciption: 数组打印
 * @author: GW
 * @date： 2019-02-15 15:50
 * @history: (version) author date desc
 */
public class PrintArraysUtils {


    public static void printIntArray(int[] arrays) {
        System.out.print("arrays: {");
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i]);
            if (i < arrays.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("}");
        System.out.println();
    }
}
