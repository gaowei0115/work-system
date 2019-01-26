package com.mmc.work.java8.data;

import com.mmc.work.java8.vo.AppleVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.mmc.work.java8.data
 * @desrciption:
 * @author: GW
 * @date： 2019-01-26 16:16
 * @history: (version) author date desc
 */
public class AppleData {

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
