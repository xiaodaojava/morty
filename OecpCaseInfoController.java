package com.platform.oecp.admin.controller;

import com.alibaba.fastjson.JSON;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import com.platform.oecp.business.manager.OecpCaseInfoManager;
import com.platform.oecp.models.dos.OecpCaseInfoDO;
import com.platform.oecp.models.qc.OecpCaseInfoQC;
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
public class OecpCaseInfoController  {
    @Autowired
    private OecpCaseInfoManager oecpCaseInfoManager;

    @GetMapping("/oecpCaseInfo/query")
    @ResponseBody
    public BaseResponse<PageData<OecpCaseInfoDO>> queryOecpCaseInfo(OecpCaseInfoQC qc, Page page ){


        Long totalCount = oecpCaseInfoManager.countOecpCaseInfo(qc);
        qc.setPage(page);
        List<OecpCaseInfoDO> oecpCaseInfos = oecpCaseInfoManager.queryOecpCaseInfo(qc);

        return  BaseResponse.assemblePageResponse(oecpCaseInfos,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpCaseInfo/save")
    @ResponseBody
    public BaseResponse<String> saveOecpCaseInfo(OecpCaseInfoDO oecpCaseInfo){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpCaseInfoManager.saveOecpCaseInfo(oecpCaseInfo);
        baseResponse.setData("OK");
        return  baseResponse;
    }


    
    @GetMapping("/oecpCaseInfo/get")
    @ResponseBody
    public BaseResponse<OecpCaseInfoDO> getOecpCaseInfo(OecpCaseInfoQC qc){
        qc.setPage(Page.getOne());
        List<OecpCaseInfoDO> oecpCaseInfos = oecpCaseInfoManager.queryOecpCaseInfo(qc);
        if(oecpCaseInfos!=null && oecpCaseInfos.size()>0){
            return BaseResponse.success(oecpCaseInfos.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpCaseInfo/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpCaseInfoManager.removeOecpCaseInfoById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
