package com.mmc.work.java8.part01;

import com.mmc.work.java8.vo.AppleVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.mmc.work.java8.part01
 * @desrciption: 初识Java8
 * @author: GW
 * @date： 2019-01-26 16:08
 * @history: (version) author date desc
 */
public class StartJavaEight {

    /**
     * 选择绿色对象实体 1
     * @param list
     * @return
     */
    public static List<AppleVo> filterGreenApple(List<AppleVo> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<AppleVo> resultList = new ArrayList<>();
        for (AppleVo av : list) {
            if (av.getColor().equals("green")) {
                resultList.add(av);
            }
        }
        return resultList;
    }

    /**
     * 改进版
     * @param list
     * @param color
     * @return
     */
    public static List<AppleVo> filterColorApple(List<AppleVo> list, String color) {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<AppleVo> resultList = new ArrayList<>();
        for (AppleVo av : list) {
            if (av.getColor().equals(color)) {
                resultList.add(av);
            }
        }
        return resultList;
    }

    /**
     * 使用lambda表达式
     * @param list
     * @return
     */
    public static List<AppleVo> filterAppleLambda(List<AppleVo> list) {
        if(list == null || list.size() == 0) {
            return null;
        }
        list.stream().forEach((AppleVo appleVo) -> "red".equals(appleVo.getColor()));
        return list;
    }
}
