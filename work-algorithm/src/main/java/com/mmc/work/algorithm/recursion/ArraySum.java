package com.mmc.work.algorithm.recursion;

/**
 * @packageName：com.mmc.work.algorithm.recursion
 * @desrciption:
 * @author: GW
 * @date： 2019-02-18 15:49
 * @history: (version) author date desc
 */
public class ArraySum {

    public static void main(String[] args) {
        int[] arrays = new int[]{2, 3, 5, 8, 10, 7};

        System.out.println(sum(arrays));
    }

    public static int sum(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        return arrays[0] + sum(splitArrays(arrays));
    }

    private static int[] splitArrays(int[] arrays) {
        if (arrays.length == 1) {
            return new int[]{};
        }
        int[] newArrays = new int[arrays.length - 1];
        for (int i = 1; i < arrays.length; i++) {
            newArrays[i - 1] = arrays[i];
        }
        return newArrays;
    }
}
