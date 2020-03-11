package com.platform.oecp.admin.controller;

import com.alibaba.fastjson.JSON;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import com.platform.oecp.business.manager.OecpUserRoleManager;
import com.platform.oecp.models.dos.OecpUserRoleDO;
import com.platform.oecp.models.qc.OecpUserRoleQC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 造飞机团队
 **/
@Controller
public class OecpUserRoleController  {
    @Autowired
    private OecpUserRoleManager oecpUserRoleManager;

    @GetMapping("/oecpUserRole/query")
    @ResponseBody
    public BaseResponse<PageData<OecpUserRoleDO>> queryOecpUserRole(OecpUserRoleQC qc, Page page ){


        Long totalCount = oecpUserRoleManager.countOecpUserRole(qc);
        qc.setPage(page);
        List<OecpUserRoleDO> oecpUserRoles = oecpUserRoleManager.queryOecpUserRole(qc);

        return  BaseResponse.assemblePageResponse(oecpUserRoles,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpUserRole/save")
    @ResponseBody
    public BaseResponse<String> saveOecpUserRole(OecpUserRoleDO oecpUserRole){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpUserRoleManager.saveOecpUserRole(oecpUserRole);
        baseResponse.setData("OK");
        return  baseResponse;
    }


    
    @GetMapping("/oecpUserRole/get")
    @ResponseBody
    public BaseResponse<OecpUserRoleDO> getOecpUserRole(OecpUserRoleQC qc){
        qc.setPage(Page.getOne());
        List<OecpUserRoleDO> oecpUserRoles = oecpUserRoleManager.queryOecpUserRole(qc);
        if(oecpUserRoles!=null && oecpUserRoles.size()>0){
            return BaseResponse.success(oecpUserRoles.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpUserRole/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpUserRoleManager.removeOecpUserRoleById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
