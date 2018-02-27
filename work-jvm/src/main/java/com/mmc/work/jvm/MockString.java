package com.mmc.work.jvm;

/**
 * @packageName：com.mmc.work.jvm
 * @desrciption:
 * @author: gaowei
 * @date： 2018-02-27 17:05
 * @history: (version) author date desc
 */
public class MockString {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println("------------------");

        String s3 = "hello1";
        String s4 = "hello" + "1";

        System.out.println(s3 == s4);

        String s5 = new String("hello2");
        s5 = s5.intern();
        String s6 = "hello2";
        System.out.println(s5 == s6);


    }
}
