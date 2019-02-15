package com.mmc.work.java8.vo;

/**
 * @packageName：com.mmc.work.java8.vo
 * @desrciption:
 * @author: GW
 * @date： 2019-02-13 15:03
 * @history: (version) author date desc
 */
public class Apple {

    private Integer weight;

    public Apple(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
