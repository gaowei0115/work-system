package com.mmc.work.java8.part01;

import com.mmc.work.java8.vo.Apple;
import com.mmc.work.java8.vo.AppleVo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @packageName：com.mmc.work.java8.part01
 * @desrciption: 方法引用
 * @author: GW
 * @date： 2019-02-13 14:31
 * @history: (version) author date desc
 */
public class MethodQuote {

    public static void main(String[] args) {
        Function<String, Integer> function = Integer::parseInt;
        int result = function.apply("12");
        System.out.println(result);

        System.out.println("----------------------------------------");
        List<Integer> weights = new ArrayList<>();
        weights.add(7);
        weights.add(5);
        weights.add(9);
        weights.add(10);
        weights.add(2);

        List<Apple> list = map(weights, Apple::new);


        for (Apple apple : list) {
            System.out.println(apple);
        }
    }

    /**
     * 生成列表对象
     * @param weights
     * @param f
     * @return
     */
    public static List<Apple> map(List<Integer> weights, Function<Integer, Apple> f) {
        List<Apple> resultList = new ArrayList<>();
        for (Integer wg : weights) {
            resultList.add(f.apply(wg));
        }
        return resultList;
    }
}
