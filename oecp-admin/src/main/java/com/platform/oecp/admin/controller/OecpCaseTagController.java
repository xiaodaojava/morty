package com.platform.oecp.admin.controller;

import com.alibaba.fastjson.JSON;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import com.platform.oecp.business.manager.OecpCaseTagManager;
import com.platform.oecp.models.dos.OecpCaseTagDO;
import com.platform.oecp.models.qc.OecpCaseTagQC;
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
public class OecpCaseTagController  {
    @Autowired
    private OecpCaseTagManager oecpCaseTagManager;

    @GetMapping("/oecpCaseTag/query")
    @ResponseBody
    public BaseResponse<PageData<OecpCaseTagDO>> queryOecpCaseTag(OecpCaseTagQC qc, Page page ){


        Long totalCount = oecpCaseTagManager.countOecpCaseTag(qc);
        qc.setPage(page);
        List<OecpCaseTagDO> oecpCaseTags = oecpCaseTagManager.queryOecpCaseTag(qc);

        return  BaseResponse.assemblePageResponse(oecpCaseTags,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpCaseTag/save")
    @ResponseBody
    public BaseResponse<String> saveOecpCaseTag(OecpCaseTagDO oecpCaseTag){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpCaseTagManager.saveOecpCaseTag(oecpCaseTag);
        baseResponse.setData("OK");
        return  baseResponse;
    }


    
    @GetMapping("/oecpCaseTag/get")
    @ResponseBody
    public BaseResponse<OecpCaseTagDO> getOecpCaseTag(OecpCaseTagQC qc){
        qc.setPage(Page.getOne());
        List<OecpCaseTagDO> oecpCaseTags = oecpCaseTagManager.queryOecpCaseTag(qc);
        if(oecpCaseTags!=null && oecpCaseTags.size()>0){
            return BaseResponse.success(oecpCaseTags.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpCaseTag/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpCaseTagManager.removeOecpCaseTagById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
