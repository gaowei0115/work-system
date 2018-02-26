package com.mmc.work.jvm;

import java.net.URL;

/**
 * @packageName：com.mmc.work.jvm
 * @desrciption: 模拟类加载器
 * @author: gaowei
 * @date： 2018-02-26 15:02
 * @history: (version) author date desc
 */
public class MockClassLoader {

    public static void main(String[] args) {
        ClassLoader cl = MockClassLoader.class.getClassLoader();
        try {
            URL url = cl.getResource("");
            System.out.println(url.getPath());
            Class<?> clazz = cl.loadClass("com.mmc.work.jvm.Student");
            System.out.println(clazz.getName());
            System.out.println(clazz.newInstance());
            Student s1 = (Student) clazz.newInstance();
            System.out.println("s1" + s1);
            Student s2 = (Student) clazz.newInstance();
            System.out.println("s2" + s2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
