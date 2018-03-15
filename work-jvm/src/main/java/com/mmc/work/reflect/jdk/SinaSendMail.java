package com.mmc.work.reflect.jdk;

import java.util.concurrent.TimeUnit;

/**
 * @packageName：com.mmc.work.reflect.jdk
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-15 14:57
 * @history: (version) author date desc
 */
public class SinaSendMail implements SendMail {

    @Override
    public void sendMail(String content, String title, String address) {

        System.out.println("[");
        System.out.println("address : " + address);
        System.out.println("title : " + title);
        System.out.println("content : " + content);
        System.out.println("]");
        try {
            System.out.println("邮件发送中.....");
            TimeUnit.MILLISECONDS.sleep(10000);
        } catch (Exception e) {

        }
    }
}
