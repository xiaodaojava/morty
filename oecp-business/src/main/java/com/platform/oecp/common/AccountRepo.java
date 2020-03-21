package com.platform.oecp.common;

import com.platform.oecp.models.dos.OecpSysUserDO;

/**
 * @version 1.0
 * @className: AccountRepo
 * @author: LILIANG
 * @date: Create In 2020/3/16 12:01
 * @description:
 */
public class AccountRepo {

    private static ThreadLocal<OecpSysUserDO> accountLocal =new ThreadLocal<>();

    private static ThreadLocal<String> tokenLocal  = new ThreadLocal<>();

    public static String getToken() {
        return tokenLocal.get();
    }

    public static void setToken(String token) {
        tokenLocal.set(token);
    }

    public static OecpSysUserDO getAccountFromMemory() {
        return accountLocal.get();
    }

    public static void setAccountInMemory(OecpSysUserDO account) {
        accountLocal.set(account);
    }

    public static void cleanRepo(){
        accountLocal.remove();
        tokenLocal.remove();
    }
}
