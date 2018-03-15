package com.mmc.work.serializable;

/**
 * @packageName：com.mmc.work.serializable
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-15 17:46
 * @history: (version) author date desc
 */
public class ObjectClone implements Cloneable {


    private String flag ;

    public ObjectClone() {}

    public ObjectClone(String flag) {
        this.flag = flag;
    }

    public static void main(String[] args) throws Exception {
        ObjectClone objectClone = new ObjectClone("first");
        System.out.println(objectClone);

        System.out.println(objectClone.clone());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (ObjectClone)super.clone();
    }

    @Override
    public String toString() {
        return "ObjectClone{" +
                "flag='" + flag + '\'' +
                '}';
    }
}
