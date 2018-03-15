package com.mmc.work.reflect.jdk;

import java.lang.reflect.Proxy;

/**
 * @packageName：com.mmc.work.reflect.jdk
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-15 15:03
 * @history: (version) author date desc
 */
public class SendMailTest {

    public static void main(String[] args) {
        ProxySendMail proxySendMail = new ProxySendMail(new SinaSendMail());

        SendMail sendMail = (SendMail) Proxy.newProxyInstance(SendMailTest.class.getClassLoader(), new Class[]{SendMail.class}, proxySendMail);

        sendMail.sendMail("请与明天下午五点准备到场", "邀请函", "test@sina.com");
    }
}
