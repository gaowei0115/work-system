package com.mmc.work.reflect.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @packageName：com.mmc.work.reflect.jdk
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-15 14:59
 * @history: (version) author date desc
 */
public class ProxySendMail implements InvocationHandler {

    private final Object target;

    public ProxySendMail(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long endTime = System.currentTimeMillis();
        System.out.println("send mail cost time : " + (endTime - startTime) + " ms");
        return result;
    }
}
