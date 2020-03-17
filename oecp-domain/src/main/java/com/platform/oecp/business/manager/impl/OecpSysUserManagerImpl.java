package com.platform.oecp.business.manager.impl;

import com.platform.oecp.business.manager.OecpSysUserManager;
import com.platform.oecp.dao.OecpSysUserMapper;
import com.platform.oecp.dto.OecpUserInfoRequestDto;
import com.platform.oecp.models.dos.OecpSysUserDO;
import com.platform.oecp.models.qc.OecpSysUserQC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import red.lixiang.tools.base.exception.BusinessException;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.jdk.ListTools;

import java.util.Date;
import java.util.List;

import static com.platform.oecp.models.OecpCommonConstants.OLD_PASSWORD_ERROR;
import static com.platform.oecp.models.OecpCommonConstants.SET_PASSWORD_ERROR;

@Component
public class OecpSysUserManagerImpl implements OecpSysUserManager{

    @Autowired
    private OecpSysUserMapper oecpSysUserMapper;
    /**
     * 项目编码
     */
    @Value("${project.code}")
    private int projectCode;

    
    @Override
    public OecpSysUserDO getOecpSysUserById(Long id) {
        OecpSysUserQC qc = new OecpSysUserQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpSysUserDO> oecpSysUserDOS = queryOecpSysUser(qc);
        return ListTools.getOne(oecpSysUserDOS);
    }

    @Override
    public OecpSysUserDO getOecpSysUserByThirdPartyId(String thirdPartyId) {
        OecpSysUserQC qc = new OecpSysUserQC();
        qc.setThirdPartyId(thirdPartyId);
        qc.setPage(Page.getOne());
        List<OecpSysUserDO> oecpSysUserDOS = queryOecpSysUser(qc);
        return ListTools.getOne(oecpSysUserDOS);
    }

    @Override
    public OecpSysUserDO getOecpSysUserByAccountId(String accountId) {
        OecpSysUserQC qc = new OecpSysUserQC();
        qc.setAccountId(accountId);
        qc.setPage(Page.getOne());
        List<OecpSysUserDO> oecpSysUserDOS = queryOecpSysUser(qc);
        return ListTools.getOne(oecpSysUserDOS);
    }


    @Override
    public List<OecpSysUserDO> queryOecpSysUser(OecpSysUserQC qc){

        List<OecpSysUserDO> oecpSysUsers = oecpSysUserMapper.listOecpSysUsers(qc);
        return oecpSysUsers;
    }
    

    @Override
    public Long countOecpSysUser(OecpSysUserQC qc){

        Long count = oecpSysUserMapper.countOecpSysUsers(qc);
        return count;
    }

    @Override
    public OecpSysUserDO saveOecpSysUser(OecpSysUserDO oecpSysUser){

        if(oecpSysUser.getId()!=null){
             oecpSysUserMapper.updateOecpSysUser(oecpSysUser);
        }else {
            oecpSysUser.setCreateDate(new Date());
             oecpSysUserMapper.insertOecpSysUser(oecpSysUser);
        }
        return oecpSysUser;

    }

    /**
     * @author: LILIANG
     * @date: 2020/3/16 23:21
     * @Param : oecpUserInfoRequestDto
     * @return: com.platform.oecp.models.dos.OecpSysUserDO
     * @description: 更新用户账号信息
     */
    @Override
    public OecpSysUserDO updateUserInfo(OecpUserInfoRequestDto oecpUserInfoRequestDto) {
        String oldPassMd5 = DigestUtils.md5DigestAsHex(oecpUserInfoRequestDto.getOldPassword().getBytes());
        //先校验老密码与新密码是否相同，相同不容许，必须不一样
        if(oldPassMd5.equals(DigestUtils.md5DigestAsHex(oecpUserInfoRequestDto.getNewPassword().getBytes()))){
            throw new BusinessException("新密码和老密码不能设置成一样！",projectCode+SET_PASSWORD_ERROR);
        }
        //再验证老密码是否正确
        OecpSysUserQC qc = new OecpSysUserQC();
        qc.setId(oecpUserInfoRequestDto.getId());
        qc.setAccountId(oecpUserInfoRequestDto.getAccountId());
        qc.setPage(Page.getOne());
        List<OecpSysUserDO> oecpSysUserDOS = queryOecpSysUser(qc);
        OecpSysUserDO oecpSysUserDO = ListTools.getOne(oecpSysUserDOS);
        if(!oldPassMd5.equals(DigestUtils.md5DigestAsHex(oecpSysUserDO.getPassword().getBytes()))){
            throw new BusinessException("填写老密码错误！",projectCode+OLD_PASSWORD_ERROR);
        }
        oecpSysUserDO.setAccountId(oecpUserInfoRequestDto.getAccountId());
        oecpSysUserDO.setPassword(DigestUtils.md5DigestAsHex(oecpUserInfoRequestDto.getNewPassword().getBytes()));
        //更新用户信息-密码和账户
        int updateFlag = oecpSysUserMapper.updateOecpSysUser(oecpSysUserDO);
        if(updateFlag > 0){
            return oecpSysUserDO;
        }
        return null;
    }

    @Override
    public int removeOecpSysUserById(Long id){

        return oecpSysUserMapper.removeOecpSysUserById(id);

    }


}
