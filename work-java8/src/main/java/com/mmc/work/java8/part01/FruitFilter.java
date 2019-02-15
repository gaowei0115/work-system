package com.mmc.work.java8.part01;

import com.mmc.work.java8.utils.FruitData;
import com.mmc.work.java8.utils.PrintList;
import com.mmc.work.java8.vo.AppleVo;
import com.mmc.work.java8.vo.FruitVo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @packageName：com.mmc.work.java8.part01
 * @desrciption:
 * @author: GW
 * @date： 2019-01-26 17:32
 * @history: (version) author date desc
 */
public class FruitFilter<T> {

    /**
     *
     * @param originalList
     * @param p
     * @param <T>
     * @return
     */
    public static <T> List<T> filterFruit(List<T> originalList, Predicate<T> p) {
        if (originalList == null || originalList.size() == 0) {
            return null;
        }
        List<T> result = new ArrayList<>();
        for (T t : originalList) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<AppleVo> originalList = FruitData.generAppleData();
        List<AppleVo> appleVoList = filterFruit(originalList, ((AppleVo av) -> av.getColor().equals("red")));
        PrintList.prinList(appleVoList);

        List<FruitVo> list = FruitData.createFruitData();
        List<FruitVo> weightList = filterFruit(list, (FruitVo fv) -> fv.getWeight() >= 1.1);
        PrintList.prinList(weightList);


        filterFruit(list, fv -> fv.getWeight() > 0.6);
    }
}
