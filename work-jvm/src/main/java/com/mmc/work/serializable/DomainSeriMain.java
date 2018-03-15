package com.mmc.work.serializable;

import java.io.*;

/**
 * @packageName：com.mmc.work.serializable
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-15 15:35
 * @history: (version) author date desc
 */
public class DomainSeriMain {

    public static void main(String[] args) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("domainSerializable.obj"));
        DomainSerializable domainSerializable = new DomainSerializable(10L, "111110", "red");
        // 写入到本地文件
        oos.writeObject(domainSerializable);
        System.out.println("write before " + domainSerializable.toString());
        // 修改文件属性
        domainSerializable.setColor("yellow");

        System.out.println("read before modify " + domainSerializable.toString());

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("domainSerializable.obj"));
        DomainSerializable d = (DomainSerializable) ois.readObject();
        System.out.println("read " + d.toString());

    }
}
