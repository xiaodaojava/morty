package com.platform.oecp.admin.controller;

import com.alibaba.fastjson.JSON;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import com.platform.oecp.business.manager.OecpSearchSubManager;
import com.platform.oecp.models.dos.OecpSearchSubDO;
import com.platform.oecp.models.qc.OecpSearchSubQC;
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
public class OecpSearchSubController  {
    @Autowired
    private OecpSearchSubManager oecpSearchSubManager;

    @GetMapping("/oecpSearchSub/query")
    @ResponseBody
    public BaseResponse<PageData<OecpSearchSubDO>> queryOecpSearchSub(OecpSearchSubQC qc, Page page ){


        Long totalCount = oecpSearchSubManager.countOecpSearchSub(qc);
        qc.setPage(page);
        List<OecpSearchSubDO> oecpSearchSubs = oecpSearchSubManager.queryOecpSearchSub(qc);

        return  BaseResponse.assemblePageResponse(oecpSearchSubs,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpSearchSub/save")
    @ResponseBody
    public BaseResponse<String> saveOecpSearchSub(OecpSearchSubDO oecpSearchSub){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpSearchSubManager.saveOecpSearchSub(oecpSearchSub);
        baseResponse.setData("OK");
        return  baseResponse;
    }


    
    @GetMapping("/oecpSearchSub/get")
    @ResponseBody
    public BaseResponse<OecpSearchSubDO> getOecpSearchSub(OecpSearchSubQC qc){
        qc.setPage(Page.getOne());
        List<OecpSearchSubDO> oecpSearchSubs = oecpSearchSubManager.queryOecpSearchSub(qc);
        if(oecpSearchSubs!=null && oecpSearchSubs.size()>0){
            return BaseResponse.success(oecpSearchSubs.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpSearchSub/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpSearchSubManager.removeOecpSearchSubById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
