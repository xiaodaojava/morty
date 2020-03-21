package com.platform.oecp.utils;

import com.platform.oecp.common.AccountRepo;
import com.platform.oecp.models.dos.OecpSysUserDO;

/**
 * @version 1.0
 * @className: UserUtil
 * @author: LILIANG
 * @date: Create In 2020/3/21 12:42
 * @description:
 */
public abstract class UserUtil {

    /**
     * 获取当前用户
     */
    public static OecpSysUserDO currentUser() {
        OecpSysUserDO oecpSysUserDO = AccountRepo.getAccountFromMemory();
        return oecpSysUserDO;
    }

}
