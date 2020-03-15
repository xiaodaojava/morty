package com.platform.oecp.business.manager.impl;

import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.platform.oecp.business.manager.OecpSysUserManager;
import com.platform.oecp.models.OecpCommonConstants;
import com.platform.oecp.factory.OecpSysUserDoFactory;
import com.platform.oecp.models.dos.OecpSysUserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @version 1.0
 * @className: UserInfoService
 * @author: LILIANG
 * @date: Create In 2020/3/15 11:35
 * @description:
 */
@Service
public class UserInfoManager {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(UserInfoManager.class);

    @Autowired
    private OecpSysUserManager oecpSysUserManager;

    @Autowired
    private OecpSysUserDoFactory oecpSysUserDoFactory;

    /**
     * @author: LILIANG
     * @date: 2020/3/15 11:15
     * @Param : userId
     * @return: void
     * @description: 用户信息维护
     */
    @Async
    public void maintainUserInfo(AlipayUserInfoShareResponse alipayUserInfoShareResponse){
        //校验是否平台存在此用户
        OecpSysUserDO oecpSysUser = oecpSysUserManager.getOecpSysUserById(Long.valueOf(alipayUserInfoShareResponse.getUserId()));
        //存在就更新信息
        if(oecpSysUser != null){
            oecpSysUser.setId(oecpSysUser.getId());
            oecpSysUser.setAccountId(oecpSysUser.getAccountId());
            oecpSysUser.setPassword(oecpSysUser.getPassword());
            oecpSysUser.setNickName(alipayUserInfoShareResponse.getNickName());
            oecpSysUser.setProvince(alipayUserInfoShareResponse.getProvince());
            oecpSysUser.setCity(alipayUserInfoShareResponse.getCity());
            oecpSysUser.setAvatar(alipayUserInfoShareResponse.getAvatar());
            oecpSysUser.setCompanyId(alipayUserInfoShareResponse.getOrganizationCode());
            oecpSysUser.setEmail(alipayUserInfoShareResponse.getEmail());
            oecpSysUser.setGender(alipayUserInfoShareResponse.getGender());
            oecpSysUser.setIsCertified(alipayUserInfoShareResponse.getIsCertified());
            oecpSysUser.setIsStudentCertified(alipayUserInfoShareResponse.getIsStudentCertified());
            oecpSysUser.setLoginDate(new Date());
            oecpSysUser.setLoginType(OecpCommonConstants.ALI_PAY_LOGIN_TYPE);
            oecpSysUser.setTelephone(alipayUserInfoShareResponse.getPhone());
            oecpSysUser.setThirdPartyId(alipayUserInfoShareResponse.getUserId());
            oecpSysUser.setUserStatus(alipayUserInfoShareResponse.getUserStatus());
            oecpSysUser.setUserType(alipayUserInfoShareResponse.getUserType());
            oecpSysUserManager.saveOecpSysUser(oecpSysUser);
        }
        //不存在就创建用户，并为用户在平台上自动初始化创建账号和密码，后期用户可以自动修改
        if(oecpSysUser == null){
            OecpSysUserDO newOecpSysUserDO = oecpSysUserDoFactory.createNewInstance(alipayUserInfoShareResponse);
            newOecpSysUserDO = oecpSysUserManager.saveOecpSysUser(newOecpSysUserDO);
            logger.info("新用户信息已被平台创建，信息内容为:{}", newOecpSysUserDO);
        }
    }
}
