package com.platform.oecp.business.manager;


import com.platform.oecp.dto.OecpUserInfoRequestDto;
import com.platform.oecp.models.dos.OecpSysUserDO;
import com.platform.oecp.models.qc.OecpSysUserQC;

import java.util.List;


public interface OecpSysUserManager {

    public OecpSysUserDO getOecpSysUserById (Long id);

    /**
     * @description 使用第三方唯一ID获取用户
     * @param thirdPartyId
     * @return
     */
    public OecpSysUserDO getOecpSysUserByThirdPartyId(String thirdPartyId);

    /**
     * @description 通过账号获取用户信息
     * @param accountId
     * @return
     */
    public OecpSysUserDO getOecpSysUserByAccountId(String accountId);

    public List<OecpSysUserDO> queryOecpSysUser(OecpSysUserQC qc);


    public Long countOecpSysUser(OecpSysUserQC oecpSysUser);

    public OecpSysUserDO saveOecpSysUser(OecpSysUserDO oecpSysUser);

    /**
     * @description 更新用户信息
     * @param oecpUserInfoRequestDto
     * @return
     */
    public OecpSysUserDO updateUserInfo(OecpUserInfoRequestDto oecpUserInfoRequestDto);

    public int removeOecpSysUserById(Long id);



}
