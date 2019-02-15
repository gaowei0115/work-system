package com.mmc.work.java8.utils;

import com.mmc.work.java8.vo.AppleVo;
import com.mmc.work.java8.vo.FruitVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.mmc.work.java8.utils
 * @desrciption:
 * @author: GW
 * @date： 2019-01-26 17:37
 * @history: (version) author date desc
 */
public class FruitData {


    public static List<FruitVo> createFruitData() {
        List<FruitVo> fruitVoList = new ArrayList<>();
        FruitVo fruitVo = new FruitVo();
        fruitVo.setName("apple");
        fruitVo.setColor("red");
        fruitVo.setWeight(0.54);
        fruitVo.setSize(1.2);
        fruitVoList.add(fruitVo);

        fruitVo = new FruitVo();
        fruitVo.setName("apple");
        fruitVo.setColor("blue");
        fruitVo.setWeight(1.1);
        fruitVo.setSize(1.9);
        fruitVoList.add(fruitVo);

        fruitVo = new FruitVo();
        fruitVo.setName("orange");
        fruitVo.setColor("yellow");
        fruitVo.setWeight(0.23);
        fruitVo.setSize(0.26);
        fruitVoList.add(fruitVo);

        fruitVo = new FruitVo();
        fruitVo.setName("orange");
        fruitVo.setColor("red");
        fruitVo.setWeight(0.33);
        fruitVo.setSize(0.46);
        fruitVoList.add(fruitVo);

        fruitVo = new FruitVo();
        fruitVo.setName("Pear");
        fruitVo.setColor("yellow");
        fruitVo.setWeight(0.53);
        fruitVo.setSize(0.76);
        fruitVoList.add(fruitVo);

        fruitVo = new FruitVo();
        fruitVo.setName("Pear");
        fruitVo.setColor("red");
        fruitVo.setWeight(0.21);
        fruitVo.setSize(0.48);
        fruitVoList.add(fruitVo);

        return fruitVoList;
    }


    /**
     *
     * @return
     */
    public static List<AppleVo> generAppleData() {
        List<AppleVo> appleVoList = new ArrayList<AppleVo>();
        AppleVo appleVo = new AppleVo();
        appleVo.setId("001");
        appleVo.setColor("red");
        appleVo.setSize("12");
        appleVoList.add(appleVo);
        appleVo = new AppleVo();
        appleVo.setId("002");
        appleVo.setColor("red");
        appleVo.setSize("13");
        appleVoList.add(appleVo);
        appleVo = new AppleVo();
        appleVo.setId("003");
        appleVo.setColor("red");
        appleVo.setSize("14");
        appleVoList.add(appleVo);

        appleVo = new AppleVo();
        appleVo.setId("001");
        appleVo.setColor("green");
        appleVo.setSize("10");
        appleVoList.add(appleVo);

        appleVo = new AppleVo();
        appleVo.setId("002");
        appleVo.setColor("green");
        appleVo.setSize("11");
        appleVoList.add(appleVo);
        appleVo = new AppleVo();
        appleVo.setId("003");
        appleVo.setColor("green");
        appleVo.setSize("12");
        appleVoList.add(appleVo);

        appleVo = new AppleVo();
        appleVo.setId("001");
        appleVo.setColor("blue");
        appleVo.setSize("10");
        appleVoList.add(appleVo);

        appleVo = new AppleVo();
        appleVo.setId("002");
        appleVo.setColor("blue");
        appleVo.setSize("11");
        appleVoList.add(appleVo);

        appleVo = new AppleVo();
        appleVo.setId("003");
        appleVo.setColor("blue");
        appleVo.setSize("12");
        appleVoList.add(appleVo);

        return appleVoList;
    }
}
