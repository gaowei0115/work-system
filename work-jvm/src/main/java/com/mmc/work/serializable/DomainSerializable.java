package com.mmc.work.serializable;

import java.io.*;

/**
 * @packageName：com.mmc.work.serializable
 * @desrciption: 序列化测试
 * @author: gaowei
 * @date： 2018-03-15 15:29
 * @history: (version) author date desc
 */
public class DomainSerializable implements Serializable{

    private static final long serialVersionUID = -7701277336851139521L;

    /**
     * 序列化，实现serializable接口
     */
    private Long id;
    private String uuid;
    private transient String color;


    public DomainSerializable(Long id, String uuid, String color) {
        this.id = id;
        this.uuid = uuid;
        this.color = color;
    }

    private void writeObject(ObjectOutputStream oos) {
        try {
            oos.defaultWriteObject();
            ObjectOutputStream.PutField field = oos.putFields();
            System.out.println("原color ： " + color);
            color = "yellow";
            field.put("color", color);
            oos.writeFields();
        } catch (Exception e) {

        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        try {
            ois.defaultReadObject();
            color = "red";
            long re = ois.readLong();
            System.out.println(re);
        } catch (Exception e) {

        }
//            System.out.println(ois.readLong());
//            System.out.println(((StringBuffer)ois.readObject()).reverse().toString());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "DomainSerializable{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
