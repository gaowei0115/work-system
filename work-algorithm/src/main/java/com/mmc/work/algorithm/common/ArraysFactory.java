package com.mmc.work.algorithm.common;

import java.util.Random;

/**
 * @packageName：com.mmc.work.algorithm.common
 * @desrciption:
 * @author: GW
 * @date： 2019-02-15 15:57
 * @history: (version) author date desc
 */
public class ArraysFactory {

    /**
     * 默认数组长度
     */
    private static final int DEFAULT_LENGTH = 100;


    /**
     * 产生默认长度的int数组
     * @return
     */
    public static int[] createIntArrays() {
        return createIntArrays(DEFAULT_LENGTH);
    }

    /**
     * 产生int数组
     * @param length
     * @return
     */
    public static int[] createIntArrays(int length) {
        int[] arrays = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arrays[i] = random.nextInt(100000);
        }
        return arrays;
    }

}
