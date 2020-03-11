package com.platform.oecp.admin.controller;

import com.alibaba.fastjson.JSON;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import com.platform.oecp.business.manager.OecpTagManager;
import com.platform.oecp.models.dos.OecpTagDO;
import com.platform.oecp.models.qc.OecpTagQC;
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
public class OecpTagController  {
    @Autowired
    private OecpTagManager oecpTagManager;

    @GetMapping("/oecpTag/query")
    @ResponseBody
    public BaseResponse<PageData<OecpTagDO>> queryOecpTag(OecpTagQC qc, Page page ){


        Long totalCount = oecpTagManager.countOecpTag(qc);
        qc.setPage(page);
        List<OecpTagDO> oecpTags = oecpTagManager.queryOecpTag(qc);

        return  BaseResponse.assemblePageResponse(oecpTags,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpTag/save")
    @ResponseBody
    public BaseResponse<String> saveOecpTag(OecpTagDO oecpTag){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpTagManager.saveOecpTag(oecpTag);
        baseResponse.setData("OK");
        return  baseResponse;
    }


    
    @GetMapping("/oecpTag/get")
    @ResponseBody
    public BaseResponse<OecpTagDO> getOecpTag(OecpTagQC qc){
        qc.setPage(Page.getOne());
        List<OecpTagDO> oecpTags = oecpTagManager.queryOecpTag(qc);
        if(oecpTags!=null && oecpTags.size()>0){
            return BaseResponse.success(oecpTags.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpTag/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpTagManager.removeOecpTagById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
