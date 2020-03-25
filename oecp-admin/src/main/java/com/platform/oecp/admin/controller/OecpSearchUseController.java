package com.platform.oecp.admin.controller;

import com.alibaba.fastjson.JSON;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import com.platform.oecp.business.manager.OecpSearchUseManager;
import com.platform.oecp.models.dos.OecpSearchUseDO;
import com.platform.oecp.models.qc.OecpSearchUseQC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class OecpSearchUseController  {
    @Autowired
    private OecpSearchUseManager oecpSearchUseManager;

    @GetMapping("/oecpSearchUse/query")
    @ResponseBody
    public BaseResponse<PageData<OecpSearchUseDO>> queryOecpSearchUse(OecpSearchUseQC qc, Page page ){


        Long totalCount = oecpSearchUseManager.countOecpSearchUse(qc);
        qc.setPage(page);
        List<OecpSearchUseDO> oecpSearchUses = oecpSearchUseManager.queryOecpSearchUse(qc);

        return  BaseResponse.assemblePageResponse(oecpSearchUses,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpSearchUse/save")
    @ResponseBody
    public BaseResponse<String> saveOecpSearchUse(OecpSearchUseDO oecpSearchUse){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpSearchUseManager.saveOecpSearchUse(oecpSearchUse);
        baseResponse.setData("OK");
        return  baseResponse;
    }


    
    @GetMapping("/oecpSearchUse/get")
    @ResponseBody
    public BaseResponse<OecpSearchUseDO> getOecpSearchUse(OecpSearchUseQC qc){
        qc.setPage(Page.getOne());
        List<OecpSearchUseDO> oecpSearchUses = oecpSearchUseManager.queryOecpSearchUse(qc);
        if(oecpSearchUses!=null && oecpSearchUses.size()>0){
            return BaseResponse.success(oecpSearchUses.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpSearchUse/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpSearchUseManager.removeOecpSearchUseById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
