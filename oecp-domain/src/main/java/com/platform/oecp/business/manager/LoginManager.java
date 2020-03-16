package com.platform.oecp.business.manager;

import com.alibaba.fastjson.JSON;
import com.platform.oecp.models.dos.OecpSysUserDO;
import com.platform.oecp.models.qc.OecpSysUserQC;
import com.platform.oecp.utils.JavaWebToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import red.lixiang.tools.base.exception.BusinessException;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.jdk.ListTools;
import red.lixiang.tools.spring.redis.RedisTools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @className: LoginManager
 * @author: LILIANG
 * @date: Create In 2020/3/16 14:57
 * @description:
 */
@Service
public class LoginManager {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(LoginManager.class);
    /**
     * 用户名key
     */
    private static final String USER_NAME_KEY = "username";
    /**
     * 密码key
     */
    private static final String PASSWORD_KEY = "password";

    @Autowired
    private OecpSysUserManager oecpSysUserManager;

    @Autowired
    private RedisTools redisUtils;

    /**
     * @author: LILIANG
     * @date: 2020/3/16 15:02
     * @Param : username
     * @Param : password
     * @return: com.platform.oecp.models.dos.OecpSysUserDO
     * @description: 登陆token
     */
    public OecpSysUserDO login(String username,String password){
        Map<String, Object> claims = new HashMap<String,Object>();
        claims.put(USER_NAME_KEY, username);
        claims.put(PASSWORD_KEY, password);
        String md5Pass = DigestUtils.md5DigestAsHex(password.getBytes());
        //验证是否存在此信息用户
        OecpSysUserQC qc = new OecpSysUserQC();
        qc.setPage(Page.getOne());
        List<OecpSysUserDO> oecpSysUsers = oecpSysUserManager.queryOecpSysUser(qc);
        OecpSysUserDO oecpSysUserDO = ListTools.getOne(oecpSysUsers);
        if(oecpSysUserDO == null){
            throw new BusinessException("please register");
        }
        String token = JavaWebToken.createToken(claims);
        redisUtils.set(username + md5Pass,token, Long.valueOf(1800));
        String accountJSON = JSON.toJSONString(oecpSysUserDO);
        redisUtils.set("TOKEN_TELL_KEY_" + token,accountJSON,Long.valueOf(1800));
        oecpSysUserDO.setToken(token);
        return oecpSysUserDO;
    }
}
