package com.mmc.work.java8.vo;

/**
 * @packageName：com.mmc.work.java8.vo
 * @desrciption:
 * @author: GW
 * @date： 2019-01-26 16:09
 * @history: (version) author date desc
 */
public class AppleVo extends BaseVo{


    private String id;

    private String color;

    private String size;

    private double weight;

    public AppleVo() {}

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "AppleVo{" +
                "id='" + id + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }
}
