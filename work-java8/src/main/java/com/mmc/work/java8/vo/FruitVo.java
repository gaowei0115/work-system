package com.mmc.work.java8.vo;

/**
 * @packageName：com.mmc.work.java8.vo
 * @desrciption:
 * @author: GW
 * @date： 2019-01-28 14:01
 * @history: (version) author date desc
 */
public class FruitVo extends BaseVo {

    private String name;
    private String color;
    private Double weight;
    private Double size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FruitVo{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", size=" + size +
                '}';
    }
}
