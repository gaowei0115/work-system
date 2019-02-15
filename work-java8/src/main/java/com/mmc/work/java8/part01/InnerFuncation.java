package com.mmc.work.java8.part01;

import com.mmc.work.java8.utils.FruitData;
import com.mmc.work.java8.vo.FruitVo;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.IntBinaryOperator;

/**
 * @packageName：com.mmc.work.java8.part01
 * @desrciption: 内置lambda表达式函数
 * @author: GW
 * @date： 2019-01-28 13:56
 * @history: (version) author date desc
 */
public class InnerFuncation {

    public static void main(String[] args) {
        IntBinaryOperator result = (int a, int b) -> (a + b);
        int rr = result.applyAsInt(10 , 20);
        System.out.println(rr);

        /**
         * Callable函数式接口
         */
        Callable<Integer> callable = () -> 42;
        try {
            System.out.println(callable.call());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Runnable runnable = () -> {
            String idName = Thread.currentThread().getId() +  " -- " + Thread.currentThread().getName();
            System.out.println(idName + " start");
            System.out.println(idName + " running");
            System.out.println(idName + " end");
        };
        Runnable runnable1 = () -> {
            String idName1 = Thread.currentThread().getId() +  " -- " + Thread.currentThread().getName();
            System.out.println(idName1 + " start");
            System.out.println(idName1 + " running");
            System.out.println(idName1 + " end");
        };

        new Thread(runnable).start();
        new Thread(runnable1).start();

        List<FruitVo> list = FruitData.createFruitData();
        FruitVo f1 = list.get(0);
        FruitVo f2 = list.get(1);

        Comparator<FruitVo> comparable = (FruitVo v1, FruitVo v2) -> v1.getWeight().compareTo(v2.getWeight());
        int fr = comparable.compare(f2, f1);
        if (fr == 0) {
            System.out.println("==");
        } else if (fr > 0) {
            System.out.println(" > ");
        } else {
            System.out.println(" < ");
        }

        final int portNumber = 8081;
        Runnable r = () -> {
            System.out.println("port : " + portNumber);
        };

        new Thread(r).start();

    }
}
