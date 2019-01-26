package com.mmc.work.java8.part01;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @packageName：com.mmc.work.java8.part01
 * @desrciption:
 * @author: GW
 * @date： 2019-01-26 17:20
 * @history: (version) author date desc
 */
public class ProcessFile {

    /**
     * 处理文件
     * @param p
     * @return
     * @throws Exception
     */
    public static String processFile(BufferedReaderProcessor p) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("D:\\install.log"));
        return p.process(br);
    }

    public static void main(String[] args) {
        try {
            String result = processFile((BufferedReader br) -> br.readLine() + br.readLine());
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
