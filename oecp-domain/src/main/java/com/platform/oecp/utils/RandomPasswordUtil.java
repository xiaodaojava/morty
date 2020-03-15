package com.platform.oecp.utils;

import java.util.Random;

/**
 * @version 1.0
 * @className: RandomPasswordUtil
 * @author: LILIANG
 * @date: Create In 2020/3/15 13:52
 * @description:
 */
public class RandomPasswordUtil {

    /**
     * @author: LILIANG
     * @date: 2020/3/15 13:52
     *
     * @return: java.lang.String
     * @description: 随机生成8位密码
     */
    public static String getPassword() {
        // 创建随机对象
        Random rd = new Random();
        // 保存随机数
        String n = "";
        // 取得随机数
        int rdGet;
        do {
            if (rd.nextInt() % 2 == 1) {
                // 产生48到57的随机数(0-9的键位值)
                rdGet = Math.abs(rd.nextInt()) % 10 + 48;
            } else {
                // 产生97到122的随机数(a-z的键位值)
                rdGet = Math.abs(rd.nextInt()) % 26 + 97;
            }
            // int转换char
            char num1 = (char) rdGet;
            String dd = Character.toString(num1);
            n += dd;
            // 设定长度，此处假定长度小于8
        } while (n.length() < 8);
        return n;
    }
}
