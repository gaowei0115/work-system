package com.mmc.work.java8.part01;

import com.mmc.work.java8.data.AppleData;
import com.mmc.work.java8.vo.AppleVo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @packageName：com.mmc.work.java8.part01
 * @desrciption:
 * @author: GW
 * @date： 2019-01-26 16:11
 * @history: (version) author date desc
 */
public class StartJavaEightTest {

    @org.junit.Test
    public void filterGreenApple() throws Exception {
        List<AppleVo> list = AppleData.generAppleData();
        List<AppleVo> resultList = StartJavaEight.filterGreenApple(list);
        printList(resultList);
    }

    @Test
    public void filterColorApple() {
        List<AppleVo> list = AppleData.generAppleData();
        List<AppleVo> resultList = StartJavaEight.filterColorApple(list, "red");
        printList(resultList);
    }

    @Test
    public void filterAppleLambda() {
        List<AppleVo> list = AppleData.generAppleData();
        List<AppleVo> resultList = StartJavaEight.filterAppleLambda(list);
        printList(resultList);
    }

    private void printList(List<AppleVo> list) {
        System.out.println("result : [");
        for (AppleVo appleVo : list) {
            System.out.println(appleVo);
        }
        System.out.println("]");
    }



}
