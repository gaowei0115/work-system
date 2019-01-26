package com.mmc.work.java8.utils;

import com.mmc.work.java8.vo.BaseVo;

import java.util.List;

/**
 * @packageName：com.mmc.work.java8.utils
 * @desrciption:
 * @author: GW
 * @date： 2019-01-26 17:40
 * @history: (version) author date desc
 */
public class PrintList {


    public static <T> void prinList(List<T> list) {
        System.out.println("print list : [");
        for (T bv : list) {
            System.out.println(bv);
        }
        System.out.println("]");
    }
}
