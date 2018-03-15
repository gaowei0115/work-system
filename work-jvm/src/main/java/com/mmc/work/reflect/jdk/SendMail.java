package com.mmc.work.reflect.jdk;

/**
 * @packageName：com.mmc.work.reflect.jdk
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-15 14:56
 * @history: (version) author date desc
 */
public interface SendMail {

    /**
     * 发送邮件
     * @param content
     * @param title
     * @param address
     */
    public void sendMail(String content, String title, String address);
}
