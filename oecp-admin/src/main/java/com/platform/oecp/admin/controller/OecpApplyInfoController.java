package com.platform.oecp.admin.controller;

import com.alibaba.fastjson.JSON;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import com.platform.oecp.business.manager.OecpApplyInfoManager;
import com.platform.oecp.models.dos.OecpApplyInfoDO;
import com.platform.oecp.models.qc.OecpApplyInfoQC;
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
public class OecpApplyInfoController  {
    @Autowired
    private OecpApplyInfoManager oecpApplyInfoManager;

    @GetMapping("/oecpApplyInfo/query")
    @ResponseBody
    public BaseResponse<PageData<OecpApplyInfoDO>> queryOecpApplyInfo(OecpApplyInfoQC qc, Page page ){


        Long totalCount = oecpApplyInfoManager.countOecpApplyInfo(qc);
        qc.setPage(page);
        List<OecpApplyInfoDO> oecpApplyInfos = oecpApplyInfoManager.queryOecpApplyInfo(qc);

        return  BaseResponse.assemblePageResponse(oecpApplyInfos,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpApplyInfo/save")
    @ResponseBody
    public BaseResponse<String> saveOecpApplyInfo(OecpApplyInfoDO oecpApplyInfo){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpApplyInfoManager.saveOecpApplyInfo(oecpApplyInfo);
        baseResponse.setData("OK");
        return  baseResponse;
    }


    
    @GetMapping("/oecpApplyInfo/get")
    @ResponseBody
    public BaseResponse<OecpApplyInfoDO> getOecpApplyInfo(OecpApplyInfoQC qc){
        qc.setPage(Page.getOne());
        List<OecpApplyInfoDO> oecpApplyInfos = oecpApplyInfoManager.queryOecpApplyInfo(qc);
        if(oecpApplyInfos!=null && oecpApplyInfos.size()>0){
            return BaseResponse.success(oecpApplyInfos.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpApplyInfo/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpApplyInfoManager.removeOecpApplyInfoById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
