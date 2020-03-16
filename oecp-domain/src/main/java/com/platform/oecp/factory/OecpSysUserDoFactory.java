package com.platform.oecp.factory;

import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.platform.oecp.models.OecpCommonConstants;
import com.platform.oecp.models.dos.OecpSysUserDO;
import com.platform.oecp.utils.GenerateAccountUtil;
import com.platform.oecp.utils.RandomPasswordUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.Date;

/**
 * @version 1.0
 * @className: OecpSysUserDOFactory
 * @author: LILIANG
 * @date: Create In 2020/3/15 11:56
 * @description:
 */
@Component
public class OecpSysUserDoFactory {

    /**
     * @author: LILIANG
     * @date: 2020/3/15 12:16
     * @Param : alipayUserInfoShareResponse
     * @return: com.platform.oecp.models.dos.OecpSysUserDO
     * @description: 创建实例
     */
    public OecpSysUserDO createNewInstance(AlipayUserInfoShareResponse alipayUserInfoShareResponse){
        OecpSysUserDO oecpSysUserDO = new OecpSysUserDO();
        oecpSysUserDO.setAccountId(GenerateAccountUtil.generateShortUuid());
        oecpSysUserDO.setPassword(DigestUtils.md5DigestAsHex(RandomPasswordUtil.getPassword().getBytes()));
        oecpSysUserDO.setNickName(alipayUserInfoShareResponse.getNickName());
        oecpSysUserDO.setProvince(alipayUserInfoShareResponse.getProvince());
        oecpSysUserDO.setCity(alipayUserInfoShareResponse.getCity());
        oecpSysUserDO.setAvatar(alipayUserInfoShareResponse.getAvatar());
        oecpSysUserDO.setCompanyId(alipayUserInfoShareResponse.getOrganizationCode());
        oecpSysUserDO.setEmail(alipayUserInfoShareResponse.getEmail());
        oecpSysUserDO.setGender(alipayUserInfoShareResponse.getGender());
        oecpSysUserDO.setIsCertified(alipayUserInfoShareResponse.getIsCertified());
        oecpSysUserDO.setIsStudentCertified(alipayUserInfoShareResponse.getIsStudentCertified());
        oecpSysUserDO.setLoginDate(new Date());
        oecpSysUserDO.setLoginType(OecpCommonConstants.ALI_PAY_LOGIN_TYPE);
        oecpSysUserDO.setTelephone(alipayUserInfoShareResponse.getPhone());
        oecpSysUserDO.setThirdPartyId(alipayUserInfoShareResponse.getUserId());
        oecpSysUserDO.setUserStatus(alipayUserInfoShareResponse.getUserStatus());
        oecpSysUserDO.setUserType(alipayUserInfoShareResponse.getUserType());
        return oecpSysUserDO;
    }
}
