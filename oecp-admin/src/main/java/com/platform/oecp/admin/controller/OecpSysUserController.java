package com.platform.oecp.admin.controller;

import com.platform.oecp.business.manager.OecpSysUserManager;
import com.platform.oecp.dto.OecpUserInfoRequestDto;
import com.platform.oecp.models.dos.OecpSysUserDO;
import com.platform.oecp.models.qc.OecpSysUserQC;
import com.platform.oecp.models.response.BaseApi;
import com.platform.oecp.models.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author 造飞机团队
 **/
@Controller
public class OecpSysUserController  {
    @Autowired
    private OecpSysUserManager oecpSysUserManager;

    @GetMapping("/oecpSysUser/query")
    @ResponseBody
    public BaseResponse<PageData<OecpSysUserDO>> queryOecpSysUser(OecpSysUserQC qc, Page page ){
        Long totalCount = oecpSysUserManager.countOecpSysUser(qc);
        qc.setPage(page);
        List<OecpSysUserDO> oecpSysUsers = oecpSysUserManager.queryOecpSysUser(qc);
        return  BaseResponse.assemblePageResponse(oecpSysUsers,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpSysUser/save")
    @ResponseBody
    public BaseResponse<String> saveOecpSysUser(OecpSysUserDO oecpSysUser){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpSysUserManager.saveOecpSysUser(oecpSysUser);
        baseResponse.setData("OK");
        return  baseResponse;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/16 22:40
     * @Param : oecpUserInfoRequestDto
     * @return: red.lixiang.tools.base.BaseResponse<com.platform.oecp.models.dos.OecpSysUserDO>
     * @description: 更新用户信息
     */
    @PostMapping("/updateUserInfo")
    @ResponseBody
    public BaseResponse<OecpSysUserDO> updateUserInfo(@NotNull(message = "请求参数不能为空") @Valid OecpUserInfoRequestDto oecpUserInfoRequestDto){
        BaseResponse<OecpSysUserDO> baseResponse = new BaseResponse<>();
        if((StringUtils.isEmpty(oecpUserInfoRequestDto.getOldPassword()) && oecpUserInfoRequestDto.getThirtyLogin() == false) ||
                StringUtils.isEmpty(oecpUserInfoRequestDto.getNewPassword()) ||
                StringUtils.isEmpty(oecpUserInfoRequestDto.getAccountId())) {
            baseResponse.setResult(false);
            baseResponse.setMsg("账号和密码信息填写有误！");
        }
        OecpSysUserDO oecpSysUserDO = oecpSysUserManager.updateUserInfo(oecpUserInfoRequestDto);
        if(oecpSysUserDO == null){
            baseResponse.setResult(false);
            baseResponse.setMsg("数据修改失败，请稍后再试！");
        }
        baseResponse.setData(oecpSysUserDO);
        baseResponse.setResult(true);
        baseResponse.setMsg("success");
        baseResponse.setCode("200");
        return  baseResponse;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/17 11:14
     * @Param : accountId
     * @return: red.lixiang.tools.base.BaseResponse<com.platform.oecp.models.dos.OecpSysUserDO>
     * @description: 验证账户名是否重复，重复返回信息，不重复返回null
     */
    @GetMapping("/checkRepeatAccount")
    @ResponseBody
    public BaseResponse<OecpSysUserDO> checkRepeatAccount(@NotNull(message = "账号不能为空") @Valid @RequestParam("accountId")String accountId){
        BaseResponse<OecpSysUserDO> baseResponse = new BaseResponse<>();
        OecpSysUserDO oecpSysUserDO = oecpSysUserManager.getOecpSysUserByAccountId(accountId);
        if(oecpSysUserDO == null){
            baseResponse.setData(null);
        }
        baseResponse.setData(oecpSysUserDO);
        return baseResponse;
    }

    @GetMapping("/oecpSysUser/get")
    @ResponseBody
    public BaseResponse<OecpSysUserDO> getOecpSysUser(OecpSysUserQC qc){
        qc.setPage(Page.getOne());
        List<OecpSysUserDO> oecpSysUsers = oecpSysUserManager.queryOecpSysUser(qc);
        if(oecpSysUsers!=null && oecpSysUsers.size()>0){
            return BaseResponse.success(oecpSysUsers.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpSysUser/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpSysUserManager.removeOecpSysUserById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
