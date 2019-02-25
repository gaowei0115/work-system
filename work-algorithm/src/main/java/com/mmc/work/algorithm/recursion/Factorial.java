package com.mmc.work.algorithm.recursion;

/**
 * @packageName：com.mmc.work.algorithm.recursion
 * @desrciption: 递归实现阶乘操作
 * @author: GW
 * @date： 2019-02-18 9:43
 * @history: (version) author date desc
 */
public class Factorial {


    public static void main(String[] args) {
        int num = 6;
        int result = factorialInt(num);
        System.out.println("求 " + num + "! = " + result);
    }

    public static int factorialInt(int num) {
        if (num == 0) {
            return 1;
        }

        if (num == 1) {
            return 1;
        }
        if (num > 1) {
            return num * factorialInt(num - 1);
        }

        return 0;
    }
}
