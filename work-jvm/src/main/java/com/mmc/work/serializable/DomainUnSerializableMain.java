package com.mmc.work.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @packageName：com.mmc.work.serializable
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-15 15:47
 * @history: (version) author date desc
 */
public class DomainUnSerializableMain {

    public static void main(String[] args)  throws Exception{

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("domainUnSerializable.obj"));

        DomainUnSerializable dus = new DomainUnSerializable(100L, "serializable01", "serializable001");

        System.out.println("writer object before : " + dus.toString());

        oos.writeObject(dus);

        dus.setUserName("ser01");


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("domainUnSerializable.obj"));

        Object obj = ois.readObject();
        System.out.println("read object : " + obj.toString());

    }
}
