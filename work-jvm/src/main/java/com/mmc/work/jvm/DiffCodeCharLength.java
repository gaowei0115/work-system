package com.mmc.work.jvm;

/**
 * @packageName：com.mmc.work.jvm
 * @desrciption: 不同编码标准得到的字符长度不同验证
 * @author: gaowei
 * @date： 2018-03-01 9:37
 * @history: (version) author date desc
 */
public class DiffCodeCharLength {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // UTF-8 编码标准，测试字符长度
        String UTF8_Str = "format";
        try {
            System.out.println("EN - utf-8 >> " + UTF8_Str.getBytes("UTF-8").length);
        } catch (Exception e) {

        }

        // UTF-16编码标准，测试字符长度
        String UTF16_Str = "format";
        try {
            byte[] bytes  = UTF16_Str.getBytes("UTF-16");

            System.out.println("EN - utf-16 >> " + UTF16_Str.getBytes("UTF-16").length);
        } catch(Exception e) {

        }

        // GBK编码标准，测试字符长度
        String GBK_Str = "format";
        try {
            System.out.println("EN - GBK >> " + GBK_Str.getBytes("GBK").length);
        } catch (Exception e) {

        }

        // 中文字符GBK编码格式，测试字符长度
        String GBK_CH_Str = "大风起兮云飞扬";
        try {
            System.out.println("CH - GBK >> " + GBK_CH_Str.getBytes("GBK").length);
        } catch (Exception e) {

        }

        // 中文字符UTF-8编码格式，测试字符长度
        String UTF8_CH_Str = "大风起兮云飞扬";
        try {
            System.out.println("CH - utf-8 >> " + UTF8_CH_Str.getBytes("utf-8").length);
        } catch (Exception e) {

        }

        // 中文字符UTF-16编码格式，测试字符长度
        String UTF16_CH_Str = "大风起兮云飞扬";
        try {
            System.out.println("CH - utf-16 >> " + UTF16_CH_Str.getBytes("utf-16").length);
        } catch (Exception e) {

        }


    }
}
