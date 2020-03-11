package com.platform.oecp.admin.controller;

import com.alibaba.fastjson.JSON;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import com.platform.oecp.business.manager.OecpErrorTagManager;
import com.platform.oecp.models.dos.OecpErrorTagDO;
import com.platform.oecp.models.qc.OecpErrorTagQC;
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
public class OecpErrorTagController  {
    @Autowired
    private OecpErrorTagManager oecpErrorTagManager;

    @GetMapping("/oecpErrorTag/query")
    @ResponseBody
    public BaseResponse<PageData<OecpErrorTagDO>> queryOecpErrorTag(OecpErrorTagQC qc, Page page ){


        Long totalCount = oecpErrorTagManager.countOecpErrorTag(qc);
        qc.setPage(page);
        List<OecpErrorTagDO> oecpErrorTags = oecpErrorTagManager.queryOecpErrorTag(qc);

        return  BaseResponse.assemblePageResponse(oecpErrorTags,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpErrorTag/save")
    @ResponseBody
    public BaseResponse<String> saveOecpErrorTag(OecpErrorTagDO oecpErrorTag){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpErrorTagManager.saveOecpErrorTag(oecpErrorTag);
        baseResponse.setData("OK");
        return  baseResponse;
    }


    
    @GetMapping("/oecpErrorTag/get")
    @ResponseBody
    public BaseResponse<OecpErrorTagDO> getOecpErrorTag(OecpErrorTagQC qc){
        qc.setPage(Page.getOne());
        List<OecpErrorTagDO> oecpErrorTags = oecpErrorTagManager.queryOecpErrorTag(qc);
        if(oecpErrorTags!=null && oecpErrorTags.size()>0){
            return BaseResponse.success(oecpErrorTags.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpErrorTag/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpErrorTagManager.removeOecpErrorTagById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
