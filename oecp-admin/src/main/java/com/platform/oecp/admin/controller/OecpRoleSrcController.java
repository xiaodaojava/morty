package com.platform.oecp.admin.controller;

import com.alibaba.fastjson.JSON;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import com.platform.oecp.business.manager.OecpRoleSrcManager;
import com.platform.oecp.models.dos.OecpRoleSrcDO;
import com.platform.oecp.models.qc.OecpRoleSrcQC;
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
public class OecpRoleSrcController  {
    @Autowired
    private OecpRoleSrcManager oecpRoleSrcManager;

    @GetMapping("/oecpRoleSrc/query")
    @ResponseBody
    public BaseResponse<PageData<OecpRoleSrcDO>> queryOecpRoleSrc(OecpRoleSrcQC qc, Page page ){


        Long totalCount = oecpRoleSrcManager.countOecpRoleSrc(qc);
        qc.setPage(page);
        List<OecpRoleSrcDO> oecpRoleSrcs = oecpRoleSrcManager.queryOecpRoleSrc(qc);

        return  BaseResponse.assemblePageResponse(oecpRoleSrcs,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpRoleSrc/save")
    @ResponseBody
    public BaseResponse<String> saveOecpRoleSrc(OecpRoleSrcDO oecpRoleSrc){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpRoleSrcManager.saveOecpRoleSrc(oecpRoleSrc);
        baseResponse.setData("OK");
        return  baseResponse;
    }


    
    @GetMapping("/oecpRoleSrc/get")
    @ResponseBody
    public BaseResponse<OecpRoleSrcDO> getOecpRoleSrc(OecpRoleSrcQC qc){
        qc.setPage(Page.getOne());
        List<OecpRoleSrcDO> oecpRoleSrcs = oecpRoleSrcManager.queryOecpRoleSrc(qc);
        if(oecpRoleSrcs!=null && oecpRoleSrcs.size()>0){
            return BaseResponse.success(oecpRoleSrcs.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpRoleSrc/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpRoleSrcManager.removeOecpRoleSrcById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
