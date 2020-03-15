package com.platform.oecp.utils;

import org.springframework.util.StringUtils;

/**
 * @version 1.0
 * @className: DesensitizeInfoUtil
 * @author: LILIANG
 * @date: Create In 2020/3/15 14:43
 * @description:
 */
public class DesensitizeInfoUtil {

    private DesensitizeInfoUtil() {
        //prohibit create new instance
    }

    /**
     * 手机号格式校验正则
     */
    public static final String PHONE_REGEX = "^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\d{8}$";

    /**
     * 手机号脱敏筛选正则
     */
    public static final String PHONE_BLUR_REGEX = "(\\d{3})\\d{4}(\\d{4})";

    /**
     * 手机号脱敏替换正则
     */
    public static final String PHONE_BLUR_REPLACE_REGEX = "$1****$2";

    /**
     * 手机号格式校验
     * @param phone
     * @return
     */
    public static final boolean checkPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return false;
        }
        return phone.matches(PHONE_REGEX);
    }
    /**
     * 手机号脱敏处理
     * @param phone
     * @return
     */
    public static final String phoneEncrypt(String phone) {
        boolean checkFlag = checkPhone(phone);
        if (!checkFlag) {
            throw new IllegalArgumentException("手机号格式不正确!");
        }
        return phone.replaceAll(PHONE_BLUR_REGEX, PHONE_BLUR_REPLACE_REGEX);
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/15 14:45
     * @Param : mobile
     * @return: java.lang.String
     * @description: 手机号码前三后四脱敏
     */
    public static String mobileEncrypt(String mobile) {
        if (StringUtils.isEmpty(mobile) || (mobile.length() != 11)) {
            return mobile;
        }
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/15 14:45
     * @Param : id
     * @return: java.lang.String
     * @description: 身份证前三后四脱敏
     */
    public static String idEncrypt(String id) {
        if (StringUtils.isEmpty(id) || (id.length() < 8)) {
            return id;
        }
        return id.replaceAll("(?<=\\w{3})\\w(?=\\w{4})", "*");
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/15 14:46
     * @Param : id
     * @return: java.lang.String
     * @description: 护照前2后3位脱敏，护照一般为8或9位
     */
    public static String idPassport(String id) {
        if (StringUtils.isEmpty(id) || (id.length() < 8)) {
            return id;
        }
        return id.substring(0, 2) + new String(new char[id.length() - 5]).replace("\0", "*") + id.substring(id.length() - 3);
    }
}
