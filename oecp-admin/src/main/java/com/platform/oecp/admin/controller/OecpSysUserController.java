package com.platform.oecp.admin.controller;

import com.platform.oecp.business.manager.OecpSysUserManager;
import com.platform.oecp.models.dos.OecpSysUserDO;
import com.platform.oecp.models.qc.OecpSysUserQC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;

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
