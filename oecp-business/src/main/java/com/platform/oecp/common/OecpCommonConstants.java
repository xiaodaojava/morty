package com.platform.oecp.common;

/**
 * @version 1.0
 * @className: OecpCommonConstants
 * @author: LILIANG
 * @date: Create In 2020/3/15 12:08
 * @description:
 */
public class OecpCommonConstants {

    private OecpCommonConstants() {
        //prohibit create new instance
    }

    /**
     * 支付宝登陆方式类型值
     */
    public static final int ALI_PAY_LOGIN_TYPE = 1;
    /**
     * 微信登陆方式类型值
     */
    public static final int WEI_XIN_LOGIN_TYPE = 2;
    /**
     * 请注册-异常码
     */
    public static final int PLEASE_REGISTER_ERROR = 302;
    /**
     * 请登录-异常码
     */
    public static final int PLEASE_LOGIN_ERROR = 405;
    /**
     * 密码错误-异常码
     */
    public static final int PASSWORD_IS_WRONG = 406;
    /**
     * token为空-异常码
     */
    public static final int TOKEN_IS_NULL = 407;
    /**
     * 新密码和老密码不能一样-异常码
     */
    public static final int SET_PASSWORD_ERROR = 408;

    /**
     * 老密码错误-异常码
     */
    public static final int OLD_PASSWORD_ERROR = 409;
    /**
     * 错误码存在重复的定义
     */
    public static final int ERROR_CODE_REPEAT = 410;
    /**
     * 删除错误码失败
     */
    public static final int DELETE_ERROR_INFO_FAIL = 411;
    /**
     * 删除案例失败
     */
    public static final int DELETE_CASE_INFO_FAIL = 412;
}
