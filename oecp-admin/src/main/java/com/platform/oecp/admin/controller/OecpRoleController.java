package com.platform.oecp.admin.controller;

import com.alibaba.fastjson.JSON;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import com.platform.oecp.business.manager.OecpRoleManager;
import com.platform.oecp.models.dos.OecpRoleDO;
import com.platform.oecp.models.qc.OecpRoleQC;
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
public class OecpRoleController  {
    @Autowired
    private OecpRoleManager oecpRoleManager;

    @GetMapping("/oecpRole/query")
    @ResponseBody
    public BaseResponse<PageData<OecpRoleDO>> queryOecpRole(OecpRoleQC qc, Page page ){


        Long totalCount = oecpRoleManager.countOecpRole(qc);
        qc.setPage(page);
        List<OecpRoleDO> oecpRoles = oecpRoleManager.queryOecpRole(qc);

        return  BaseResponse.assemblePageResponse(oecpRoles,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpRole/save")
    @ResponseBody
    public BaseResponse<String> saveOecpRole(OecpRoleDO oecpRole){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpRoleManager.saveOecpRole(oecpRole);
        baseResponse.setData("OK");
        return  baseResponse;
    }


    
    @GetMapping("/oecpRole/get")
    @ResponseBody
    public BaseResponse<OecpRoleDO> getOecpRole(OecpRoleQC qc){
        qc.setPage(Page.getOne());
        List<OecpRoleDO> oecpRoles = oecpRoleManager.queryOecpRole(qc);
        if(oecpRoles!=null && oecpRoles.size()>0){
            return BaseResponse.success(oecpRoles.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpRole/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpRoleManager.removeOecpRoleById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
