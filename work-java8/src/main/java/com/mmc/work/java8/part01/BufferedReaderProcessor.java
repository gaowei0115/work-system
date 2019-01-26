package com.mmc.work.java8.part01;

import java.io.BufferedReader;

/**
 * @packageName：com.mmc.work.java8.part01
 * @desrciption: 定义函数式接口
 * @author: GW
 * @date： 2019-01-26 17:19
 * @history: (version) author date desc
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader br) throws Exception;
}
